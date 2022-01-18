package com.example.animeListAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication() //sets up our local server.
public class AnimeListApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimeListApiApplication.class, args);
	}

}