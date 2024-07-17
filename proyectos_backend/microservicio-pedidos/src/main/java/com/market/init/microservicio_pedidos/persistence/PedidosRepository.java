package com.market.init.microservicio_pedidos.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.init.microservicio_pedidos.model.Pedido;
import java.util.List;


public interface PedidosRepository extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByUsuario(String usuario);
}
