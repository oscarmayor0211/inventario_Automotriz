package com.nexos.inventarioNexos.service;

import com.nexos.inventarioNexos.dao.CargoDao;
import com.nexos.inventarioNexos.model.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CargoServiceImpl implements CargoService{
    @Autowired
    CargoDao cargoDao;
    @Override
    public Cargo createCargo(Cargo cargo) {
        return cargoDao.createCargo(cargo);
    }

    @Override
    public List<Cargo> getAllCargos() {
        return cargoDao.getAllCargos();
    }
}
