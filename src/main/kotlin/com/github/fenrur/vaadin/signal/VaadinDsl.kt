package com.github.fenrur.vaadin.signal

/**
 * Marker annotation for Vaadin DSL functions.
 */
@DslMarker
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE, AnnotationTarget.FUNCTION)
annotation class VaadinDsl
