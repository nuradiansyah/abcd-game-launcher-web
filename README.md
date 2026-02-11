# Game Launcher Web

A simple web application to launch Chess Game and Memory Game JAR files from a browser.

## Features
- Simple web interface with two game buttons
- Runs on localhost (restricted network)
- Launches JAR files with one click
- No modifications needed to existing game projects

## Prerequisites
- Java 11 or higher
- Maven (or use Eclipse's built-in Maven)

## JAR Files Configured
- Chess Game: chess_game_project/chess_2026-02-11.jar
- Memory Game: memory_game_project_extended/memory_game_2026-02-10.jar

## How to Run

### Option A: Using Eclipse (Recommended)
1. In Eclipse: File → Import → Existing Maven Projects
2. Browse to: game-launcher-web folder
3. Click Finish
4. Right-click on GameLauncherApplication.java
5. Run As → Java Application
6. Open browser: http://localhost:8080

### Option B: Using Command Line
```bash
cd game-launcher-web
mvn spring-boot:run
```

Then open your browser to: **http://localhost:8080**

## Usage

1. Start the web launcher
2. Open http://localhost:8080 in any browser
3. Click on "Chess Game" or "Memory Game" button
4. The game window will open automatically

## Customization

If you move your JAR files, edit the paths in:
`src/main/java/com/game/launcher/GameLauncherController.java`

## Network Access

By default, runs on localhost only. To allow access from other machines in your network:

1. Edit `src/main/resources/application.properties`
2. Add: `server.address=0.0.0.0`
3. Restart the application
4. Access from other machines: `http://YOUR-IP-ADDRESS:8080`
