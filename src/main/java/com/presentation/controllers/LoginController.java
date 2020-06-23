package com.presentation.controllers;

import com.business.responses.LoginResponse;
import com.business.services.LoginService;
import com.domain.repositories.UserRepositoryImpl;
import com.presentation.config.LocalStorage;
import com.presentation.screens.login.LoginScreen;
import com.presentation.screens.main.MainScreen;
import lombok.Getter;

import javax.swing.*;
import java.awt.event.ActionListener;

@Getter
public class LoginController {

    private LoginService loginService;
    private LoginScreen loginScreen;

    public LoginController() {
        loginScreen = new LoginScreen();

        try {
            if (LocalStorage.getInstance().get("env") != "mock") {
                loginService = new LoginService(new UserRepositoryImpl());
            } else {
                // TODO: impl mock repo
                // loginService = new LoginService(new UserRepositoryMock());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        addListeners();
    }

    public void show() {
        loginScreen.setLocationRelativeTo(null);
        loginScreen.setVisible(true);
    }

    private void addListeners() {
        loginScreen.getLoginBtn()
                .addActionListener(loginBtnListener());
    }

    private ActionListener loginBtnListener() {
        return event -> {
            try {
                String email = loginScreen.getEmailField().getText();
                String psw = new String(loginScreen.getPasswordField().getPassword());
                LoginResponse response = loginService.authenticate(email, psw);

                if (response == LoginResponse.SUCCESS) {
                    loginScreen.setVisible(false);
                    MainScreen.main();
                } else if (response == LoginResponse.FAILURE) {
                    JOptionPane.showMessageDialog(null, "Wrong credentials !");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        };
    }
}
