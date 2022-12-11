package com.JuanJonathanJSleepRJ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.JuanJonathanJSleepRJ.dbjson.JsonDBEngine;

/**
 * JSleep Class -
 * Main class for the package which launches SpringBoot.
 * @author juanjonathan67
 * @version 1.0.0
 */
@SpringBootApplication
public class JSleep
{    
    /**
     * Main method which launches SpringBoot and Json Database.
     * @param args Arguments when JSleep is run
     */
    public static void main(String[] args) {
        JsonDBEngine.Run(JSleep.class);
        SpringApplication.run(JSleep.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
    }
}
