package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.combobox.ComboBox
import com.vaadin.flow.component.combobox.ComboBoxBase
import com.vaadin.flow.component.combobox.ComboBoxVariant
import com.vaadin.flow.component.combobox.MultiSelectComboBox
import com.vaadin.flow.component.combobox.MultiSelectComboBoxVariant

// ============================================
// ComboBoxBase extensions (shared by ComboBox and MultiSelectComboBox)
// ============================================

/**
 * Reactive autofocus for ComboBoxBase.
 */
@JvmName("comboBoxBaseAutofocusSignal")
fun <T : ComboBoxBase<*, *, *>> T.autofocus(signal: Signal<Boolean>): T {
    fun apply(autofocus: Boolean) {
        isAutofocus = autofocus
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive page size for ComboBoxBase.
 */
@JvmName("comboBoxBasePageSizeSignal")
fun <T : ComboBoxBase<*, *, *>> T.pageSize(signal: Signal<Int>): T {
    fun apply(pageSize: Int) {
        setPageSize(pageSize)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive opened state for ComboBoxBase.
 */
@JvmName("comboBoxBaseOpenedSignal")
fun <T : ComboBoxBase<*, *, *>> T.opened(signal: Signal<Boolean>): T {
    fun apply(opened: Boolean) {
        isOpened = opened
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive allow custom value for ComboBoxBase.
 */
@JvmName("comboBoxBaseAllowCustomValueSignal")
fun <T : ComboBoxBase<*, *, *>> T.allowCustomValue(signal: Signal<Boolean>): T {
    fun apply(allow: Boolean) {
        isAllowCustomValue = allow
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive required indicator for ComboBoxBase.
 */
@JvmName("comboBoxBaseRequiredSignal")
fun <T : ComboBoxBase<*, *, *>> T.required(signal: Signal<Boolean>): T {
    fun apply(required: Boolean) {
        isRequired = required
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive clear button visibility for ComboBoxBase.
 */
@JvmName("comboBoxBaseClearButtonVisibleSignal")
fun <T : ComboBoxBase<*, *, *>> T.clearButtonVisible(signal: Signal<Boolean>): T {
    fun apply(visible: Boolean) {
        isClearButtonVisible = visible
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive auto open for ComboBoxBase.
 */
@JvmName("comboBoxBaseAutoOpenSignal")
fun <T : ComboBoxBase<*, *, *>> T.autoOpen(signal: Signal<Boolean>): T {
    fun apply(autoOpen: Boolean) {
        isAutoOpen = autoOpen
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive overlay class name for ComboBoxBase.
 */
@JvmName("comboBoxBaseOverlayClassNameSignal")
fun <T : ComboBoxBase<*, *, *>> T.overlayClassName(signal: Signal<String>): T {
    fun apply(className: String) {
        overlayClassName = className
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

// ============================================
// ComboBox-specific extensions
// ============================================

/**
 * Reactive pattern for ComboBox.
 */
@JvmName("comboBoxPatternSignal")
fun <TItem> ComboBox<TItem>.pattern(signal: Signal<String?>): ComboBox<TItem> {
    fun apply(pattern: String?) {
        setPattern(pattern)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive overlay width for ComboBox.
 */
@JvmName("comboBoxOverlayWidthSignal")
fun <TItem> ComboBox<TItem>.overlayWidth(signal: Signal<String?>): ComboBox<TItem> {
    fun apply(width: String?) {
        setOverlayWidth(width)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive theme variants for ComboBox.
 */
@JvmName("comboBoxThemeVariantsSignal")
fun <TItem> ComboBox<TItem>.themeVariants(signal: Signal<Set<ComboBoxVariant>>): ComboBox<TItem> {
    var previousVariants = emptySet<ComboBoxVariant>()

    fun apply(variants: Set<ComboBoxVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive single theme variant for ComboBox.
 */
@JvmName("comboBoxThemeVariantSignal")
fun <TItem> ComboBox<TItem>.themeVariant(signal: Signal<ComboBoxVariant?>): ComboBox<TItem> {
    var previousVariant: ComboBoxVariant? = null

    fun apply(variant: ComboBoxVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive small size for ComboBox.
 */
@JvmName("comboBoxSmallSignal")
fun <TItem> ComboBox<TItem>.small(signal: Signal<Boolean>): ComboBox<TItem> {
    fun apply(isSmall: Boolean) {
        if (isSmall) {
            addThemeVariants(ComboBoxVariant.LUMO_SMALL)
        } else {
            removeThemeVariants(ComboBoxVariant.LUMO_SMALL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive helper above field for ComboBox.
 */
@JvmName("comboBoxHelperAboveFieldSignal")
fun <TItem> ComboBox<TItem>.helperAboveField(signal: Signal<Boolean>): ComboBox<TItem> {
    fun apply(isAbove: Boolean) {
        if (isAbove) {
            addThemeVariants(ComboBoxVariant.LUMO_HELPER_ABOVE_FIELD)
        } else {
            removeThemeVariants(ComboBoxVariant.LUMO_HELPER_ABOVE_FIELD)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

// ============================================
// MultiSelectComboBox-specific extensions
// ============================================

/**
 * Reactive selected items on top for MultiSelectComboBox.
 */
@JvmName("multiSelectComboBoxSelectedItemsOnTopSignal")
fun <TItem> MultiSelectComboBox<TItem>.selectedItemsOnTop(signal: Signal<Boolean>): MultiSelectComboBox<TItem> {
    fun apply(onTop: Boolean) {
        isSelectedItemsOnTop = onTop
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive keep filter for MultiSelectComboBox.
 */
@JvmName("multiSelectComboBoxKeepFilterSignal")
fun <TItem> MultiSelectComboBox<TItem>.keepFilter(signal: Signal<Boolean>): MultiSelectComboBox<TItem> {
    fun apply(keep: Boolean) {
        isKeepFilter = keep
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive auto expand mode for MultiSelectComboBox.
 */
@JvmName("multiSelectComboBoxAutoExpandSignal")
fun <TItem> MultiSelectComboBox<TItem>.autoExpand(signal: Signal<MultiSelectComboBox.AutoExpandMode>): MultiSelectComboBox<TItem> {
    fun apply(mode: MultiSelectComboBox.AutoExpandMode) {
        setAutoExpand(mode)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive overlay width for MultiSelectComboBox.
 */
@JvmName("multiSelectComboBoxOverlayWidthSignal")
fun <TItem> MultiSelectComboBox<TItem>.overlayWidth(signal: Signal<String?>): MultiSelectComboBox<TItem> {
    fun apply(width: String?) {
        setOverlayWidth(width)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive theme variants for MultiSelectComboBox.
 */
@JvmName("multiSelectComboBoxThemeVariantsSignal")
fun <TItem> MultiSelectComboBox<TItem>.themeVariants(signal: Signal<Set<MultiSelectComboBoxVariant>>): MultiSelectComboBox<TItem> {
    var previousVariants = emptySet<MultiSelectComboBoxVariant>()

    fun apply(variants: Set<MultiSelectComboBoxVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive single theme variant for MultiSelectComboBox.
 */
@JvmName("multiSelectComboBoxThemeVariantSignal")
fun <TItem> MultiSelectComboBox<TItem>.themeVariant(signal: Signal<MultiSelectComboBoxVariant?>): MultiSelectComboBox<TItem> {
    var previousVariant: MultiSelectComboBoxVariant? = null

    fun apply(variant: MultiSelectComboBoxVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive small size for MultiSelectComboBox.
 */
@JvmName("multiSelectComboBoxSmallSignal")
fun <TItem> MultiSelectComboBox<TItem>.small(signal: Signal<Boolean>): MultiSelectComboBox<TItem> {
    fun apply(isSmall: Boolean) {
        if (isSmall) {
            addThemeVariants(MultiSelectComboBoxVariant.LUMO_SMALL)
        } else {
            removeThemeVariants(MultiSelectComboBoxVariant.LUMO_SMALL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive helper above field for MultiSelectComboBox.
 */
@JvmName("multiSelectComboBoxHelperAboveFieldSignal")
fun <TItem> MultiSelectComboBox<TItem>.helperAboveField(signal: Signal<Boolean>): MultiSelectComboBox<TItem> {
    fun apply(isAbove: Boolean) {
        if (isAbove) {
            addThemeVariants(MultiSelectComboBoxVariant.LUMO_HELPER_ABOVE_FIELD)
        } else {
            removeThemeVariants(MultiSelectComboBoxVariant.LUMO_HELPER_ABOVE_FIELD)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
