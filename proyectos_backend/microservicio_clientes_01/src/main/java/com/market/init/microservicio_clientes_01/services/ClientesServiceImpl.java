package com.market.init.microservicio_clientes_01.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.init.microservicio_clientes_01.model.Cliente;
import com.market.init.microservicio_clientes_01.persistence.ClientesRepository;

@Service
public class ClientesServiceImpl implements ClientesService {
    
    @Autowired
    ClientesRepository clientesRepository;

    @Override
    public Cliente autentificarCliente(String usuario, String password){
        return clientesRepository.findByUsuarioAndPassword(usuario, password);
    }

    @Override
    public boolean registrarCliente(Cliente cliente){
        if(clientesRepository.findById(cliente.getUsuario()).isPresent()){
            return false;
        }
        clientesRepository.save(cliente);
        return true;
    }
}
