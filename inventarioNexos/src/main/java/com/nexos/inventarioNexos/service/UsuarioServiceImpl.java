package com.nexos.inventarioNexos.service;

import com.nexos.inventarioNexos.dao.UsuarioDao;
import com.nexos.inventarioNexos.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    UsuarioDao usuarioDao;
    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioDao.createUsuario(usuario);
    }

    @Override
    public List<Usuario> getAllUsuario() {
        return usuarioDao.getAllUsuario();
    }
}
