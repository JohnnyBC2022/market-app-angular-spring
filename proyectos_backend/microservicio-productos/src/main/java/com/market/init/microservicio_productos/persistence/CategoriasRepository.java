package com.market.init.microservicio_productos.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.init.microservicio_productos.model.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {
    
}
