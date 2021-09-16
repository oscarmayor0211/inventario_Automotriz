package com.nexos.inventarioNexos.dao;

import com.nexos.inventarioNexos.model.Producto;
import com.nexos.inventarioNexos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoDaoImpl implements ProductoDao {
    @Autowired
    ProductoRepository productoRepository;

    @Override
    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProducto(Producto producto) {
        Producto productoUpdate = productoRepository.findById(producto.getId_producto()).orElseThrow(() -> new ResourceAccessException("No se encontro el producto con el id = " + producto.getId_producto()));
        productoUpdate.setId_producto(producto.getId_producto());
        productoUpdate.setNombre(producto.getNombre());
        productoUpdate.setCantidad(producto.getCantidad());
        productoUpdate.setFecha_ingreso(producto.getFecha_ingreso());
        productoUpdate.setId_usuario_modifica(producto.getId_usuario_modifica());
        productoUpdate.setFecha_update(producto.getFecha_update());
        productoRepository.save(producto);
        return productoUpdate;

    }

    @Override
    public List<Producto> getAllProducto() {
        return productoRepository.findAll();
    }

    @Override
    public void deleteProducto(long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new ResourceAccessException("No se encontro el producto con el id = " + id));
        productoRepository.delete(producto);
    }

    @Override
    public boolean existsByNombre(String nombre) {
        return productoRepository.existsByNombre(nombre);
    }

    @Override
    public Optional<List<Producto>> findBynombre(String nombre) {
        return productoRepository.findBynombre(nombre);
    }


}
