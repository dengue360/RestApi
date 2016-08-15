/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.dengue360.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Rafael
 */
@Configuration
@EnableAutoConfiguration
@SpringBootApplication
public class Loader {

    public static void main(String[] args) {
        SpringApplication.run(Loader.class, args);
    }
    
}