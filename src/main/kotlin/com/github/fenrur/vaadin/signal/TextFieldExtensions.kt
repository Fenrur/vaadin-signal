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
@JvmName("textFieldValueTwoWay")
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
@JvmName("textAreaValueTwoWay")
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
@JvmName("passwordFieldValueTwoWay")
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
@JvmName("emailFieldValueTwoWay")
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
@JvmName("numberFieldValueTwoWay")
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
@JvmName("integerFieldValueTwoWay")
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
@JvmName("bigDecimalFieldValueTwoWay")
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
fun BigDecimalField.errorMessage(signal: Signal<String>) {
    fun apply(message: String) {
        setErrorMessage(message)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
}
