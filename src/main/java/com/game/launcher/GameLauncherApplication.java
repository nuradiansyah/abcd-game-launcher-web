package com.game.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameLauncherApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameLauncherApplication.class, args);
        System.out.println("Game Launcher running at: http://localhost:8080");
    }
}
