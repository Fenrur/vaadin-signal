package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.Signal
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
fun <T : ComboBoxBase<*, *, *>> T.autofocus(signal: Signal<Boolean>) {
    fun apply(autofocus: Boolean) {
        isAutofocus = autofocus
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive page size for ComboBoxBase.
 */
@JvmName("comboBoxBasePageSizeSignal")
fun <T : ComboBoxBase<*, *, *>> T.pageSize(signal: Signal<Int>) {
    fun apply(pageSize: Int) {
        setPageSize(pageSize)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive opened state for ComboBoxBase.
 */
@JvmName("comboBoxBaseOpenedSignal")
fun <T : ComboBoxBase<*, *, *>> T.opened(signal: Signal<Boolean>) {
    fun apply(opened: Boolean) {
        isOpened = opened
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive allow custom value for ComboBoxBase.
 */
@JvmName("comboBoxBaseAllowCustomValueSignal")
fun <T : ComboBoxBase<*, *, *>> T.allowCustomValue(signal: Signal<Boolean>) {
    fun apply(allow: Boolean) {
        isAllowCustomValue = allow
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive required indicator for ComboBoxBase.
 */
@JvmName("comboBoxBaseRequiredSignal")
fun <T : ComboBoxBase<*, *, *>> T.required(signal: Signal<Boolean>) {
    fun apply(required: Boolean) {
        isRequired = required
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive clear button visibility for ComboBoxBase.
 */
@JvmName("comboBoxBaseClearButtonVisibleSignal")
fun <T : ComboBoxBase<*, *, *>> T.clearButtonVisible(signal: Signal<Boolean>) {
    fun apply(visible: Boolean) {
        isClearButtonVisible = visible
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive auto open for ComboBoxBase.
 */
@JvmName("comboBoxBaseAutoOpenSignal")
fun <T : ComboBoxBase<*, *, *>> T.autoOpen(signal: Signal<Boolean>) {
    fun apply(autoOpen: Boolean) {
        isAutoOpen = autoOpen
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive overlay class name for ComboBoxBase.
 */
@JvmName("comboBoxBaseOverlayClassNameSignal")
fun <T : ComboBoxBase<*, *, *>> T.overlayClassName(signal: Signal<String>) {
    fun apply(className: String) {
        overlayClassName = className
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

// ============================================
// ComboBox-specific extensions
// ============================================

/**
 * Reactive value for ComboBox.
 * Note: This is a one-way binding (signal to component).
 */
@JvmName("comboBoxValueSignal")
fun <TItem> ComboBox<TItem>.value(signal: Signal<TItem?>) {
    fun apply(value: TItem?) {
        setValue(value)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive pattern for ComboBox.
 */
@JvmName("comboBoxPatternSignal")
fun <TItem> ComboBox<TItem>.pattern(signal: Signal<String?>) {
    fun apply(pattern: String?) {
        setPattern(pattern)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive overlay width for ComboBox.
 */
@JvmName("comboBoxOverlayWidthSignal")
fun <TItem> ComboBox<TItem>.overlayWidth(signal: Signal<String?>) {
    fun apply(width: String?) {
        setOverlayWidth(width)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive theme variants for ComboBox.
 */
@JvmName("comboBoxThemeVariantsSignal")
fun <TItem> ComboBox<TItem>.themeVariants(signal: Signal<Set<ComboBoxVariant>>) {
    var previousVariants = emptySet<ComboBoxVariant>()

    fun apply(variants: Set<ComboBoxVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive single theme variant for ComboBox.
 */
@JvmName("comboBoxThemeVariantSignal")
fun <TItem> ComboBox<TItem>.themeVariant(signal: Signal<ComboBoxVariant?>) {
    var previousVariant: ComboBoxVariant? = null

    fun apply(variant: ComboBoxVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive small size for ComboBox.
 */
@JvmName("comboBoxSmallSignal")
fun <TItem> ComboBox<TItem>.small(signal: Signal<Boolean>) {
    fun apply(isSmall: Boolean) {
        if (isSmall) {
            addThemeVariants(ComboBoxVariant.LUMO_SMALL)
        } else {
            removeThemeVariants(ComboBoxVariant.LUMO_SMALL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive helper above field for ComboBox.
 */
@JvmName("comboBoxHelperAboveFieldSignal")
fun <TItem> ComboBox<TItem>.helperAboveField(signal: Signal<Boolean>) {
    fun apply(isAbove: Boolean) {
        if (isAbove) {
            addThemeVariants(ComboBoxVariant.LUMO_HELPER_ABOVE_FIELD)
        } else {
            removeThemeVariants(ComboBoxVariant.LUMO_HELPER_ABOVE_FIELD)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

// ============================================
// MultiSelectComboBox-specific extensions
// ============================================

/**
 * Reactive value for MultiSelectComboBox.
 * Note: This is a one-way binding (signal to component).
 */
@JvmName("multiSelectComboBoxValueSignal")
fun <TItem> MultiSelectComboBox<TItem>.value(signal: Signal<Set<TItem>>) {
    fun apply(value: Set<TItem>) {
        setValue(value)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive selected items on top for MultiSelectComboBox.
 */
@JvmName("multiSelectComboBoxSelectedItemsOnTopSignal")
fun <TItem> MultiSelectComboBox<TItem>.selectedItemsOnTop(signal: Signal<Boolean>) {
    fun apply(onTop: Boolean) {
        isSelectedItemsOnTop = onTop
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive keep filter for MultiSelectComboBox.
 */
@JvmName("multiSelectComboBoxKeepFilterSignal")
fun <TItem> MultiSelectComboBox<TItem>.keepFilter(signal: Signal<Boolean>) {
    fun apply(keep: Boolean) {
        isKeepFilter = keep
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive auto expand mode for MultiSelectComboBox.
 */
@JvmName("multiSelectComboBoxAutoExpandSignal")
fun <TItem> MultiSelectComboBox<TItem>.autoExpand(signal: Signal<MultiSelectComboBox.AutoExpandMode>) {
    fun apply(mode: MultiSelectComboBox.AutoExpandMode) {
        setAutoExpand(mode)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive overlay width for MultiSelectComboBox.
 */
@JvmName("multiSelectComboBoxOverlayWidthSignal")
fun <TItem> MultiSelectComboBox<TItem>.overlayWidth(signal: Signal<String?>) {
    fun apply(width: String?) {
        setOverlayWidth(width)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive theme variants for MultiSelectComboBox.
 */
@JvmName("multiSelectComboBoxThemeVariantsSignal")
fun <TItem> MultiSelectComboBox<TItem>.themeVariants(signal: Signal<Set<MultiSelectComboBoxVariant>>) {
    var previousVariants = emptySet<MultiSelectComboBoxVariant>()

    fun apply(variants: Set<MultiSelectComboBoxVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive single theme variant for MultiSelectComboBox.
 */
@JvmName("multiSelectComboBoxThemeVariantSignal")
fun <TItem> MultiSelectComboBox<TItem>.themeVariant(signal: Signal<MultiSelectComboBoxVariant?>) {
    var previousVariant: MultiSelectComboBoxVariant? = null

    fun apply(variant: MultiSelectComboBoxVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive small size for MultiSelectComboBox.
 */
@JvmName("multiSelectComboBoxSmallSignal")
fun <TItem> MultiSelectComboBox<TItem>.small(signal: Signal<Boolean>) {
    fun apply(isSmall: Boolean) {
        if (isSmall) {
            addThemeVariants(MultiSelectComboBoxVariant.LUMO_SMALL)
        } else {
            removeThemeVariants(MultiSelectComboBoxVariant.LUMO_SMALL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive helper above field for MultiSelectComboBox.
 */
@JvmName("multiSelectComboBoxHelperAboveFieldSignal")
fun <TItem> MultiSelectComboBox<TItem>.helperAboveField(signal: Signal<Boolean>) {
    fun apply(isAbove: Boolean) {
        if (isAbove) {
            addThemeVariants(MultiSelectComboBoxVariant.LUMO_HELPER_ABOVE_FIELD)
        } else {
            removeThemeVariants(MultiSelectComboBoxVariant.LUMO_HELPER_ABOVE_FIELD)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
