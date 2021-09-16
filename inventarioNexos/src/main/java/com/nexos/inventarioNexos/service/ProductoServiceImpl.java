package com.nexos.inventarioNexos.service;

import com.nexos.inventarioNexos.dao.ProductoDao;
import com.nexos.inventarioNexos.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {
    Date fecha = new Date();
    @Autowired
    ProductoDao productoDao;

    @Override
    public Producto createProducto(Producto producto) {
        if (this.existsByNombre(producto.getNombre())) {
            throw new DuplicateKeyException("Error ya existe el producto con nombre: " + producto.getNombre());
        }if(producto.getFecha_ingreso().compareTo(fecha) == 1){
            throw new IllegalArgumentException("La fecha que ingreso no es valida, selecciona una menor");
        }
        return productoDao.createProducto(producto);
    }

    @Override
    public Object updateProducto(Producto producto) { return productoDao.updateProducto(producto); }

    @Override
    public List<Producto> getAllProducto() {
        return productoDao.getAllProducto();
    }

    @Override
    public void deleteProducto(long id) {
        productoDao.deleteProducto(id);
    }

    @Override
    public boolean existsByNombre(String nombre) {
        return productoDao.existsByNombre(nombre);
    }

    @Override
    public Optional<List<Producto>> findBynombre(String nombre) {
        return productoDao.findBynombre(nombre);
    }
}
