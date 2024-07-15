package com.market.init.microservicio_productos.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.init.microservicio_productos.model.Producto;
import java.util.List;


public interface ProductosRepository  extends JpaRepository<Producto, Integer>{
    List<Producto> findByIdCategoria(int idCategoria);
}
