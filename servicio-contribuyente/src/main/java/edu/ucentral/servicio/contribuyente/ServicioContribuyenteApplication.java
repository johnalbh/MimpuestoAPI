package edu.ucentral.servicio.contribuyente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"edu.central.common_impuesto_bien.model"})
public class ServicioContribuyenteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicioContribuyenteApplication.class, args);
    }

}
