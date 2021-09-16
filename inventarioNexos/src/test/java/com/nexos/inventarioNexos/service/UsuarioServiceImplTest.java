package com.nexos.inventarioNexos.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexos.inventarioNexos.model.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.SimpleDateFormat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class UsuarioServiceImplTest {

    private final String URL ="/api/usuario";
    @Autowired
    MockMvc mvc;
    @Test
    public void createUsuario() throws Exception {
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
        String fechaIngreso = "2021/04/14";
        Usuario usuario = new Usuario();
        usuario.setNombre_usuario("Juanito");
        usuario.setEdad(22);
        usuario.setId_cargo(1);
        usuario.setFecha_ingreso(date.parse((fechaIngreso)));
        mvc.perform(post(URL)
            .contentType(MediaType.APPLICATION_JSON)
            .content(toJson(usuario))).andExpect(status().isOk()).andDo(print());
    }

    @Test
    public void usuarioNull() throws Exception {
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
        String fechaIngreso = "2021/04/14";
        Usuario usuario = new Usuario();
        usuario.setNombre_usuario(null);
        usuario.setEdad(22);
        usuario.setId_cargo(1);
        usuario.setFecha_ingreso(date.parse((fechaIngreso)));
        mvc.perform(post(URL).content(toJson(usuario)).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("!NEXOS¡-Se presento un problema, reporte e intente luego."))
                .andDo(print());
    }
    @Test
    public void getAllUsuario() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(URL)).andDo(print());
    }

    public static String toJson(final Object obj){
        try {
            return new ObjectMapper().writeValueAsString(obj);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }
}