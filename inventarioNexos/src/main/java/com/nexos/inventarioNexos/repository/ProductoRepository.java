package com.nexos.inventarioNexos.repository;

import com.nexos.inventarioNexos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository  extends JpaRepository<Producto,Long> {
    boolean existsByNombre(String nombre);
    Optional<List<Producto>> findBynombre(String nombre);

}
