package com.github.fenrur.vaadin.signal

import com.vaadin.flow.component.Component
import com.vaadin.flow.component.UI

inline fun UI.immediateOrAccess(crossinline block: () -> Unit) {
    if (session.hasLock()) {
        block()
    } else {
        access { block() }
    }
}

inline fun Component.immediateOrAccess(crossinline block: () -> Unit) {
    this.ui.orElseThrow().immediateOrAccess(block)
}
