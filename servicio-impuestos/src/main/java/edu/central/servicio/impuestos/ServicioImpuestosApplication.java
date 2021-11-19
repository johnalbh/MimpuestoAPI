package edu.central.servicio.impuestos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"edu.central.common_impuesto_bien.model"})
public class ServicioImpuestosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicioImpuestosApplication.class, args);
    }

}
