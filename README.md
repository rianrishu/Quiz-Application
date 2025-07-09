# Quiz Application

A modern Android quiz application built with Jetpack Compose that demonstrates the implementation of MVVM architecture using the latest Android development tools and libraries.

## SnapShot
[quiz app execution.webm](https://github.com/user-attachments/assets/65d1b4ec-1983-4f68-aefc-5b5bc44a8cbb)

## Download Apk
https://drive.google.com/file/d/1-VJz-E79VgjIZqBH0p9_hVXyg0ygRPZ-/view?usp=sharing

## Features

- Dynamic quiz questions loaded from API
- Real-time score tracking
- Streak counter with special achievements
- Immediate feedback on answers
- Clean and intuitive UI
- Result summary with statistics

## Tech Stack

- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM (Model-View-ViewModel)
- **Dependency Injection**: Hilt
- **Networking**: Retrofit
- **Concurrency**: Kotlin Coroutines
- **State Management**: StateFlow
- **Language**: Kotlin

## Architecture

The application follows the MVVM (Model-View-ViewModel) architecture pattern:

- **Model**: Handles data operations through Repository and API services
- **View**: Composed of Jetpack Compose UI components
- **ViewModel**: Manages UI-related data, handles business logic and state management

## Project Structure

```
app/
├── data/
│   ├── model/          # Data models
│   ├── network/        # API interfaces
│   └── repository/     # Data repositories
└── ui/
    ├── screens/        # Compose UI screens
    ├── theme/          # App theme and styling
    └── MainActivity.kt # Entry point
```

## Dependencies

- Jetpack Compose
- Hilt for dependency injection
- Retrofit for network calls
- Kotlin Coroutines and Flow
- Material3 Design components

## Installation

1. Clone the repository:
```bash
git clone [repository-url]
```

2. Open Android Studio

3. Open the project:
   - Go to File -> Open
   - Navigate to the cloned directory
   - Click "OK"

4. Wait for Gradle sync to complete

5. Run the application:
   - Select an Android device/emulator
   - Click the "Run" button (▶️) or press Shift + F10

## Building

1. From Android Studio:
   - Build -> Make Project
   - Wait for the build to complete

2. From command line:
```bash
./gradlew assembleDebug
```

The APK will be generated at `app/build/outputs/apk/debug/app-debug.apk`

## License

[Add your license information here]

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b main`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin main`)
5. Open a Pull Request
