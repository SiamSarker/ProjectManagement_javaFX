# Multi-Client Server System with JavaFX and Socket Programming

This project is a multi-client server system that demonstrates 
communication between clients and a server using Java, JavaFX, and socket 
programming. It includes a leader and team member interaction system with a 
server-side process that handles multiple client connections.

## Features

- Multi-client server system using Java sockets for communication
- JavaFX-based GUI for interaction between clients and server
- Runnable in IntelliJ IDEA with JavaFX configuration
- Server-side socket management to handle multiple client connections

## Demo Video

[![Watch the Demo](https://img.youtube.com/vi/LsZdV9ICpFI/0.jpg)](https://www.youtube.com/watch?v=LsZdV9ICpFI)


## Setup Instructions

### Prerequisites

- Java JDK 23 (or higher)
- IntelliJ IDEA or any Java IDE
- JavaFX SDK 23 (Download from [here](https://gluonhq.com/products/javafx/))

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/SiamSarker/ProjectManagement_javaFX.git
   ```

2. Open the project in IntelliJ IDEA.

3. Configure the JavaFX SDK:
   - Go to `File > Project Structure`.
   - In the `Libraries` section, click `+` and add the path to your JavaFX SDK (e.g., `C:\Program Files\Java\javafx-sdk-23\lib`).

4. Add VM options in your run configuration:
   ```bash
   --module-path "C:\Program Files\Java\javafx-sdk-23\lib" --add-modules javafx.controls,javafx.fxml
   ```

5. Build and run the project:
   - Build the project with `Build > Build Project`.
   - Run the `Leader` and `ServerCode` classes as necessary. The server class will establish socket connections and allow clients to communicate through it.

## Running the Application

1. First, run the `ServerCode` to start the server. This will create a socket to listen for client connections.
2. Then, run the `Leader` and other team members to connect to the server through sockets.

## Socket Communication

The `ServerCode` uses Java sockets to establish a server-client connection. The server listens on a specific port for incoming connections from clients, and each client communicates with the server through this socket connection. The server is responsible for managing multiple connections and relaying messages between clients.
