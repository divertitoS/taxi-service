package com.dev.taxi.service.impl;

import com.dev.taxi.exception.AuthenticationException;
import com.dev.taxi.lib.Injector;
import com.dev.taxi.lib.Service;
import com.dev.taxi.model.Driver;
import com.dev.taxi.service.AuthenticationService;
import com.dev.taxi.service.DriverService;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Injector injector = Injector.getInstance("com/dev/taxi");
    private final DriverService driverService = (DriverService) injector
            .getInstance(DriverService.class);

    @Override
    public Driver login(String login, String password) throws AuthenticationException {
        Optional<Driver> driverWithInputLogin = driverService.findByLogin(login);
        if (driverWithInputLogin.isPresent() && driverWithInputLogin.get()
                .getPassword().equals(password)) {
            return driverWithInputLogin.get();
        }
        throw new AuthenticationException("Username or password is incorrect");
    }
}
