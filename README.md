# Vaadin Signal

Vaadin integration for the [Signal](https://github.com/fenrur/signal) reactive library.

[![](https://jitpack.io/v/fenrur/vaadin-signal.svg)](https://jitpack.io/#fenrur/vaadin-signal)

## Installation

### Gradle (Kotlin DSL)

```kotlin
repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation("com.github.fenrur:vaadin-signal:1.0.0")
}
```

## Features

### UI Subscription

Subscribe to signals with automatic lifecycle management:

```kotlin
class MyView : VerticalLayout() {
    private val counter = MutableSignal.cow(0)

    init {
        // Subscribe with lifecycle management
        uiSubscribe(counter) { either ->
            either.onRight { value ->
                // Update UI
            }
        }

        // Or use the fluent API
        uiSubscribe(counter).onSuccess { value ->
            // Update UI
        }
    }
}
```

### Effects

Create reactive effects similar to SolidJS:

```kotlin
effect(signal) { value ->
    // Runs when signal changes
}

// Multiple signals
effect(signal1, signal2) { a, b ->
    // Runs when either signal changes
}
```

### Component Extensions

#### Visibility & State

```kotlin
button.visible(isVisibleSignal)
button.enabled(isEnabledSignal)
button.className(classNameSignal)
button.classNameWhen("active", isActiveSignal)
```

#### Form Components

```kotlin
textField.value(textSignal)        // Two-way binding
checkbox.checked(checkedSignal)    // Two-way binding
comboBox.selectedItem(itemSignal)  // Two-way binding
comboBox.items(itemsSignal)        // Reactive items
```

#### Layout

```kotlin
verticalLayout.spacing(spacingSignal)
verticalLayout.padding(paddingSignal)
horizontalLayout.justifyContent(justifyContentSignal)
```

#### Grid

```kotlin
grid.items(itemsSignal)
grid.selectedItem(selectedSignal)      // Two-way binding
grid.selectedItems(multiSelectSignal)  // Two-way binding
grid.loading(isLoadingSignal)
```

#### Dialog

```kotlin
dialog.opened(isOpenedSignal)  // Two-way binding
dialog.headerTitle(titleSignal)
dialog.modal(isModalSignal)
```

### Reactive Lists

Efficient list rendering with minimal DOM updates:

```kotlin
verticalLayout {
    map(itemsSignal) { item ->
        div { text = item.name }
    }
}
```

### Conditional Rendering

```kotlin
whenDiv(conditionSignal) {
    // Content rendered when condition is true
}

show(conditionSignal) {
    button("Click me")
}
```

### Error Boundaries

```kotlin
errorBoundary(
    signal = dataSignal,
    onError = { error ->
        div { text = "Error: ${error.message}" }
    },
    onSuccess = { data ->
        // Render data
    }
)
```

## License

MIT License
