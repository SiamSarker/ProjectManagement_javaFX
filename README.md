# Project Title

This project is a multi-client server system that demonstrates communication between clients and a server using Java and JavaFX. It includes a leader and team member interaction system with a server-side process.

## Features

- Multi-client server system
- JavaFX-based GUI for interaction
- Runnable in IntelliJ IDEA with JavaFX configuration

## Setup Instructions

### Prerequisites

- Java JDK 23 (or higher)
- IntelliJ IDEA or any Java IDE
- JavaFX SDK 23 (Download from [here](https://gluonhq.com/products/javafx/))

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/yourproject.git
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
   - Run the `Leader` and `ServerCode` classes as necessary.

## Running the Application

1. First, run the `ServerCode` to start the server.
2. Then, run the `Leader` and other team members to connect to the server.
