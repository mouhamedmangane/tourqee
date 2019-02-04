package com.boutique;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.boutique.mesImages.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class TourqeeApplication extends SpringBootServletInitializer {
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TourqeeApplication.class);
    }
	public static void main(String[] args) {
		SpringApplication.run(TourqeeApplication.class, args);
	}

}
//public class TourqeeApplication  {
//
//	public static void main(String[] args) {
//		SpringApplication.run(TourqeeApplication.class, args);
//	}
//
//}

