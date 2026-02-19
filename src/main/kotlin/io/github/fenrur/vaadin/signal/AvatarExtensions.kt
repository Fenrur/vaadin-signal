package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.avatar.Avatar
import com.vaadin.flow.component.avatar.AvatarVariant
import com.vaadin.flow.server.AbstractStreamResource

// ============================================
// Avatar extensions
// ============================================

/**
 * Reactive name for Avatar.
 */
@JvmName("avatarNameSignal")
fun Avatar.name(signal: Signal<String?>): Avatar {
    fun apply(name: String?) {
        setName(name)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive abbreviation for Avatar.
 */
@JvmName("avatarAbbreviationSignal")
fun Avatar.abbreviation(signal: Signal<String?>): Avatar {
    fun apply(abbreviation: String?) {
        setAbbreviation(abbreviation)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive image URL for Avatar.
 */
@JvmName("avatarImageSignal")
fun Avatar.image(signal: Signal<String?>): Avatar {
    fun apply(image: String?) {
        setImage(image)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive image resource for Avatar.
 */
@JvmName("avatarImageResourceSignal")
fun Avatar.imageResource(signal: Signal<AbstractStreamResource?>): Avatar {
    fun apply(resource: AbstractStreamResource?) {
        setImageResource(resource)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive color index for Avatar.
 */
@JvmName("avatarColorIndexSignal")
fun Avatar.colorIndex(signal: Signal<Int?>): Avatar {
    fun apply(index: Int?) {
        setColorIndex(index)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive theme variants for Avatar.
 */
@JvmName("avatarThemeVariantsSignal")
fun Avatar.themeVariants(signal: Signal<Set<AvatarVariant>>): Avatar {
    var previousVariants = emptySet<AvatarVariant>()

    fun apply(variants: Set<AvatarVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive single theme variant for Avatar.
 */
@JvmName("avatarThemeVariantSignal")
fun Avatar.themeVariant(signal: Signal<AvatarVariant?>): Avatar {
    var previousVariant: AvatarVariant? = null

    fun apply(variant: AvatarVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive extra large theme for Avatar.
 */
@JvmName("avatarExtraLargeSignal")
fun Avatar.extraLarge(signal: Signal<Boolean>): Avatar {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(AvatarVariant.LUMO_XLARGE)
        } else {
            removeThemeVariants(AvatarVariant.LUMO_XLARGE)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive large theme for Avatar.
 */
@JvmName("avatarLargeSignal")
fun Avatar.large(signal: Signal<Boolean>): Avatar {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(AvatarVariant.LUMO_LARGE)
        } else {
            removeThemeVariants(AvatarVariant.LUMO_LARGE)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive small theme for Avatar.
 */
@JvmName("avatarSmallSignal")
fun Avatar.small(signal: Signal<Boolean>): Avatar {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(AvatarVariant.LUMO_SMALL)
        } else {
            removeThemeVariants(AvatarVariant.LUMO_SMALL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive extra small theme for Avatar.
 */
@JvmName("avatarExtraSmallSignal")
fun Avatar.extraSmall(signal: Signal<Boolean>): Avatar {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(AvatarVariant.LUMO_XSMALL)
        } else {
            removeThemeVariants(AvatarVariant.LUMO_XSMALL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
