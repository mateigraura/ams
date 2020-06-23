package com.presentation.screens.panels;

import com.presentation.screens.tables.AirlinesTableScreen;
import lombok.Getter;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import java.awt.*;

@Getter
public class AirlinesPanelScreen {

    private JPanel airlinesPanel;
    private JLabel createAirlineBtn;
    private JLabel airlinesTextLabel;
    private JSeparator airlinesCreateSeparator;
    private AirlinesTableScreen airlinesTableScreen;

    public AirlinesPanelScreen() {
        initComponents();
    }

    private void initComponents() {
        airlinesPanel = new JPanel();
        createAirlineBtn = new JLabel();
        airlinesTextLabel = new JLabel();
        airlinesCreateSeparator = new JSeparator();
        airlinesTableScreen = new AirlinesTableScreen();

        airlinesPanel.setBackground(new Color(238, 238, 238));
        airlinesPanel.setLayout(new AbsoluteLayout());

        createAirlineBtn.setBackground(new Color(238, 238, 238));
        createAirlineBtn.setFont(new Font("Segoe UI", 1, 22));
        createAirlineBtn.setForeground(new Color(109, 150, 244));
        createAirlineBtn.setText("+ NEW AIRLINE");

        airlinesPanel.add(createAirlineBtn, new AbsoluteConstraints(780, 260, 180, 70));

        airlinesPanel.add(airlinesTableScreen.getAirlinesTableScroll(), new AbsoluteConstraints(30, 40, 660, 490));

        airlinesCreateSeparator.setBackground(new Color(205, 205, 205));
        airlinesCreateSeparator.setForeground(new Color(205, 205, 205));

        airlinesPanel.add(airlinesCreateSeparator, new AbsoluteConstraints(770, 260, 200, 10));

        airlinesTextLabel.setBackground(new Color(91, 91, 91));
        airlinesTextLabel.setFont(new Font("Segoe UI", 1, 24));
        airlinesTextLabel.setForeground(new Color(109, 150, 244));
        airlinesTextLabel.setText("AIRLINES");

        airlinesPanel.add(airlinesTextLabel, new AbsoluteConstraints(810, 200, 140, 50));
    }
}
