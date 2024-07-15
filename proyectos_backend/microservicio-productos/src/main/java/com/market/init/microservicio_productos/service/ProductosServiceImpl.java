package com.market.init.microservicio_productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.init.microservicio_productos.model.Categoria;
import com.market.init.microservicio_productos.model.Producto;
import com.market.init.microservicio_productos.persistence.CategoriasRepository;
import com.market.init.microservicio_productos.persistence.ProductosRepository;

@Service
public class ProductosServiceImpl implements ProductosService{
    @Autowired
    CategoriasRepository categoriasRepository;

    @Autowired
    ProductosRepository productosRepository;

    @Override
    public List<Categoria> categorias() {
        return categoriasRepository.findAll();
    }

    @Override
    public List<Producto> productosPorCategoria(int idCategoria) {
        return productosRepository.findByIdCategoria(idCategoria);
    }

    @Override
    public Producto actualizarStock(int idProducto, int unidades) {
        Producto producto=productoPorCodigo(idProducto);
        if(producto!=null&producto.getStock()>=unidades) {
            producto.setStock(producto.getStock()-unidades);
            productosRepository.save(producto);
            return producto;
        }
        return null;
    }

    @Override
    public Producto productoPorCodigo(int idProducto) {
        return productosRepository.findById(idProducto).orElse(null);
    }
}
