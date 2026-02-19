package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.AttachNotifier
import com.vaadin.flow.component.Component
import com.vaadin.flow.component.DetachNotifier
import com.vaadin.flow.component.HasComponents
import com.vaadin.flow.component.html.Div

// ============================================
// Conditional extensions
// ============================================

/**
 * Conditional rendering that shows content when condition is true.
 * Similar to SolidJS Show component.
 *
 * @param condition Signal controlling visibility
 * @param block Content to render when condition is true
 */
@JvmName("hasComponentsWhenDivSignal")
fun <A> A.whenDiv(
    condition: Signal<Boolean>,
    block: @VaadinDsl Div.() -> Unit,
): Div where A : HasComponents, A : AttachNotifier, A : DetachNotifier {
    val div = Div()
    add(div)
    div.visible(condition)
    div.effect(condition) { shouldRender ->
        if (shouldRender) {
            div.block()
        } else {
            div.removeAll()
        }
    }
    return div
}

/**
 * Shows a component based on a condition signal.
 */
@JvmName("hasComponentsShowSignal")
fun <A> A.show(
    condition: Signal<Boolean>,
    block: @VaadinDsl A.() -> Component,
) where A : HasComponents, A : AttachNotifier, A : DetachNotifier {
    val component = block()
    add(component)
    component.visible(condition)
}

/**
 * Creates a loading state with automatic visibility toggle.
 */
@JvmName("hasComponentsLoadingSignal")
fun <A> A.loading(
    isLoadingSignal: Signal<Boolean>,
    loadingComponent: () -> Component,
    block: @VaadinDsl A.() -> Unit,
) where A : HasComponents, A : AttachNotifier, A : DetachNotifier {
    val loadingComp = loadingComponent()
    val contentDiv = Div()

    add(loadingComp)
    add(contentDiv)

    effect(isLoadingSignal, true) { isLoading ->
        loadingComp.isVisible = isLoading
        contentDiv.isVisible = !isLoading

        if (!isLoading && !contentDiv.children.iterator().hasNext()) {
            with(contentDiv as A) { block() }
        }
    }
}

/**
 * Error boundary for handling signal errors gracefully.
 */
@JvmName("hasComponentsErrorBoundarySignal")
fun <A, T> A.errorBoundary(
    signal: Signal<T>,
    onError: (Throwable) -> Component = { error ->
        Div().apply {
            text = "Error: ${error.message}"
            addClassName("error-message")
        }
    },
    onSuccess: A.(T) -> Unit,
) where A : HasComponents, A : AttachNotifier, A : DetachNotifier {
    uiSubscribe(signal, true) { result ->
        removeAll()
        result.fold(
            onSuccess = { value -> onSuccess(value) },
            onFailure = { error -> add(onError(error)) }
        )
    }
}
