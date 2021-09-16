package com.nexos.inventarioNexos.dao;

import com.nexos.inventarioNexos.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoDao {
    Producto createProducto( Producto producto);
    Producto updateProducto( Producto producto);
    List<Producto> getAllProducto();
    void deleteProducto(long id);

    boolean existsByNombre(String nombre);
    Optional<List<Producto>> findBynombre(String nombre);
}
