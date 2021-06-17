package com.dev.taxi.service.impl;

import com.dev.taxi.dao.ManufacturerDao;
import com.dev.taxi.lib.Inject;
import com.dev.taxi.lib.Service;
import com.dev.taxi.model.Manufacturer;
import com.dev.taxi.service.ManufacturerService;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Inject
    private ManufacturerDao manufacturerDao;

    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        return manufacturerDao.create(manufacturer);
    }

    @Override
    public Manufacturer get(Long id) {
        return manufacturerDao.get(id).get();
    }

    @Override
    public List<Manufacturer> getAll() {
        return manufacturerDao.getAll();
    }

    @Override
    public Manufacturer update(Manufacturer manufacturer) {
        return manufacturerDao.update(manufacturer);
    }

    @Override
    public boolean delete(Long id) {
        return manufacturerDao.delete(id);
    }
}
