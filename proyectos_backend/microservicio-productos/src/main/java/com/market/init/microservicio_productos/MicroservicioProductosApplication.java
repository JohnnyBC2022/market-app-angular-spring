package com.market.init.microservicio_productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class MicroservicioProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioProductosApplication.class, args);
	}

}

/* 
@EntityScan(basePackages = "com.market.init.microservicio_productos.model")
@EnableJpaRepositories(basePackages = "com.market.init.microservicio_productos.persistence")
@SpringBootApplication(scanBasePackages = {"com.market.init.microservicio_productos.service", "com.market.init.microservicio_productos.controller"})
public class MicroservicioProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioProductosApplication.class, args);
	}

} */


