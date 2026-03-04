# Game Launcher Web

A simple web application to launch Chess Game, Memory Game, and Checker Game JAR files from a browser.

## Features
- Simple web interface with three game buttons (Chess, Memory, Checker)
- Automatically detects the latest JAR file for each game (by last modified date)
- Runs on localhost (restricted network)
- Launches JAR files with one click
- No modifications needed to existing game projects

## Prerequisites
- Java 17 or higher
- Maven (or use Eclipse's built-in Maven)

## JAR Files Configured
The launcher automatically finds the latest JAR in each project directory:
- **Chess Game**: `chess_game_project/chess_*.jar` (latest: `chess_2026-03-04.jar`)
- **Memory Game**: `memory_game_project_extended/memory_game_*.jar` (latest: `memory_game_2026-03-04.jar`)
- **Checker Game**: `checker_game_project/checker_*.jar` (latest: `checker_2026-03-04.jar`)

## How to Run

### Option A: Using Eclipse (Recommended)
1. In Eclipse: File → Import → Existing Maven Projects
2. Browse to: game-launcher-web folder
3. Click Finish
4. Right-click on `GameLauncherApplication.java`
5. Run As → Java Application
6. Open browser: http://localhost:8080

### Option B: Using Command Line
```bash
cd game-launcher-web
mvn spring-boot:run
```

### Option C: Using the Startup Script
```bash
cd game-launcher-web
./start-launcher.sh
```

Then open your browser to: **http://localhost:8080**

## Usage

1. Start the web launcher
2. Open http://localhost:8080 in any browser
3. Click on **Chess Game**, **Memory Game**, or **Checker Game** button
4. The game window will open automatically

## Games Overview

| Game | Modes | AI Levels | Leaderboard |
|------|-------|-----------|-------------|
| ♟️ Chess | Two Players, vs Computer | Beginner, Intermediate, Advanced | ✅ Top 10 |
| 🃏 Memory | Two Players | — | ✅ Top 10 |
| 🔴 Checker | Two Players, vs Computer | Beginner, Intermediate | ✅ Top 10 |

## Project Structure
```
game-launcher-web/
├── src/main/java/com/game/launcher/
│   ├── GameLauncherApplication.java    (Spring Boot entry point)
│   └── GameLauncherController.java     (Web controller & JAR launcher)
├── src/main/resources/
│   ├── application.properties          (Server configuration)
│   └── templates/
│       └── index.html                  (Web interface)
├── pom.xml                             (Maven configuration)
├── start-launcher.sh                   (Startup script)
├── stop-port-8080.sh                   (Stop script)
└── README.md                           (This file)
```

## Customization

If you move your JAR files, edit the paths in:
`src/main/java/com/game/launcher/GameLauncherController.java`

## Network Access

By default, runs on localhost only. To allow access from other machines in your network:

1. Edit `src/main/resources/application.properties`
2. Add: `server.address=0.0.0.0`
3. Restart the application
4. Access from other machines: `http://YOUR-IP-ADDRESS:8080`