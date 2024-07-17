package com.market.init.microservicio_pedidos.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.init.microservicio_pedidos.model.ElementosPedido;

public interface ElementosPedidosRepository extends JpaRepository<ElementosPedido, Integer>{
    
}
