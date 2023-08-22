package com.helmihealthcare;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EPrescriptionsApplication {

	public static void main(String[] args) {
		try{
			Runtime.getRuntime().exec("cmd /c start keycloak-18.0.0\\bin\\kc.bat start-dev --http-port=8081");
		} catch (IOException e){
			e.printStackTrace();
		}
		SpringApplication.run(EPrescriptionsApplication.class, args);
	}

}
