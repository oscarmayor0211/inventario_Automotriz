package com.nexos.inventarioNexos.dao;

import com.nexos.inventarioNexos.model.Cargo;

import java.util.List;

public interface CargoDao {
    Cargo createCargo( Cargo cargo);
    List<Cargo> getAllCargos();
}
