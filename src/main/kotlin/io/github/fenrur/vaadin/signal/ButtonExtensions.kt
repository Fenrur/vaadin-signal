package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.Component
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.button.ButtonVariant

// ============================================
// Button extensions
// ============================================

/**
 * Reactive icon for Button.
 */
@JvmName("buttonIconSignal")
fun Button.icon(signal: Signal<Component?>): Button {
    fun apply(icon: Component?) {
        setIcon(icon)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive icon position (after text or before).
 */
@JvmName("buttonIconAfterTextSignal")
fun Button.iconAfterText(signal: Signal<Boolean>): Button {
    fun apply(after: Boolean) {
        setIconAfterText(after)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive disableOnClick for Button.
 */
@JvmName("buttonDisableOnClickSignal")
fun Button.disableOnClick(signal: Signal<Boolean>): Button {
    fun apply(disable: Boolean) {
        setDisableOnClick(disable)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive theme variants for Button.
 */
@JvmName("buttonThemeVariantsSignal")
fun Button.themeVariants(signal: Signal<Set<ButtonVariant>>): Button {
    var previousVariants = emptySet<ButtonVariant>()

    fun apply(variants: Set<ButtonVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive single theme variant for Button.
 */
@JvmName("buttonThemeVariantSignal")
fun Button.themeVariant(signal: Signal<ButtonVariant?>): Button {
    var previousVariant: ButtonVariant? = null

    fun apply(variant: ButtonVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive primary theme for Button.
 */
@JvmName("buttonPrimarySignal")
fun Button.primary(signal: Signal<Boolean>): Button {
    fun apply(isPrimary: Boolean) {
        if (isPrimary) {
            addThemeVariants(ButtonVariant.LUMO_PRIMARY)
        } else {
            removeThemeVariants(ButtonVariant.LUMO_PRIMARY)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive tertiary theme for Button.
 */
@JvmName("buttonTertiarySignal")
fun Button.tertiary(signal: Signal<Boolean>): Button {
    fun apply(isTertiary: Boolean) {
        if (isTertiary) {
            addThemeVariants(ButtonVariant.LUMO_TERTIARY)
        } else {
            removeThemeVariants(ButtonVariant.LUMO_TERTIARY)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive tertiary-inline theme for Button.
 */
@JvmName("buttonTertiaryInlineSignal")
fun Button.tertiaryInline(signal: Signal<Boolean>): Button {
    fun apply(isTertiaryInline: Boolean) {
        if (isTertiaryInline) {
            addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE)
        } else {
            removeThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive small size for Button.
 */
@JvmName("buttonSmallSignal")
fun Button.small(signal: Signal<Boolean>): Button {
    fun apply(isSmall: Boolean) {
        if (isSmall) {
            addThemeVariants(ButtonVariant.LUMO_SMALL)
        } else {
            removeThemeVariants(ButtonVariant.LUMO_SMALL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive large size for Button.
 */
@JvmName("buttonLargeSignal")
fun Button.large(signal: Signal<Boolean>): Button {
    fun apply(isLarge: Boolean) {
        if (isLarge) {
            addThemeVariants(ButtonVariant.LUMO_LARGE)
        } else {
            removeThemeVariants(ButtonVariant.LUMO_LARGE)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive error theme for Button.
 */
@JvmName("buttonErrorSignal")
fun Button.error(signal: Signal<Boolean>): Button {
    fun apply(isError: Boolean) {
        if (isError) {
            addThemeVariants(ButtonVariant.LUMO_ERROR)
        } else {
            removeThemeVariants(ButtonVariant.LUMO_ERROR)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive success theme for Button.
 */
@JvmName("buttonSuccessSignal")
fun Button.success(signal: Signal<Boolean>): Button {
    fun apply(isSuccess: Boolean) {
        if (isSuccess) {
            addThemeVariants(ButtonVariant.LUMO_SUCCESS)
        } else {
            removeThemeVariants(ButtonVariant.LUMO_SUCCESS)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive contrast theme for Button.
 */
@JvmName("buttonContrastSignal")
fun Button.contrast(signal: Signal<Boolean>): Button {
    fun apply(isContrast: Boolean) {
        if (isContrast) {
            addThemeVariants(ButtonVariant.LUMO_CONTRAST)
        } else {
            removeThemeVariants(ButtonVariant.LUMO_CONTRAST)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
