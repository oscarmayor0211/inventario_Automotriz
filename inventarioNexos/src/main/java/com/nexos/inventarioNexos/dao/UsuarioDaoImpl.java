package com.nexos.inventarioNexos.dao;

import com.nexos.inventarioNexos.model.Usuario;
import com.nexos.inventarioNexos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioDaoImpl implements UsuarioDao{
    @Autowired
    UsuarioRepository usuarioRepository;
    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> getAllUsuario() {
        return usuarioRepository.findAll();
    }
}
