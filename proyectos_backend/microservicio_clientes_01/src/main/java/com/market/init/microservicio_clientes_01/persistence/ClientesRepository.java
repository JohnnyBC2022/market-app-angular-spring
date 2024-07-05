package com.market.init.microservicio_clientes_01.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.init.microservicio_clientes_01.model.Cliente;

public interface ClientesRepository extends JpaRepository<Cliente,String>{
    Cliente findByUsuarioAndPassword(String usuario, String password);
}
