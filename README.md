# Vaadin Signal

🔗 Reactive Vaadin extensions powered by Signals

Make Vaadin **declarative** like TSX/JSX. Describe your UI as code, and let signals handle the reactivity automatically.

[![](https://jitpack.io/v/fenrur/vaadin-signal.svg)](https://jitpack.io/#fenrur/vaadin-signal)

## Why?

Traditional Vaadin code is imperative — you manually update components when state changes:

```kotlin
// ❌ Imperative: manual updates everywhere
val label = Span()
val button = Button("Count: 0")

var count = 0
button.addClickListener {
    count++
    button.text = "Count: $count"
    label.text = if (count > 5) "High!" else ""
    label.isVisible = count > 5
}
```

With Vaadin Signal, you **declare** the relationship between state and UI once:

```kotlin
// ✅ Declarative: UI reacts automatically
val count = mutableSignalOf(0)

button("Count: 0") {
    text(count.map { "Count: $it" })
    onClick { count.update { it + 1 } }
}
span {
    text(count.map { if (it > 5) "High!" else "" })
    visible(count.map { it > 5 })
}
```

## Installation

```kotlin
repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation("com.github.fenrur:vaadin-signal:1.0.0")
}
```

> 📚 This library includes [Signal](https://github.com/fenrur/signal) as a dependency. Make sure to read its documentation to discover all available operators (`map`, `filter`, `combineWith`, `debounce`, etc.).

> 💡 **Recommended**: Use with [Karibu-DSL](https://github.com/mvysny/karibu-dsl) for a fluent, type-safe Kotlin DSL experience. All examples below use Karibu-DSL syntax.

```kotlin
dependencies {
    implementation("com.github.fenrur:vaadin-signal:1.0.0")
    implementation("com.github.mvysny.karibudsl:karibu-dsl:2.2.0")
}
```

## Examples

All standard Vaadin components have signal extensions for their common properties (text, value, visible, enabled, items, etc.).

### Reactive Text & Visibility

```kotlin
val message = mutableSignalOf("Hello")
val showDetails = mutableSignalOf(false)

verticalLayout {
    span {
        text(message)
    }

    button("Toggle") {
        onClick { showDetails.value = !showDetails.value }
    }

    div {
        visible(showDetails)
        text = "These are the details..."
    }
}
```

### Two-Way Form Binding

```kotlin
val username = mutableSignalOf("")
val password = mutableSignalOf("")
val rememberMe = mutableSignalOf(false)

formLayout {
    textField("Username") {
        value(username)
    }

    passwordField("Password") {
        value(password)
    }

    checkbox("Remember me") {
        checked(rememberMe)
    }

    button("Login") {
        // Button enabled only when both fields are filled
        enabled(username.combineWith(password) { u, p ->
            u.isNotBlank() && p.isNotBlank()
        })
        onClick { login(username.value, password.value) }
    }
}
```

### Reactive Lists with `map()`

Efficient list rendering with minimal DOM updates, similar to SolidJS `<For>`.

> ⚠️ **Important**:
> - The item type must properly implement `equals()` and `hashCode()` for efficient diffing. Use `data class` or implement these methods manually.
> - The container calling `map()` must be attached to a parent and should only have `map()` as its child — do not mix with other children.

```kotlin
val todos = mutableSignalOf(listOf<Todo>())

verticalLayout {
    div {
        map(todos) { todo ->
            horizontalLayout {
                checkbox { value = todo.completed }
                span(todo.title)
                button("×") {
                    onClick { todos.value -= todo }
                }
            }
        }
    }
}
```

With index access:

```kotlin
val items = mutableSignalOf(listOf("A", "B", "C"))

verticalLayout {
    div {
        mapIndexed(items) { index, item ->
            span("$index: $item")
        }
    }
}
```

### Conditional Rendering

```kotlin
val isLoggedIn = mutableSignalOf(false)
val isLoading = mutableSignalOf(true)

verticalLayout {
    // Show component when condition is true
    show(isLoggedIn) {
        button("Logout")
    }

    // Conditional block with cleanup
    whenDiv(isLoggedIn) {
        span("Welcome back!")
        userProfile()
    }

    // Loading state
    loading(
        isLoadingSignal = isLoading,
        loadingComponent = { ProgressBar().apply { isIndeterminate = true } }
    ) {
        span("Content loaded!")
    }
}
```

### Grid with Reactive Data

```kotlin
val users = mutableSignalOf(listOf<User>())
val selectedUser = mutableSignalOf<User?>(null)
val isLoading = mutableSignalOf(false)

grid<User> {
    items(users)
    selectedItem(selectedUser)
    loading(isLoading)

    columnFor(User::name)
    columnFor(User::email)
}

// React to selection
effect(selectedUser) { user ->
    user?.let { showUserDetails(it) }
}
```

### Dialog

```kotlin
val isOpen = mutableSignalOf(false)

button("Open Dialog") {
    onClick { isOpen.value = true }
}

dialog {
    opened(isOpen)
    headerTitle(mutableSignalOf("Confirm Action"))

    verticalLayout {
        span("Are you sure?")

        horizontalLayout {
            button("Cancel") {
                onClick { isOpen.value = false }
            }
            button("Confirm") {
                onClick {
                    doAction()
                    isOpen.value = false
                }
            }
        }
    }
}
```

### Derived Signals

```kotlin
val tasks = mutableSignalOf(listOf<Task>())
val filter = mutableSignalOf(Filter.ALL)

// Derived signal: automatically updates when tasks or filter changes
val filteredTasks = tasks.combineWith(filter) { taskList, f ->
    when (f) {
        Filter.ALL -> taskList
        Filter.ACTIVE -> taskList.filter { !it.completed }
        Filter.COMPLETED -> taskList.filter { it.completed }
    }
}

val activeCount = tasks.map { list -> list.count { !it.completed } }

verticalLayout {
    // Filter buttons
    horizontalLayout {
        button("All") { onClick { filter.value = Filter.ALL } }
        button("Active") { onClick { filter.value = Filter.ACTIVE } }
        button("Done") { onClick { filter.value = Filter.COMPLETED } }
    }

    span {
        text(activeCount.map { "$it items left" })
    }

    // Reactive list
    div {
        map(filteredTasks) { task ->
            taskRow(task)
        }
    }
}
```

### Complete Example: Todo App

```kotlin
class TodoView : KComposite() {
    private val todos = mutableSignalOf(listOf<Todo>())
    private val newTodoText = mutableSignalOf("")

    private val root = ui {
        verticalLayout {
            h2("Todo List")

            horizontalLayout {
                textField("New todo") {
                    value(newTodoText)
                }
                button("Add") {
                    enabled(newTodoText.map { it.isNotBlank() })
                    onClick { addTodo() }
                }
            }

            div {
                map(todos) { todo ->
                    horizontalLayout {
                        checkbox { value = todo.completed }
                        span(todo.title)
                        button("×") { onClick { removeTodo(todo) } }
                    }
                }
            }
        }
    }

    private fun addTodo() {
        val text = newTodoText.value
        if (text.isNotBlank()) {
            todos.value += Todo(text)
            newTodoText.value = ""
        }
    }

    private fun removeTodo(todo: Todo) {
        todos.value -= todo
    }
}
```

## License

MIT License
