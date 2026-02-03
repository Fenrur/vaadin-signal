package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.AttachNotifier
import com.vaadin.flow.component.DetachNotifier
import com.vaadin.flow.component.HasTheme

/**
 * Reactive theme name for components with theme support.
 */
@JvmName("hasThemeThemeNameSignal")
fun <C> C.themeName(signal: Signal<String?>): C
        where C : HasTheme, C : AttachNotifier, C : DetachNotifier {
    fun apply(themeName: String?) {
        setThemeName(themeName ?: "")
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive theme names (set) for components with theme support.
 */
@JvmName("hasThemeThemeNamesSignal")
fun <C> C.themeNames(signal: Signal<Set<String>>): C
        where C : HasTheme, C : AttachNotifier, C : DetachNotifier {
    var previousThemes = emptySet<String>()

    fun apply(themes: Set<String>) {
        previousThemes.forEach { removeThemeName(it) }
        themes.forEach { addThemeName(it) }
        previousThemes = themes
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactively adds/removes a theme name based on a boolean condition.
 */
@JvmName("hasThemeThemeNameWhenSignal")
fun <C> C.themeNameWhen(themeName: String, signal: Signal<Boolean>): C
        where C : HasTheme, C : AttachNotifier, C : DetachNotifier {
    fun apply(hasTheme: Boolean) {
        setThemeName(themeName, hasTheme)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
