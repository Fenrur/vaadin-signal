package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.avatar.Avatar
import com.vaadin.flow.component.avatar.AvatarVariant
import com.vaadin.flow.server.AbstractStreamResource

// ============================================
// Avatar extensions
// ============================================

/**
 * Reactive name for Avatar.
 */
fun Avatar.name(signal: Signal<String?>) {
    fun apply(name: String?) {
        setName(name)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive abbreviation for Avatar.
 */
fun Avatar.abbreviation(signal: Signal<String?>) {
    fun apply(abbreviation: String?) {
        setAbbreviation(abbreviation)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive image URL for Avatar.
 */
fun Avatar.image(signal: Signal<String?>) {
    fun apply(image: String?) {
        setImage(image)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive image resource for Avatar.
 */
fun Avatar.imageResource(signal: Signal<AbstractStreamResource?>) {
    fun apply(resource: AbstractStreamResource?) {
        setImageResource(resource)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive color index for Avatar.
 */
fun Avatar.colorIndex(signal: Signal<Int?>) {
    fun apply(index: Int?) {
        setColorIndex(index)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive theme variants for Avatar.
 */
fun Avatar.themeVariants(signal: Signal<Set<AvatarVariant>>) {
    var previousVariants = emptySet<AvatarVariant>()

    fun apply(variants: Set<AvatarVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive single theme variant for Avatar.
 */
fun Avatar.themeVariant(signal: Signal<AvatarVariant?>) {
    var previousVariant: AvatarVariant? = null

    fun apply(variant: AvatarVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive extra large theme for Avatar.
 */
fun Avatar.extraLarge(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(AvatarVariant.LUMO_XLARGE)
        } else {
            removeThemeVariants(AvatarVariant.LUMO_XLARGE)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive large theme for Avatar.
 */
fun Avatar.large(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(AvatarVariant.LUMO_LARGE)
        } else {
            removeThemeVariants(AvatarVariant.LUMO_LARGE)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive small theme for Avatar.
 */
fun Avatar.small(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(AvatarVariant.LUMO_SMALL)
        } else {
            removeThemeVariants(AvatarVariant.LUMO_SMALL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive extra small theme for Avatar.
 */
fun Avatar.extraSmall(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(AvatarVariant.LUMO_XSMALL)
        } else {
            removeThemeVariants(AvatarVariant.LUMO_XSMALL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
