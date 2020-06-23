package com;

import com.presentation.config.DbConnection;
import com.presentation.config.LocalStorage;
import com.presentation.controllers.LoginController;
import com.presentation.utils.JSONUtil;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String... args) {
        String settings;

        if (args.length > 0 && (!args[0].isEmpty() && args[0].contains("settings"))) {
            settings = args[0];
        } else {
            settings = "settings.dev.json";
        }
        LocalStorage.getInstance().set("env", settings);

        try {

            initDatabaseConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        EventQueue.invokeLater(() -> {
            setNativeLookAndFeel();
            new LoginController().show();
        });
    }

    private static void setNativeLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private static void initDatabaseConnection() throws Exception {
        String[] connString = JSONUtil.getDbConnectionFromSettings();

        DbConnection.init(
                connString[0],
                connString[1],
                connString[2]
        );
    }
}
