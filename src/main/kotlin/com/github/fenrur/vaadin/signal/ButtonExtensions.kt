package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.Component
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.button.ButtonVariant

// ============================================
// Button extensions
// ============================================

/**
 * Reactive icon for Button.
 */
fun Button.icon(signal: Signal<Component?>) {
    fun apply(icon: Component?) {
        setIcon(icon)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive icon position (after text or before).
 */
fun Button.iconAfterText(signal: Signal<Boolean>) {
    fun apply(after: Boolean) {
        setIconAfterText(after)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive disableOnClick for Button.
 */
fun Button.disableOnClick(signal: Signal<Boolean>) {
    fun apply(disable: Boolean) {
        setDisableOnClick(disable)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive theme variants for Button.
 */
fun Button.themeVariants(signal: Signal<Set<ButtonVariant>>) {
    var previousVariants = emptySet<ButtonVariant>()

    fun apply(variants: Set<ButtonVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive single theme variant for Button.
 */
fun Button.themeVariant(signal: Signal<ButtonVariant?>) {
    var previousVariant: ButtonVariant? = null

    fun apply(variant: ButtonVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive primary theme for Button.
 */
fun Button.primary(signal: Signal<Boolean>) {
    fun apply(isPrimary: Boolean) {
        if (isPrimary) {
            addThemeVariants(ButtonVariant.LUMO_PRIMARY)
        } else {
            removeThemeVariants(ButtonVariant.LUMO_PRIMARY)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive tertiary theme for Button.
 */
fun Button.tertiary(signal: Signal<Boolean>) {
    fun apply(isTertiary: Boolean) {
        if (isTertiary) {
            addThemeVariants(ButtonVariant.LUMO_TERTIARY)
        } else {
            removeThemeVariants(ButtonVariant.LUMO_TERTIARY)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive tertiary-inline theme for Button.
 */
fun Button.tertiaryInline(signal: Signal<Boolean>) {
    fun apply(isTertiaryInline: Boolean) {
        if (isTertiaryInline) {
            addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE)
        } else {
            removeThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive small size for Button.
 */
fun Button.small(signal: Signal<Boolean>) {
    fun apply(isSmall: Boolean) {
        if (isSmall) {
            addThemeVariants(ButtonVariant.LUMO_SMALL)
        } else {
            removeThemeVariants(ButtonVariant.LUMO_SMALL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive large size for Button.
 */
fun Button.large(signal: Signal<Boolean>) {
    fun apply(isLarge: Boolean) {
        if (isLarge) {
            addThemeVariants(ButtonVariant.LUMO_LARGE)
        } else {
            removeThemeVariants(ButtonVariant.LUMO_LARGE)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive error theme for Button.
 */
fun Button.error(signal: Signal<Boolean>) {
    fun apply(isError: Boolean) {
        if (isError) {
            addThemeVariants(ButtonVariant.LUMO_ERROR)
        } else {
            removeThemeVariants(ButtonVariant.LUMO_ERROR)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive success theme for Button.
 */
fun Button.success(signal: Signal<Boolean>) {
    fun apply(isSuccess: Boolean) {
        if (isSuccess) {
            addThemeVariants(ButtonVariant.LUMO_SUCCESS)
        } else {
            removeThemeVariants(ButtonVariant.LUMO_SUCCESS)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive contrast theme for Button.
 */
fun Button.contrast(signal: Signal<Boolean>) {
    fun apply(isContrast: Boolean) {
        if (isContrast) {
            addThemeVariants(ButtonVariant.LUMO_CONTRAST)
        } else {
            removeThemeVariants(ButtonVariant.LUMO_CONTRAST)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
