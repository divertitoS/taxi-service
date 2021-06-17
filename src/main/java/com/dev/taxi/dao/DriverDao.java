package com.dev.taxi.dao;

import com.dev.taxi.model.Driver;
import java.util.Optional;

public interface DriverDao extends GenericDao<Driver> {
    Optional<Driver> findByLogin(String login);
}
