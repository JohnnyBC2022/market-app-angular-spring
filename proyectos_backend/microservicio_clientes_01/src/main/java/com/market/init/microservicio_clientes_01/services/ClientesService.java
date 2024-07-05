package com.market.init.microservicio_clientes_01.services;

import com.market.init.microservicio_clientes_01.model.Cliente;

public interface ClientesService {
    Cliente autentificarCliente(String usuario, String password);
    boolean registrarCliente(Cliente cliente);
}
