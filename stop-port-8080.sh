#!/bin/bash

# Script to stop all processes running on port 8080

echo "Checking for processes on port 8080..."

# Find processes on port 8080
PIDS=$(lsof -ti:8080)

if [ -z "$PIDS" ]; then
    echo "✅ No processes found running on port 8080"
else
    echo "Found processes: $PIDS"
    echo "Stopping processes..."
    kill -9 $PIDS
    echo "✅ Port 8080 is now free!"
fi
