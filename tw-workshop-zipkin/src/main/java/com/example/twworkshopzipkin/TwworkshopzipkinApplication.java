package com.example.twworkshopzipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class TwworkshopzipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwworkshopzipkinApplication.class, args);
	}
}
