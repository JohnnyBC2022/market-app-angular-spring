package com.market.init.microservicio_clientes_01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.market.init.microservicio_clientes_01.model")
@EnableJpaRepositories(basePackages = "com.market.init.microservicio_clientes_01.persistence")
@SpringBootApplication(scanBasePackages = {"com.market.init.microservicio_clientes_01.service","com.market.init.microservicio_clientes_01.controller"})
public class MicroservicioClientes01Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioClientes01Application.class, args);
	}

}
