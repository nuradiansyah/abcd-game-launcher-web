#!/bin/bash
# Game Launcher Web - Startup Script
# This script starts the web launcher server

echo "🎮 Starting Game Launcher Web Server..."
echo "================================================"

cd "$(dirname "$0")"

# Check if Maven is available
if ! command -v mvn &> /dev/null; then
    echo "❌ Maven not found. Please install Maven or use Eclipse to run the application."
    exit 1
fi

# Start the application
echo "🚀 Starting server on http://localhost:8080"
echo "💡 Press Ctrl+C to stop the server"
echo "================================================"
echo ""

mvn spring-boot:run
