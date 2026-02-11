package com.game.launcher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

@Controller
public class GameLauncherController {

    // Directory paths where JAR files are located
    private static final String CHESS_PROJECT_DIR = "../chess_game_project";
    private static final String MEMORY_PROJECT_DIR = "../memory_game_project_extended";

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/launch")
    @ResponseBody
    public String launchGame(@RequestParam("game") String game) {
        try {
            File jarFile;
            String gameName;
            
            if ("chess".equals(game)) {
                jarFile = findLatestJar(CHESS_PROJECT_DIR, "chess");
                gameName = "Chess Game";
            } else if ("memory".equals(game)) {
                jarFile = findLatestJar(MEMORY_PROJECT_DIR, "memory_game");
                gameName = "Memory Game";
            } else {
                return "{\"status\":\"error\",\"message\":\"Invalid game\"}";
            }

            if (jarFile == null || !jarFile.exists()) {
                return "{\"status\":\"error\",\"message\":\"JAR file not found for " + gameName + "\"}";
            }

            // Launch the JAR file
            ProcessBuilder pb = new ProcessBuilder("java", "-jar", jarFile.getAbsolutePath());
            pb.start();
            
            return "{\"status\":\"success\",\"message\":\"" + gameName + " launched successfully! (\" + jarFile.getName() + \")\"}";
            
        } catch (IOException e) {
            return "{\"status\":\"error\",\"message\":\"Error launching game: " + e.getMessage() + "\"}";
        }
    }
    
    /**
     * Finds the latest JAR file in the specified directory matching the given prefix.
     * Sorts by last modified date to get the most recent one.
     * 
     * @param dirPath Directory to search in
     * @param jarPrefix Prefix of the JAR filename (e.g., "chess", "memory_game")
     * @return The latest JAR file, or null if not found
     */
    private File findLatestJar(String dirPath, String jarPrefix) {
        File dir = new File(dirPath);
        
        if (!dir.exists() || !dir.isDirectory()) {
            return null;
        }
        
        File[] jarFiles = dir.listFiles((d, name) -> 
            name.startsWith(jarPrefix) && name.endsWith(".jar")
        );
        
        if (jarFiles == null || jarFiles.length == 0) {
            return null;
        }
        
        // Sort by last modified date (newest first)
        Arrays.sort(jarFiles, Comparator.comparingLong(File::lastModified).reversed());
        
        return jarFiles[0];
    }
}
