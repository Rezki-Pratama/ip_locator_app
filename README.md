# IP Locator App

IP Locator is a cross-platform application built with Kotlin Multiplatform, allowing users to find location information based on IP addresses. The app follows the Clean Architecture principle, ensuring scalability and maintainability.

## Key Features

* Search for location information by IP address.
* Supports multiple platforms (Android, iOS, etc.) using Kotlin Multiplatform.
* Modern, responsive UI built with Compose Multiplatform.

### Architecture
This application is built with a Clean Architecture approach, separating business logic, data layer, and user interface. This modularity makes the codebase easier to test, maintain, and extend with minimal impact on other components.

## Built With

### Kotlin Multiplatform (KMP)
* [Kotlin Multiplatform (KMP)](https://kotlinlang.org/docs/multiplatform.html) - Kotlin Multiplatform allows you to share business logic and core functionalities across different platforms (iOS, Android, etc.) while writing platform-specific code only when necessary.

### Dependency Injection
* [Koin](https://insert-koin.io/) - Koin is a lightweight dependency injection framework for Kotlin developers, making it easier to manage and inject dependencies across the application components.

### HTTP Client
* [Ktor](https://ktor.io/) - Ktor is a framework for building asynchronous servers and clients in Kotlin. It is used here as an HTTP client to send requests to the IP locator API and handle responses efficiently.

### Navigation
* [Voyager](https://github.com/adrielcafe/voyager) - Voyager is a simple, yet powerful navigation library for Jetpack Compose that simplifies navigation handling in Compose applications, providing intuitive routing and transition mechanisms.

### UI Development
* [Compose Multiplatform](https://www.jetbrains.com/compose-multiplatform/) - Compose Multiplatform extends Jetpack Compose beyond Android, allowing developers to build native UIs for iOS, desktop, and web using the same declarative UI framework.

### Reactive Programming
* [Kotlin Flow](https://kotlinlang.org/docs/flow.html) - Kotlin Flow is a reactive stream that can handle both synchronous and asynchronous data streams, making it ideal for handling live data, event streams, and processing data in a sequential and efficient way.