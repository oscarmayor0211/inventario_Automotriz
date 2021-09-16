package com.nexos.inventarioNexos.service;

import com.nexos.inventarioNexos.model.Cargo;

import java.util.List;

public interface CargoService {
    Cargo createCargo(Cargo cargo);
    List<Cargo> getAllCargos();

}
