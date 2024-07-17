package com.market.init.microservicio_pedidos.service;

import java.util.List;

import com.market.init.microservicio_pedidos.model.ElementosPedido;
import com.market.init.microservicio_pedidos.model.Pedido;

public interface PedidosService {
    List<Pedido> pedidosUsuario(String usuario);

    Pedido guardarPedido(List<ElementosPedido> elementosPedidos, String usuario);
}
