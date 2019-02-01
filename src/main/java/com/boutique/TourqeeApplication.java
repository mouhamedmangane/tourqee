package com.boutique;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.boutique.mesImages.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class TourqeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourqeeApplication.class, args);
	}

}

