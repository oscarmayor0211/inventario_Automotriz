package com.nexos.inventarioNexos.exception;

import com.nexos.inventarioNexos.model.Producto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RestExceptionHandlerTest {

    @Test
    public void testProductName() {
        try {
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String fechaIngreso = "2021-04-21";
            Producto producto = new Producto();
            producto.setNombre(null);
            producto.setCantidad(12);
            producto.setId_usuario_registro(1);
            producto.setFecha_ingreso(date.parse(fechaIngreso));
        } catch (Exception ex) {
            assertEquals("El nombre no puede ser Null", ex.getMessage());
        }
    }


}