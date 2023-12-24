package com.example.TP_CRUDGestion_des_Taches;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TpCrudGestionDesTachesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpCrudGestionDesTachesApplication.class, args);
	}

}
