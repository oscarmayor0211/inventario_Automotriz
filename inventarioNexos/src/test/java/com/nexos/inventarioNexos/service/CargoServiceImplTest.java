package com.nexos.inventarioNexos.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexos.inventarioNexos.model.Cargo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
public class CargoServiceImplTest {

    private final String URL = "/api/cargo";
    @Autowired
    MockMvc mvc;
    @Test
    public void getAllCargos() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(URL)).andDo(print());
    }

    @Test
    public void createCargo() throws Exception {
        Cargo cargo = new Cargo();
        cargo.setNombre_cargo("Asesor de Ventas");

        mvc.perform(post(URL)
            .contentType(MediaType.APPLICATION_JSON)
            .content(toJson(cargo))).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void cargoNull() throws Exception {
        Cargo cargo = new Cargo();
        cargo.setNombre_cargo(null);

        mvc.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(cargo))).andExpect(status().is5xxServerError()).andDo(print());
    }

    public static String toJson(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}