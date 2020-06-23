package com.presentation.screens.login;

import com.assets.utils.AssetsPath;
import lombok.Getter;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

@Getter
public class LoginScreen extends JFrame {

    private JPanel loginPanel;
    private JLabel titleIcon;
    private JLabel titleLabel;
    private JLabel emailFieldLabel;
    private JTextField emailField;
    private JLabel passwordFieldLabel;
    private JPasswordField passwordField;
    private JLabel loginTitleLabel;
    private JButton loginBtn;

    public LoginScreen() {
        initComponents();
        initLayout();
        pack();
    }

    private void initComponents() {
        loginPanel = new JPanel();
        titleIcon = new JLabel();
        loginTitleLabel = new JLabel();
        titleLabel = new JLabel();
        emailFieldLabel = new JLabel();
        emailField = new JTextField();
        passwordFieldLabel = new JLabel();
        passwordField = new JPasswordField();
        loginBtn = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        loginPanel.setBackground(new Color(255, 255, 255));
        loginPanel.setLayout(new AbsoluteLayout());

        createIcon();
        loginPanel.add(titleIcon, new AbsoluteConstraints(10, 11, 54, 39));

        createLoginTitleLabel();
        loginPanel.add(loginTitleLabel, new AbsoluteConstraints(110, 90, 110, 86));

        createTitleLabel();
        loginPanel.add(titleLabel, new AbsoluteConstraints(70, 30, 68, -1));

        createEmailFieldLabel();
        loginPanel.add(emailFieldLabel, new AbsoluteConstraints(20, 202, 138, 29));

        createEmailField();
        loginPanel.add(emailField, new AbsoluteConstraints(10, 237, 319, 48));

        createPasswordFieldLabel();
        loginPanel.add(passwordFieldLabel, new AbsoluteConstraints(18, 303, 138, 29));

        passwordField.setBorder(new LineBorder(new Color(153, 153, 153), 1, true));
        loginPanel.add(passwordField, new AbsoluteConstraints(10, 338, 319, 51));

        createLoginBtn();
        loginPanel.add(loginBtn, new AbsoluteConstraints(90, 460, 147, 42));
    }

    private void initLayout() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(loginPanel, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(loginPanel, GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );
    }

    private void createIcon() {
        String iconPath = AssetsPath.getAbsolute("icon.png").toString();
        titleIcon.setIcon(new ImageIcon(iconPath));
    }

    private void createLoginTitleLabel() {
        loginTitleLabel.setFont(new Font("Calibri", 0, 36));
        loginTitleLabel.setForeground(new Color(91, 91, 91));
        loginTitleLabel.setText("Sign In");
    }

    private void createTitleLabel() {
        titleLabel.setFont(new Font("Calibri", 0, 24));
        titleLabel.setForeground(new Color(91, 91, 91));
        titleLabel.setText("AMS");
    }

    private void createEmailFieldLabel() {
        emailFieldLabel.setFont(new Font("Calibri", 0, 18));
        emailFieldLabel.setForeground(new Color(91, 91, 91));
        emailFieldLabel.setText("Email");
    }

    private void createEmailField() {
        emailField.setFont(new Font("Calibri", 0, 18));
        emailField.setForeground(new Color(51, 51, 51));
        emailField.setBorder(new LineBorder(new Color(153, 153, 153), 1, true));
    }

    private void createPasswordFieldLabel() {
        passwordFieldLabel.setFont(new Font("Calibri", 0, 18));
        passwordFieldLabel.setForeground(new Color(91, 91, 91));
        passwordFieldLabel.setText("Password");
    }

    private void createLoginBtn() {
        loginBtn.setBackground(new Color(109, 150, 244));
        loginBtn.setFont(new Font("Calibri", 0, 18));
        loginBtn.setForeground(new Color(255, 255, 255));
        loginBtn.setText("Login");
        loginBtn.setBorder(null);
    }
}
