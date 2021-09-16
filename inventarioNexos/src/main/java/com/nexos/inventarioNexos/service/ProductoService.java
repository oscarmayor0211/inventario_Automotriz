package com.nexos.inventarioNexos.service;

import com.nexos.inventarioNexos.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    Producto createProducto(Producto producto);
    Object updateProducto( Producto producto);
    List<Producto> getAllProducto();
    void deleteProducto(long id);


    boolean existsByNombre(String nombre);
    Optional<List<Producto>> findBynombre(String nombre);

}
