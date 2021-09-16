package com.nexos.inventarioNexos.service;

import com.nexos.inventarioNexos.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario createUsuario(Usuario usuario);
    List<Usuario> getAllUsuario();
}
