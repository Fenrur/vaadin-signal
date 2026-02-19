package io.github.fenrur.vaadin.signal

import io.github.fenrur.signal.Signal
import com.vaadin.flow.component.upload.Upload

// ============================================
// Upload extensions
// ============================================

/**
 * Reactive auto upload for Upload component.
 */
@JvmName("uploadAutoUploadSignal")
fun Upload.autoUpload(signal: Signal<Boolean>): Upload {
    fun apply(enabled: Boolean) {
        isAutoUpload = enabled
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive max files for Upload component.
 */
@JvmName("uploadMaxFilesSignal")
fun Upload.maxFiles(signal: Signal<Int>): Upload {
    fun apply(max: Int) {
        setMaxFiles(max)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive max file size for Upload component.
 */
@JvmName("uploadMaxFileSizeSignal")
fun Upload.maxFileSize(signal: Signal<Int>): Upload {
    fun apply(size: Int) {
        setMaxFileSize(size)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive accepted file types for Upload component.
 */
@JvmName("uploadAcceptedFileTypesSignal")
fun Upload.acceptedFileTypes(signal: Signal<List<String>>): Upload {
    fun apply(types: List<String>) {
        setAcceptedFileTypes(*types.toTypedArray())
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}

/**
 * Reactive drop allowed for Upload component.
 */
@JvmName("uploadDropAllowedSignal")
fun Upload.dropAllowed(signal: Signal<Boolean>): Upload {
    fun apply(allowed: Boolean) {
        setDropAllowed(allowed)
    }

    apply(signal.value)
    effect(signal) { apply(it) }
    return this
}
