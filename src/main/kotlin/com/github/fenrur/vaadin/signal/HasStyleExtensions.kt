package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.AttachNotifier
import com.vaadin.flow.component.DetachNotifier
import com.vaadin.flow.component.HasStyle
import java.util.concurrent.atomic.AtomicReference

// ============================================
// HasStyle extensions
// ============================================

/**
 * Parses a space-separated class name string into a set of individual class names.
 */
private fun parseClassNames(className: String?): Set<String> {
    if (className.isNullOrBlank()) return emptySet()
    return className
        .split("\\s+".toRegex())
        .map { it.trim() }
        .filter { it.isNotBlank() }
        .toSet()
}

/**
 * Reactive CSS class names, accepting both static [String] and reactive [Signal]<[String]> parameters.
 *
 * Static strings are added once. Signals are tracked reactively and properly synchronized
 * with the component lifecycle - classes are applied on attach and updated on signal changes.
 * Each parameter supports space-separated class names (e.g. `"btn btn-primary"`).
 *
 * ```kotlin
 * val theme = mutableSignalOf("dark-mode")
 *
 * button.className("btn btn-primary", theme)
 *
 * theme.value = "light-mode"
 * // "dark-mode" is removed, "light-mode" is added
 * ```
 *
 * @param classNamesElements the class names to apply, each being a [String] or a [Signal]<[String]>
 * @throws IllegalArgumentException if a parameter is neither a [String] nor a [Signal]
 */
@JvmName("hasStyleClassNameSignal")
fun <A> A.className(vararg classNamesElements: Any) where A : HasStyle, A : AttachNotifier, A : DetachNotifier {
    val hasInvalidType = classNamesElements.any { it !is String && it !is Signal<*> }
    require(!hasInvalidType) {
        "className() only accepts String or Signal<String> parameters, but got: ${classNamesElements.map { it::class.simpleName }}"
    }

    for (element in classNamesElements) {
        when (element) {
            is String -> {
                // Static classes: add immediately and permanently
                parseClassNames(element).forEach { addClassName(it) }
            }
            is Signal<*> -> {
                // Track previous classes for this specific signal to handle diffs correctly
                val previousClasses = AtomicReference<Set<String>>(emptySet())

                // Use effect with initialCall=true to sync on attach and handle changes
                effect(element, initialCall = true) { currentValue ->
                    val currentClasses = when (currentValue) {
                        is String -> parseClassNames(currentValue)
                        else -> emptySet() // Non-string values are ignored
                    }

                    val prevClasses = previousClasses.getAndSet(currentClasses)

                    // Only remove classes that this signal previously added
                    val toRemove = prevClasses - currentClasses
                    val toAdd = currentClasses - prevClasses

                    toRemove.forEach { removeClassName(it) }
                    toAdd.forEach { addClassName(it) }
                }
            }
        }
    }
}

/**
 * Reactively adds/removes a CSS class based on a boolean condition.
 */
@JvmName("hasStyleClassNameWhenSignal")
fun <C> C.classNameWhen(className: String, signal: Signal<Boolean>)
        where C : HasStyle, C : AttachNotifier, C : DetachNotifier {
    effect(signal, initialCall = true) { hasClass ->
        if (hasClass) {
            addClassName(className)
        } else {
            removeClassName(className)
        }
    }
}

/**
 * Reactively sets an inline CSS style property.
 */
@JvmName("hasStyleStyleSignal")
fun <C> C.style(property: String, signal: Signal<String>)
        where C : HasStyle, C : AttachNotifier, C : DetachNotifier {
    effect(signal, initialCall = true) { value ->
        style.set(property, value)
    }
}
