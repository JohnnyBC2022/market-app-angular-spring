package com.market.init.microservicio_productos.service;

import java.util.List;

import com.market.init.microservicio_productos.model.Categoria;
import com.market.init.microservicio_productos.model.Producto;

public interface ProductosService {
    List<Categoria> categorias();
    List<Producto> productosPorCategoria(int idCategoria);
    Producto actualizarStock(int idProducto, int unidades);
    Producto productoPorCodigo(int idProducto);
}
