package com.nexos.inventarioNexos.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexos.inventarioNexos.model.Producto;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.SimpleDateFormat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class ProductoServiceImplTest {

    private final String URL = "/api/producto";
    @Autowired
    MockMvc mvc;

    @Order(0)
    @Test
    public void createProducto() throws Exception {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String fechaIngreso = "2021-04-21";
        Producto producto = new Producto();
        producto.setNombre("Mercedez");
        producto.setCantidad(12);
        producto.setId_usuario_registro(1);
        producto.setFecha_ingreso(date.parse(fechaIngreso));

        mvc.perform(post(URL)
            .contentType(MediaType.APPLICATION_JSON)
            .content(toJson(producto))).andExpect(status().isOk()).andDo(print());
    }

    @Order(1)
    @Test
    public void getAllProducto() throws Exception {
        mvc.perform(get(URL)).andDo(print());
    }


    @Order(2)
    @Test
    public void findBynombre() throws Exception {
        mvc.perform(get(URL+"/Renault")).andDo(print());
    }

    @Order(3)
    @Test
    public void nameExiste() throws Exception {
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
        String fechaIngreso = "2021/04/21";
        Producto producto = new Producto();
        producto.setNombre("Renault");
        producto.setCantidad(12);
        producto.setId_usuario_registro(1);
        producto.setFecha_ingreso(date.parse(fechaIngreso));
        mvc.perform(post(URL).content(toJson(producto)).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("!NEXOS¡-Error ya esta existe el producto con nombre: Renault"))
                .andDo(print());
    }

    @Order(4)
    @Test
    public void fechaInvalid() throws Exception {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String fechaIngreso = "2021-10-21";
        Producto producto = new Producto();
        producto.setNombre("Ford");
        producto.setCantidad(12);
        producto.setId_usuario_registro(1);
        producto.setFecha_ingreso(date.parse(fechaIngreso));
        mvc.perform(post(URL).content(toJson(producto)).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("!NEXOS¡-La fecha que ingreso no es valida, selecciona una menor"))
                .andDo(print());
    }
    @Order(5)
    @Test
    public void updateProducto() throws Exception {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String fechaIngreso = "2021-04-21";
        Producto producto = new Producto();
        producto.setNombre("Mercedez");
        producto.setCantidad(1);
        producto.setId_usuario_registro(1);
        producto.setId_usuario_modifica(1);
        producto.setFecha_ingreso(date.parse(fechaIngreso));

        mvc.perform(put(URL+ "/4")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(producto))).andExpect(status().isOk()).andDo(print());
    }

    @Order(6)
    @Test
    public void deleteProducto() throws Exception {
        mvc.perform(delete(URL+"/1")).andDo(print());
    }

    public static String toJson(final Object obj){
        try {
            return new ObjectMapper().writeValueAsString(obj);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}