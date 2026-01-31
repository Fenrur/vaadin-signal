package com.github.fenrur.vaadin.signal

import com.github.fenrur.signal.MutableSignal
import com.github.fenrur.signal.Signal
import com.vaadin.flow.component.textfield.*
import com.vaadin.flow.data.value.ValueChangeMode

// =============================================================================
// TEXTFIELD EXTENSIONS
// =============================================================================

/**
 * Two-way binding for TextField value.
 */
@JvmName("textFieldValueMutableSignal")
fun TextField.value(signal: MutableSignal<String>) {
    value = signal.value

    addValueChangeListener {
        signal.value = it.value
    }

    effect(signal) {
        value = it
    }
}

/**
 * Reactive label for TextField.
 */
@JvmName("textFieldLabelSignal")
fun TextField.label(signal: Signal<String>) {
    fun apply(label: String) {
        setLabel(label)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive placeholder for TextField.
 */
@JvmName("textFieldPlaceholderSignal")
fun TextField.placeholder(signal: Signal<String>) {
    fun apply(placeholder: String) {
        setPlaceholder(placeholder)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive autofocus for TextField.
 */
@JvmName("textFieldAutofocusSignal")
fun TextField.autofocus(signal: Signal<Boolean>) {
    fun apply(autofocus: Boolean) {
        setAutofocus(autofocus)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive autoselect for TextField.
 */
@JvmName("textFieldAutoselectSignal")
fun TextField.autoselect(signal: Signal<Boolean>) {
    fun apply(autoselect: Boolean) {
        setAutoselect(autoselect)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive required for TextField.
 */
@JvmName("textFieldRequiredSignal")
fun TextField.required(signal: Signal<Boolean>) {
    fun apply(required: Boolean) {
        setRequired(required)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive clear button visible for TextField.
 */
@JvmName("textFieldClearButtonVisibleSignal")
fun TextField.clearButtonVisible(signal: Signal<Boolean>) {
    fun apply(visible: Boolean) {
        isClearButtonVisible = visible
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive minLength for TextField.
 */
@JvmName("textFieldMinLengthSignal")
fun TextField.minLength(signal: Signal<Int>) {
    fun apply(minLength: Int) {
        setMinLength(minLength)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive maxLength for TextField.
 */
@JvmName("textFieldMaxLengthSignal")
fun TextField.maxLength(signal: Signal<Int>) {
    fun apply(maxLength: Int) {
        setMaxLength(maxLength)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive pattern for TextField.
 */
@JvmName("textFieldPatternSignal")
fun TextField.pattern(signal: Signal<String>) {
    fun apply(pattern: String) {
        setPattern(pattern)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive invalid state for TextField.
 */
@JvmName("textFieldInvalidSignal")
fun TextField.invalid(signal: Signal<Boolean>) {
    fun apply(invalid: Boolean) {
        setInvalid(invalid)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive error message for TextField.
 */
@JvmName("textFieldErrorMessageSignal")
fun TextField.errorMessage(signal: Signal<String>) {
    fun apply(message: String) {
        setErrorMessage(message)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive readonly for TextField.
 */
@JvmName("textFieldReadonlySignal")
fun TextField.readonly(signal: Signal<Boolean>) {
    fun apply(readonly: Boolean) {
        isReadOnly = readonly
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive theme variants for TextField.
 */
@JvmName("textFieldThemeVariantsSignal")
fun TextField.themeVariants(signal: Signal<Set<TextFieldVariant>>) {
    var previousVariants = emptySet<TextFieldVariant>()

    fun apply(variants: Set<TextFieldVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

// =============================================================================
// TEXTAREA EXTENSIONS
// =============================================================================

/**
 * Two-way binding for TextArea value.
 */
@JvmName("textAreaValueMutableSignal")
fun TextArea.value(signal: MutableSignal<String>) {
    value = signal.value

    addValueChangeListener {
        signal.value = it.value
    }

    effect(signal) {
        value = it
    }
}

/**
 * Reactive label for TextArea.
 */
@JvmName("textAreaLabelSignal")
fun TextArea.label(signal: Signal<String>) {
    fun apply(label: String) {
        setLabel(label)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive placeholder for TextArea.
 */
@JvmName("textAreaPlaceholderSignal")
fun TextArea.placeholder(signal: Signal<String>) {
    fun apply(placeholder: String) {
        setPlaceholder(placeholder)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive required for TextArea.
 */
@JvmName("textAreaRequiredSignal")
fun TextArea.required(signal: Signal<Boolean>) {
    fun apply(required: Boolean) {
        setRequired(required)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive clear button visible for TextArea.
 */
@JvmName("textAreaClearButtonVisibleSignal")
fun TextArea.clearButtonVisible(signal: Signal<Boolean>) {
    fun apply(visible: Boolean) {
        isClearButtonVisible = visible
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive minLength for TextArea.
 */
@JvmName("textAreaMinLengthSignal")
fun TextArea.minLength(signal: Signal<Int>) {
    fun apply(minLength: Int) {
        setMinLength(minLength)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive maxLength for TextArea.
 */
@JvmName("textAreaMaxLengthSignal")
fun TextArea.maxLength(signal: Signal<Int>) {
    fun apply(maxLength: Int) {
        setMaxLength(maxLength)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive invalid state for TextArea.
 */
@JvmName("textAreaInvalidSignal")
fun TextArea.invalid(signal: Signal<Boolean>) {
    fun apply(invalid: Boolean) {
        setInvalid(invalid)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive error message for TextArea.
 */
@JvmName("textAreaErrorMessageSignal")
fun TextArea.errorMessage(signal: Signal<String>) {
    fun apply(message: String) {
        setErrorMessage(message)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive readonly for TextArea.
 */
@JvmName("textAreaReadonlySignal")
fun TextArea.readonly(signal: Signal<Boolean>) {
    fun apply(readonly: Boolean) {
        isReadOnly = readonly
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive theme variants for TextArea.
 */
@JvmName("textAreaThemeVariantsSignal")
fun TextArea.themeVariants(signal: Signal<Set<TextAreaVariant>>) {
    var previousVariants = emptySet<TextAreaVariant>()

    fun apply(variants: Set<TextAreaVariant>) {
        previousVariants.forEach { removeThemeVariants(it) }
        variants.forEach { addThemeVariants(it) }
        previousVariants = variants
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

// =============================================================================
// PASSWORDFIELD EXTENSIONS
// =============================================================================

/**
 * Two-way binding for PasswordField value.
 */
@JvmName("passwordFieldValueMutableSignal")
fun PasswordField.value(signal: MutableSignal<String>) {
    value = signal.value

    addValueChangeListener {
        signal.value = it.value
    }

    effect(signal) {
        value = it
    }
}

/**
 * Reactive label for PasswordField.
 */
@JvmName("passwordFieldLabelSignal")
fun PasswordField.label(signal: Signal<String>) {
    fun apply(label: String) {
        setLabel(label)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive placeholder for PasswordField.
 */
@JvmName("passwordFieldPlaceholderSignal")
fun PasswordField.placeholder(signal: Signal<String>) {
    fun apply(placeholder: String) {
        setPlaceholder(placeholder)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive required for PasswordField.
 */
@JvmName("passwordFieldRequiredSignal")
fun PasswordField.required(signal: Signal<Boolean>) {
    fun apply(required: Boolean) {
        setRequired(required)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive clear button visible for PasswordField.
 */
@JvmName("passwordFieldClearButtonVisibleSignal")
fun PasswordField.clearButtonVisible(signal: Signal<Boolean>) {
    fun apply(visible: Boolean) {
        isClearButtonVisible = visible
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive reveal button visible for PasswordField.
 */
@JvmName("passwordFieldRevealButtonVisibleSignal")
fun PasswordField.revealButtonVisible(signal: Signal<Boolean>) {
    fun apply(visible: Boolean) {
        isRevealButtonVisible = visible
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive invalid state for PasswordField.
 */
@JvmName("passwordFieldInvalidSignal")
fun PasswordField.invalid(signal: Signal<Boolean>) {
    fun apply(invalid: Boolean) {
        setInvalid(invalid)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive error message for PasswordField.
 */
@JvmName("passwordFieldErrorMessageSignal")
fun PasswordField.errorMessage(signal: Signal<String>) {
    fun apply(message: String) {
        setErrorMessage(message)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive readonly for PasswordField.
 */
@JvmName("passwordFieldReadonlySignal")
fun PasswordField.readonly(signal: Signal<Boolean>) {
    fun apply(readonly: Boolean) {
        isReadOnly = readonly
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

// =============================================================================
// EMAILFIELD EXTENSIONS
// =============================================================================

/**
 * Two-way binding for EmailField value.
 */
@JvmName("emailFieldValueMutableSignal")
fun EmailField.value(signal: MutableSignal<String>) {
    value = signal.value

    addValueChangeListener {
        signal.value = it.value
    }

    effect(signal) {
        value = it
    }
}

/**
 * Reactive label for EmailField.
 */
@JvmName("emailFieldLabelSignal")
fun EmailField.label(signal: Signal<String>) {
    fun apply(label: String) {
        setLabel(label)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive placeholder for EmailField.
 */
@JvmName("emailFieldPlaceholderSignal")
fun EmailField.placeholder(signal: Signal<String>) {
    fun apply(placeholder: String) {
        setPlaceholder(placeholder)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive required for EmailField.
 */
@JvmName("emailFieldRequiredSignal")
fun EmailField.required(signal: Signal<Boolean>) {
    fun apply(required: Boolean) {
        setRequired(required)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive clear button visible for EmailField.
 */
@JvmName("emailFieldClearButtonVisibleSignal")
fun EmailField.clearButtonVisible(signal: Signal<Boolean>) {
    fun apply(visible: Boolean) {
        isClearButtonVisible = visible
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive invalid state for EmailField.
 */
@JvmName("emailFieldInvalidSignal")
fun EmailField.invalid(signal: Signal<Boolean>) {
    fun apply(invalid: Boolean) {
        setInvalid(invalid)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive error message for EmailField.
 */
@JvmName("emailFieldErrorMessageSignal")
fun EmailField.errorMessage(signal: Signal<String>) {
    fun apply(message: String) {
        setErrorMessage(message)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

// =============================================================================
// NUMBERFIELD EXTENSIONS
// =============================================================================

/**
 * Two-way binding for NumberField value.
 */
@JvmName("numberFieldValueMutableSignal")
fun NumberField.value(signal: MutableSignal<Double?>) {
    value = signal.value

    addValueChangeListener {
        signal.value = it.value
    }

    effect(signal) {
        value = it
    }
}

/**
 * Reactive label for NumberField.
 */
@JvmName("numberFieldLabelSignal")
fun NumberField.label(signal: Signal<String>) {
    fun apply(label: String) {
        setLabel(label)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive placeholder for NumberField.
 */
@JvmName("numberFieldPlaceholderSignal")
fun NumberField.placeholder(signal: Signal<String>) {
    fun apply(placeholder: String) {
        setPlaceholder(placeholder)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive required for NumberField.
 */
@JvmName("numberFieldRequiredSignal")
fun NumberField.required(signal: Signal<Boolean>) {
    fun apply(required: Boolean) {
        setRequiredIndicatorVisible(required)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive min for NumberField.
 */
@JvmName("numberFieldMinSignal")
fun NumberField.min(signal: Signal<Double>) {
    fun apply(min: Double) {
        setMin(min)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive max for NumberField.
 */
@JvmName("numberFieldMaxSignal")
fun NumberField.max(signal: Signal<Double>) {
    fun apply(max: Double) {
        setMax(max)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive step for NumberField.
 */
@JvmName("numberFieldStepSignal")
fun NumberField.step(signal: Signal<Double>) {
    fun apply(step: Double) {
        setStep(step)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive stepButtonsVisible for NumberField.
 */
@JvmName("numberFieldStepButtonsVisibleSignal")
fun NumberField.stepButtonsVisible(signal: Signal<Boolean>) {
    fun apply(visible: Boolean) {
        setStepButtonsVisible(visible)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive invalid state for NumberField.
 */
@JvmName("numberFieldInvalidSignal")
fun NumberField.invalid(signal: Signal<Boolean>) {
    fun apply(invalid: Boolean) {
        setInvalid(invalid)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive error message for NumberField.
 */
@JvmName("numberFieldErrorMessageSignal")
fun NumberField.errorMessage(signal: Signal<String>) {
    fun apply(message: String) {
        setErrorMessage(message)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

// =============================================================================
// INTEGERFIELD EXTENSIONS
// =============================================================================

/**
 * Two-way binding for IntegerField value.
 */
@JvmName("integerFieldValueMutableSignal")
fun IntegerField.value(signal: MutableSignal<Int?>) {
    value = signal.value

    addValueChangeListener {
        signal.value = it.value
    }

    effect(signal) {
        value = it
    }
}

/**
 * Reactive label for IntegerField.
 */
@JvmName("integerFieldLabelSignal")
fun IntegerField.label(signal: Signal<String>) {
    fun apply(label: String) {
        setLabel(label)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive placeholder for IntegerField.
 */
@JvmName("integerFieldPlaceholderSignal")
fun IntegerField.placeholder(signal: Signal<String>) {
    fun apply(placeholder: String) {
        setPlaceholder(placeholder)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive min for IntegerField.
 */
@JvmName("integerFieldMinSignal")
fun IntegerField.min(signal: Signal<Int>) {
    fun apply(min: Int) {
        setMin(min)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive max for IntegerField.
 */
@JvmName("integerFieldMaxSignal")
fun IntegerField.max(signal: Signal<Int>) {
    fun apply(max: Int) {
        setMax(max)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive step for IntegerField.
 */
@JvmName("integerFieldStepSignal")
fun IntegerField.step(signal: Signal<Int>) {
    fun apply(step: Int) {
        setStep(step)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive stepButtonsVisible for IntegerField.
 */
@JvmName("integerFieldStepButtonsVisibleSignal")
fun IntegerField.stepButtonsVisible(signal: Signal<Boolean>) {
    fun apply(visible: Boolean) {
        setStepButtonsVisible(visible)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive invalid state for IntegerField.
 */
@JvmName("integerFieldInvalidSignal")
fun IntegerField.invalid(signal: Signal<Boolean>) {
    fun apply(invalid: Boolean) {
        setInvalid(invalid)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive error message for IntegerField.
 */
@JvmName("integerFieldErrorMessageSignal")
fun IntegerField.errorMessage(signal: Signal<String>) {
    fun apply(message: String) {
        setErrorMessage(message)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

// =============================================================================
// BIGDECIMALFIELD EXTENSIONS
// =============================================================================

/**
 * Two-way binding for BigDecimalField value.
 */
@JvmName("bigDecimalFieldValueMutableSignal")
fun BigDecimalField.value(signal: MutableSignal<java.math.BigDecimal?>) {
    value = signal.value

    addValueChangeListener {
        signal.value = it.value
    }

    effect(signal) {
        value = it
    }
}

/**
 * Reactive label for BigDecimalField.
 */
@JvmName("bigDecimalFieldLabelSignal")
fun BigDecimalField.label(signal: Signal<String>) {
    fun apply(label: String) {
        setLabel(label)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive placeholder for BigDecimalField.
 */
@JvmName("bigDecimalFieldPlaceholderSignal")
fun BigDecimalField.placeholder(signal: Signal<String>) {
    fun apply(placeholder: String) {
        setPlaceholder(placeholder)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive invalid state for BigDecimalField.
 */
@JvmName("bigDecimalFieldInvalidSignal")
fun BigDecimalField.invalid(signal: Signal<Boolean>) {
    fun apply(invalid: Boolean) {
        setInvalid(invalid)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}

/**
 * Reactive error message for BigDecimalField.
 */
@JvmName("bigDecimalFieldErrorMessageSignal")
fun BigDecimalField.errorMessage(signal: Signal<String>) {
    fun apply(message: String) {
        setErrorMessage(message)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
