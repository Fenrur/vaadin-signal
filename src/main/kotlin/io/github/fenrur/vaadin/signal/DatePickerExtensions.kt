package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.MutableSignal
import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.datepicker.DatePicker
import com.vaadin.flow.component.datepicker.DatePickerVariant
import java.time.LocalDate

// ============================================
// DatePicker extensions
// ============================================

/**
 * Reactive min date for DatePicker.
 */
@JvmName("datePickerMinSignal")
fun DatePicker.min(signal: Signal<LocalDate?>): DatePicker {
    fun apply(min: LocalDate?) {
        setMin(min)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive max date for DatePicker.
 */
@JvmName("datePickerMaxSignal")
fun DatePicker.max(signal: Signal<LocalDate?>): DatePicker {
    fun apply(max: LocalDate?) {
        setMax(max)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive required indicator for DatePicker.
 */
@JvmName("datePickerRequiredSignal")
fun DatePicker.required(signal: Signal<Boolean>): DatePicker {
    fun apply(required: Boolean) {
        isRequired = required
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive clear button visibility for DatePicker.
 */
@JvmName("datePickerClearButtonVisibleSignal")
fun DatePicker.clearButtonVisible(signal: Signal<Boolean>): DatePicker {
    fun apply(visible: Boolean) {
        isClearButtonVisible = visible
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive auto open for DatePicker.
 */
@JvmName("datePickerAutoOpenSignal")
fun DatePicker.autoOpen(signal: Signal<Boolean>): DatePicker {
    fun apply(autoOpen: Boolean) {
        isAutoOpen = autoOpen
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive opened state for DatePicker.
 * Note: This is a one-way binding (signal to component).
 */
@JvmName("datePickerOpenedSignal")
fun DatePicker.opened(signal: Signal<Boolean>): DatePicker {
    fun apply(opened: Boolean) {
        setOpened(opened)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Two-way binding for DatePicker opened state.
 */
@JvmName("datePickerOpenedMutableSignal")
fun DatePicker.opened(signal: MutableSignal<Boolean>): DatePicker {
    setOpened(signal.value)

    addOpenedChangeListener { event ->
        signal.value = event.isOpened
    }

    effect(signal) {
        setOpened(it)
    }
    return this
}

/**
 * Reactive overlay class name for DatePicker.
 */
@JvmName("datePickerOverlayClassNameSignal")
fun DatePicker.overlayClassName(signal: Signal<String>): DatePicker {
    fun apply(className: String) {
        overlayClassName = className
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive theme variants for DatePicker.
 */
@JvmName("datePickerThemeVariantsSignal")
fun DatePicker.themeVariants(signal: Signal<Set<DatePickerVariant>>): DatePicker {
    var previousVariants = emptySet<DatePickerVariant>()

    fun apply(variants: Set<DatePickerVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive single theme variant for DatePicker.
 */
@JvmName("datePickerThemeVariantSignal")
fun DatePicker.themeVariant(signal: Signal<DatePickerVariant?>): DatePicker {
    var previousVariant: DatePickerVariant? = null

    fun apply(variant: DatePickerVariant?) {
        previousVariant?.let { removeThemeVariants(it) }
        variant?.let { addThemeVariants(it) }
        previousVariant = variant
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive small size for DatePicker.
 */
@JvmName("datePickerSmallSignal")
fun DatePicker.small(signal: Signal<Boolean>): DatePicker {
    fun apply(isSmall: Boolean) {
        if (isSmall) {
            addThemeVariants(DatePickerVariant.LUMO_SMALL)
        } else {
            removeThemeVariants(DatePickerVariant.LUMO_SMALL)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive helper above field for DatePicker.
 */
@JvmName("datePickerHelperAboveFieldSignal")
fun DatePicker.helperAboveField(signal: Signal<Boolean>): DatePicker {
    fun apply(isAbove: Boolean) {
        if (isAbove) {
            addThemeVariants(DatePickerVariant.LUMO_HELPER_ABOVE_FIELD)
        } else {
            removeThemeVariants(DatePickerVariant.LUMO_HELPER_ABOVE_FIELD)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive align left for DatePicker.
 */
@JvmName("datePickerAlignLeftSignal")
fun DatePicker.alignLeft(signal: Signal<Boolean>): DatePicker {
    fun apply(alignLeft: Boolean) {
        if (alignLeft) {
            addThemeVariants(DatePickerVariant.LUMO_ALIGN_LEFT)
        } else {
            removeThemeVariants(DatePickerVariant.LUMO_ALIGN_LEFT)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive align center for DatePicker.
 */
@JvmName("datePickerAlignCenterSignal")
fun DatePicker.alignCenter(signal: Signal<Boolean>): DatePicker {
    fun apply(alignCenter: Boolean) {
        if (alignCenter) {
            addThemeVariants(DatePickerVariant.LUMO_ALIGN_CENTER)
        } else {
            removeThemeVariants(DatePickerVariant.LUMO_ALIGN_CENTER)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive align right for DatePicker.
 */
@JvmName("datePickerAlignRightSignal")
fun DatePicker.alignRight(signal: Signal<Boolean>): DatePicker {
    fun apply(alignRight: Boolean) {
        if (alignRight) {
            addThemeVariants(DatePickerVariant.LUMO_ALIGN_RIGHT)
        } else {
            removeThemeVariants(DatePickerVariant.LUMO_ALIGN_RIGHT)
        }
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive readonly state for DatePicker.
 */
@JvmName("datePickerReadonlySignal")
fun DatePicker.readonly(signal: Signal<Boolean>): DatePicker {
    fun apply(readonly: Boolean) {
        isReadOnly = readonly
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive name for DatePicker.
 */
@JvmName("datePickerNameSignal")
fun DatePicker.name(signal: Signal<String>): DatePicker {
    fun apply(name: String) {
        setName(name)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive week numbers visible for DatePicker.
 */
@JvmName("datePickerWeekNumbersVisibleSignal")
fun DatePicker.weekNumbersVisible(signal: Signal<Boolean>): DatePicker {
    fun apply(visible: Boolean) {
        isWeekNumbersVisible = visible
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive initial position for DatePicker.
 */
@JvmName("datePickerInitialPositionSignal")
fun DatePicker.initialPosition(signal: Signal<LocalDate?>): DatePicker {
    fun apply(position: LocalDate?) {
        setInitialPosition(position)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
