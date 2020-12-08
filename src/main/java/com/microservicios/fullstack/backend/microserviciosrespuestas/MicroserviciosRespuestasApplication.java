package com.microservicios.fullstack.backend.microserviciosrespuestas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
//Ya no por que usamos MongoDB
//@EntityScan({"com.microservicios.fullstack.backend.microserviciosrespuestas.models.entity",
//        "com.microservicios.fullstack.backend.commonsexamenes.models.entity",
//        "com.microservicios.fullstack.backend.commonsalumnos.models.entity"})
public class MicroserviciosRespuestasApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviciosRespuestasApplication.class, args);
    }

}
