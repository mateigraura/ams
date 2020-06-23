package com.presentation.screens.main;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class SideNavigatorScreen extends JFrame {
    private JPanel leftPanel;
    private JSeparator titleSeparator;
    private JPanel flightsBtn;
    private JLabel flightsBtnLabel;
    private JPanel airlinesBtn;
    private JLabel airlinesBtnLabel;
    private JPanel checkinBtn;
    private JLabel checkinBtnLabel;
    private JPanel issuesBtn;
    private JLabel issuesBtnLabel;

    public SideNavigatorScreen() {
        initComponents();
        initLayout();
        pack();
    }

    private void initComponents() {
        leftPanel = new JPanel();
        titleSeparator = new JSeparator();
        flightsBtn = new JPanel();
        flightsBtnLabel = new JLabel();
        airlinesBtn = new JPanel();
        airlinesBtnLabel = new JLabel();
        checkinBtn = new JPanel();
        checkinBtnLabel = new JLabel();
        issuesBtn = new JPanel();
        issuesBtnLabel = new JLabel();

        leftPanel.setBackground(new Color(91, 91, 91));

        titleSeparator.setBackground(new Color(110, 110, 110));

        createFlightsBtn();
        createAirlinesBtn();
        createDeparturesBtn();
        createIssuesBtn();
    }

    private void initLayout() {
        GroupLayout leftPanelLayout = new GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(leftPanelLayout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(flightsBtn,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                .addComponent(airlinesBtn,
                        GroupLayout.Alignment.TRAILING,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                .addComponent(checkinBtn,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                .addGroup(leftPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleSeparator)
                        .addContainerGap())
                .addComponent(issuesBtn,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
        );
        leftPanelLayout.setVerticalGroup(leftPanelLayout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(leftPanelLayout.createSequentialGroup()
                        .addComponent(titleSeparator,
                                GroupLayout.PREFERRED_SIZE, 10,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(flightsBtn,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(airlinesBtn,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(checkinBtn,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(issuesBtn,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(356, Short.MAX_VALUE))
        );
    }

    private void createFlightsBtn() {
        flightsBtn.setBackground(new Color(91, 91, 91));
        flightsBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        flightsBtnLabel.setBackground(new Color(91, 91, 91));
        flightsBtnLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", 0, 24));
        flightsBtnLabel.setForeground(new Color(223, 223, 226));
        flightsBtnLabel.setText("Flights");

        GroupLayout flightsBtnLayout = new GroupLayout(flightsBtn);
        flightsBtn.setLayout(flightsBtnLayout);
        flightsBtnLayout.setHorizontalGroup(flightsBtnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, flightsBtnLayout.createSequentialGroup()
                        .addContainerGap(51, Short.MAX_VALUE)
                        .addComponent(flightsBtnLabel,
                                GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );
        flightsBtnLayout.setVerticalGroup(flightsBtnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(flightsBtnLabel,
                        GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );
    }

    private void createAirlinesBtn() {
        airlinesBtn.setBackground(new Color(91, 91, 91));
        airlinesBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        airlinesBtnLabel.setBackground(new Color(91, 91, 91));
        airlinesBtnLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", 0, 24));
        airlinesBtnLabel.setForeground(new Color(223, 223, 226));
        airlinesBtnLabel.setText("Airlines");

        GroupLayout airlinesBtnLayout = new GroupLayout(airlinesBtn);
        airlinesBtn.setLayout(airlinesBtnLayout);
        airlinesBtnLayout.setHorizontalGroup(airlinesBtnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, airlinesBtnLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(airlinesBtnLabel,
                                GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );
        airlinesBtnLayout.setVerticalGroup(airlinesBtnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(airlinesBtnLabel,
                        GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );
    }

    private void createDeparturesBtn() {
        checkinBtn.setBackground(new Color(91, 91, 91));
        checkinBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        checkinBtnLabel.setBackground(new Color(91, 91, 91));
        checkinBtnLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", 0, 24));
        checkinBtnLabel.setForeground(new Color(223, 223, 226));
        checkinBtnLabel.setText("Departures");

        GroupLayout checkinBtnLayout = new GroupLayout(checkinBtn);
        checkinBtn.setLayout(checkinBtnLayout);
        checkinBtnLayout.setHorizontalGroup(checkinBtnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, checkinBtnLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkinBtnLabel,
                                GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );
        checkinBtnLayout.setVerticalGroup(checkinBtnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(checkinBtnLabel,
                        GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

    }

    private void createIssuesBtn() {
        issuesBtn.setBackground(new Color(91, 91, 91));
        issuesBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        issuesBtnLabel.setBackground(new Color(91, 91, 91));
        issuesBtnLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", 0, 24));
        issuesBtnLabel.setForeground(new Color(223, 223, 226));
        issuesBtnLabel.setText("Issues");

        GroupLayout issuesBtnLayout = new GroupLayout(issuesBtn);
        issuesBtn.setLayout(issuesBtnLayout);
        issuesBtnLayout.setHorizontalGroup(issuesBtnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, issuesBtnLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(issuesBtnLabel,
                                GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );
        issuesBtnLayout.setVerticalGroup(issuesBtnLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(issuesBtnLabel,
                        GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );
    }
}
