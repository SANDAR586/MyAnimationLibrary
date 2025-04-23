# 🚀 Android Clean Architecture Boilerplate

A modern Android project demonstrating:
- 🧼 **Clean Architecture**
- 🔄 **MVI (Model-View-Intent)**
- 🧭 **Coordinator Pattern**
- ♻️ **Reusable, testable code**
- ✅ **Unit Testing** from the ground up

---

## 🔧 Tech Stack

- **Kotlin**
- **Jetpack Compose**
- **StateFlow + collectAsStateWithLifecycle**
- **MVI architecture**
- **Custom Coordinator pattern**
- **Unit Testing (JUnit, Turbine)**

---

## 🧱 Architecture Overview

### 🧼 Clean Architecture Layers
- **Presentation (Composable Screens):** stateless, reactive, and focused on rendering.
- **Coordinator:** bridges user intents to domain logic. Isolated, testable, and decoupled.
- **Domain:** business logic lives here. Use cases and interfaces.
- **Data:** APIs, persistence, and network logic.
-
## 🔄 MVI + Coordinator Pattern

- **Model:** The current state of the UI.
- **View:** Composables that observe and react to `State`.
- **Intent:** User actions or UI events.
- **Coordinator:** Handles intents, maps them to use cases, and updates the state.

```kotlin
val uiState by loginCoordinator.loginState.collectAsStateWithLifecycle()
val actionsHandler: (LoginIntent) -> Unit = { action -> 
    loginCoordinator.handleIntent(action)
}