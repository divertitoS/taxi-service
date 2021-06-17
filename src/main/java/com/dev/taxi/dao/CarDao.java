package com.dev.taxi.dao;

import com.dev.taxi.model.Car;
import java.util.List;

public interface CarDao extends GenericDao<Car> {
    List<Car> getAllByDriver(Long driverId);
}
