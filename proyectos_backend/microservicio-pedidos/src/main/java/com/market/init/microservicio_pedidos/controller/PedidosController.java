package com.market.init.microservicio_pedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market.init.microservicio_pedidos.model.ElementosPedido;
import com.market.init.microservicio_pedidos.model.Pedido;
import com.market.init.microservicio_pedidos.service.PedidosService;

@RestController
public class PedidosController {
    @Autowired
    PedidosService pedidosService;

    @GetMapping("pedidos")
    public ResponseEntity<List<Pedido>> pedidosUsuario(@RequestParam("usuario") String usuario) {
        return new ResponseEntity<>(pedidosService.pedidosUsuario(usuario), HttpStatus.OK);
    }

    @PostMapping("pedido")
    public ResponseEntity<Void> guardarPedido(@RequestBody List<ElementosPedido> elementosPedidos, @RequestParam("usuario") String usuario){
        Pedido pedido = pedidosService.guardarPedido(  elementosPedidos, usuario);
        if (pedido!=null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
