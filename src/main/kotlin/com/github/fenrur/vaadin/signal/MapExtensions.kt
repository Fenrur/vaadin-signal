package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.github.fenrur.signal.operators.map
import com.vaadin.flow.component.Component
import com.vaadin.flow.component.HasComponents
import com.vaadin.flow.component.html.Div

// ============================================
// Map extensions
// ============================================

/**
 * Container for efficient list rendering with minimal DOM updates.
 */
class UiMapContainer<T>(private val topContainer: HasComponents) {
    private data class BufferEntry<T>(var value: T?, val container: Div)

    private val buffer = mutableListOf<BufferEntry<T>>()

    private fun resize(newSize: Int) {
        val oldSize = buffer.size
        if (newSize > oldSize) {
            for (i in oldSize until newSize) {
                val container = Div()
                topContainer.add(container)
                buffer.add(BufferEntry(null, container))
            }
        } else if (newSize < oldSize) {
            for (i in newSize until oldSize) {
                buffer[i].container.removeFromParent()
            }
            buffer.subList(newSize, oldSize).clear()
        }
    }

    private fun diff(elements: List<T>): List<Int> {
        return elements.mapIndexedNotNull { index, element ->
            val prev = buffer[index].value
            if (prev != element) index else null
        }
    }

    fun <C : Component> replaceBy(
        elements: List<T>,
        block: HasComponents.(T) -> C,
    ) {
        resize(elements.size)
        val toUpdate = diff(elements)
        for (index in toUpdate) {
            val entry = buffer[index]
            entry.container.removeAll()
            val component = topContainer.block(elements[index])
            entry.container.add(component)
            entry.value = elements[index]
        }
    }
}

/**
 * Reactive list rendering with efficient updates.
 * Similar to SolidJS For component.
 *
 * @param signal Signal containing the list of items
 * @param initialCall If true, renders immediately
 * @param overrideVisibleTopContainer If true, hides container when list is empty
 * @param block The rendering function for each item
 */
@JvmName("hasComponentsMapSignal")
fun <T, MAPPED_COMP, PARENT> PARENT.map(
    signal: Signal<List<T>>,
    initialCall: Boolean = false,
    overrideVisibleTopContainer: Boolean = true,
    block: @VaadinDsl HasComponents.(T) -> MAPPED_COMP,
) where PARENT : HasComponents, PARENT : Component, MAPPED_COMP : Component {
    if (overrideVisibleTopContainer) {
        visible(signal.map { it.isNotEmpty() })
    }

    val uiMapContainer = UiMapContainer<T>(this)
    effect(signal, initialCall) { values ->
        uiMapContainer.replaceBy(values, block)
    }
}

/**
 * Indexed map for rendering lists with index access.
 */
@JvmName("hasComponentsMapIndexedSignal")
fun <T, MAPPED_COMP, PARENT> PARENT.mapIndexed(
    signal: Signal<List<T>>,
    initialCall: Boolean = false,
    overrideVisibleTopContainer: Boolean = true,
    block: @VaadinDsl HasComponents.(index: Int, item: T) -> MAPPED_COMP,
) where PARENT : HasComponents, PARENT : Component, MAPPED_COMP : Component {
    map(signal, initialCall, overrideVisibleTopContainer) { item ->
        val index = signal.value.indexOf(item)
        block(index, item)
    }
}
