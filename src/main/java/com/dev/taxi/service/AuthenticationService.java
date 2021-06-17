package com.dev.taxi.service;

import com.dev.taxi.exception.AuthenticationException;
import com.dev.taxi.model.Driver;

public interface AuthenticationService {
    Driver login(String login, String password) throws AuthenticationException;
}
