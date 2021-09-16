package com.nexos.inventarioNexos.controller;

import com.nexos.inventarioNexos.model.Producto;
import com.nexos.inventarioNexos.service.ProductoService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import com.nexos.inventarioNexos.exception.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/producto")
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Producto> getAllProducto(){
        return productoService.getAllProducto();
    }

    @GetMapping("/{nombre}")
    public Optional<List<Producto>> findByProducto(@PathVariable String nombre){
        return productoService.findBynombre(nombre);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object createProducto(@Valid @RequestBody Producto producto, BindingResult result){
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        producto =productoService.createProducto(producto);
        return producto;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> deleteProducto(@PathVariable long id){
        productoService.deleteProducto(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateProducto(@Valid @PathVariable long id, @RequestBody Producto producto,  BindingResult result){
        if (result.hasErrors()) {
            throw new InvalidDataException(result);
        }
        producto.setId_producto(id);
        return ResponseEntity.ok().body(productoService.updateProducto(producto));
    }


}
