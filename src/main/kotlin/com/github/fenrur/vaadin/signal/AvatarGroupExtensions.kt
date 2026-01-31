package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.avatar.AvatarGroup
import com.vaadin.flow.component.avatar.AvatarGroupVariant

// ============================================
// AvatarGroup extensions
// ============================================

/**
 * Reactive items for AvatarGroup.
 */
@JvmName("avatarGroupItemsSignal")
fun AvatarGroup.items(signal: Signal<List<AvatarGroup.AvatarGroupItem>>) {
    fun apply(items: List<AvatarGroup.AvatarGroupItem>) {
        setItems(items)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive max items visible for AvatarGroup.
 */
@JvmName("avatarGroupMaxItemsVisibleSignal")
fun AvatarGroup.maxItemsVisible(signal: Signal<Int?>) {
    fun apply(max: Int?) {
        setMaxItemsVisible(max)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive theme variants for AvatarGroup.
 */
@JvmName("avatarGroupThemeVariantsSignal")
fun AvatarGroup.themeVariants(signal: Signal<Set<AvatarGroupVariant>>) {
    var previousVariants = emptySet<AvatarGroupVariant>()

    fun apply(variants: Set<AvatarGroupVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive single theme variant for AvatarGroup.
 */
@JvmName("avatarGroupThemeVariantSignal")
fun AvatarGroup.themeVariant(signal: Signal<AvatarGroupVariant?>) {
    var previousVariant: AvatarGroupVariant? = null

    fun apply(variant: AvatarGroupVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive extra large theme for AvatarGroup.
 */
@JvmName("avatarGroupExtraLargeSignal")
fun AvatarGroup.extraLarge(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(AvatarGroupVariant.LUMO_XLARGE)
        } else {
            removeThemeVariants(AvatarGroupVariant.LUMO_XLARGE)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive large theme for AvatarGroup.
 */
@JvmName("avatarGroupLargeSignal")
fun AvatarGroup.large(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(AvatarGroupVariant.LUMO_LARGE)
        } else {
            removeThemeVariants(AvatarGroupVariant.LUMO_LARGE)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive small theme for AvatarGroup.
 */
@JvmName("avatarGroupSmallSignal")
fun AvatarGroup.small(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(AvatarGroupVariant.LUMO_SMALL)
        } else {
            removeThemeVariants(AvatarGroupVariant.LUMO_SMALL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive extra small theme for AvatarGroup.
 */
@JvmName("avatarGroupExtraSmallSignal")
fun AvatarGroup.extraSmall(signal: Signal<Boolean>) {
    fun apply(enabled: Boolean) {
        if (enabled) {
            addThemeVariants(AvatarGroupVariant.LUMO_XSMALL)
        } else {
            removeThemeVariants(AvatarGroupVariant.LUMO_XSMALL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
