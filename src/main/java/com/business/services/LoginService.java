package com.business.services;

import com.business.PasswordHash;
import com.business.repositories.UserRepository;
import com.business.responses.LoginResponse;
import com.domain.entities.User;
import com.presentation.config.LocalStorage;

public class LoginService {

    private final UserRepository userRepository;

    public LoginService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LoginResponse authenticate(String email, String password) throws Exception {
        User user = userRepository.getByEmail(email);
        LocalStorage.getInstance().set("id", user.getId());

        return PasswordHash.isValid(user.getPasswordHash(), password) ?
                LoginResponse.SUCCESS : LoginResponse.FAILURE;
    }
}
