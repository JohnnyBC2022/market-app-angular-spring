package com.market.init.microservicio_pedidos.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.market.init.microservicio_pedidos.model.ElementosPedido;
import com.market.init.microservicio_pedidos.model.Pedido;
import com.market.init.microservicio_pedidos.persistence.ElementosPedidosRepository;
import com.market.init.microservicio_pedidos.persistence.PedidosRepository;

@Service
public class PedidosServiceImp  implements PedidosService{

    String urlProducto="http://localhost:8001/";
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    PedidosRepository pedidosRepository;
    @Autowired
    ElementosPedidosRepository elementosPedidosRepository;

    @Override
    public List<Pedido> pedidosUsuario(String usuario) {
        return pedidosRepository.findByUsuario(usuario);
    }

    @Override
    public Pedido guardarPedido(List<ElementosPedido> elementosPedidos, String usuario) {
        try {
        // Creamos el objeto pedido y lo guardamos
        Pedido pedido = new Pedido(0,usuario,new Date(),"pendiente",null);
        Pedido p = pedidosRepository.save(pedido);
        // guardamos los objetos Elementos Pedido (tiene que hacer una llamada a la url de productos, para eso se usa UriComponents Builder)
        elementosPedidos.forEach(e->{
            e.setIdPedidoFK(p.getIdPedido());
            elementosPedidosRepository.save(e);
            // además de guardar el elementosPedido, actualiza el stock del producto correspondiente llamando al recurso del microservicio de productos
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(urlProducto+"productos").queryParam("idProducto", e.getProducto().getIdProducto()).queryParam("unidades",e.getUnidades());
            restTemplate.put(builder.toUriString(), e);
        });
        return pedido;
    } catch(Exception e){
        return null;
    }

    }
    
}
