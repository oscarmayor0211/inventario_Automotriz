package com.nexos.inventarioNexos.dao;

import com.nexos.inventarioNexos.model.Usuario;

import java.util.List;

public interface UsuarioDao {
    Usuario createUsuario(Usuario usuario);
    List<Usuario> getAllUsuario();

}
