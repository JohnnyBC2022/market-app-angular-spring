package com.market.init.microservicio_clientes_01.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private String usuario;
    private String password;
    private String nombre;
    private String direccion;
    private String email;

}
