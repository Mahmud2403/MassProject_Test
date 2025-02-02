# MassProject Test - README  

## Overview  

This project is an Android application that fetches and displays a list of characters from an open API related to the animated series *Rick and Morty*. The app follows the **MVVM (Model-View-ViewModel) architecture** and utilizes modern Android development technologies such as Hilt for dependency injection, Room for local storage, and Flow for handling asynchronous data streams. It efficiently combines network and cached data, ensuring seamless performance even in offline mode.  

## Features  

- **MVVM Architecture** – The app follows the MVVM pattern, ensuring better maintainability and scalability.  
- **Network and Cache Integration** – Data is fetched from the *Rick and Morty API* and stored locally in Room for offline access.  
- **Hilt for Dependency Injection** – Hilt is used to manage dependencies, improving modularity and testability.  
- **Kotlin Flow** – Flow is used to handle asynchronous operations, ensuring smooth and non-blocking data updates.  
- **Jetpack Compose** – The UI is built using Jetpack Compose for a modern and reactive design.  
- **Video Fetching** – The app retrieves character and video data from an open *Rick and Morty API*, offering additional media content.  

## Architecture  

The application follows the **MVVM architecture**, consisting of:  

- **Model (Data Layer)** – Manages data operations, including API requests via Retrofit and local storage via Room.  
- **ViewModel (Business Logic Layer)** – Processes user interactions, retrieves data from the repository, and exposes UI states via Flow.  
- **View (UI Layer)** – Composable functions observe the ViewModel state and update the UI accordingly.  

## Dependencies  

The project utilizes the following key libraries:  

- **Room** – for local data storage.  
- **Retrofit** – for network communication with the *Rick and Morty* API.  
- **Hilt** – for dependency injection.  
- **Kotlin Flow** – for reactive and asynchronous data streams.  
- **Jetpack Compose** – for building the user interface.  
- **Coil** – for efficient image loading.  

## Conclusion  

This project demonstrates the effective use of **MVVM architecture**, combining network and local data sources while utilizing modern Android libraries. It provides an engaging experience by fetching both character and video data from the open *Rick and Morty* API, ensuring smooth and reliable performance.  
