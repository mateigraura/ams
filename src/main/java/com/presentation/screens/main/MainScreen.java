package com.presentation.screens.main;

import com.presentation.controllers.main.SideNavigatorController;
import com.presentation.controllers.main.TopNavigatorController;
import com.presentation.controllers.panels.AirlinesPanelController;
import com.presentation.controllers.panels.DeparturesPanelController;
import com.presentation.controllers.panels.FlightsPanelController;
import com.presentation.controllers.panels.IssuesPanelController;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

@Getter
public class MainScreen extends JFrame {

    private JPanel mainPanel;
    private JPanel rightPanel;
    private AirlinesPanelController airlinesPanelController;
    private FlightsPanelController flightsPanelController;
    private DeparturesPanelController departuresPanelController;
    private IssuesPanelController issuesPanelController;
    private TopNavigatorController topNavigatorController;
    private SideNavigatorController sideNavigatorController;

    public MainScreen() {
        initComponents();
        initLayout();
        pack();
    }

    private void initComponents() {
        mainPanel = new JPanel();
        rightPanel = new JPanel();
        airlinesPanelController = new AirlinesPanelController();
        flightsPanelController = new FlightsPanelController();
        departuresPanelController = new DeparturesPanelController();
        issuesPanelController = new IssuesPanelController();
        topNavigatorController = new TopNavigatorController();
        sideNavigatorController = new SideNavigatorController();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setLayout(new BorderLayout());

        registerTopNavigator();
        registerSideNavigator();

        rightPanel.setLayout(new CardLayout());

        registerRightPanel();

        mainPanel.add(rightPanel, BorderLayout.CENTER);
    }

    private void initLayout() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 1358, Short.MAX_VALUE)
                .addGroup(layout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 699, Short.MAX_VALUE)
                .addGroup(layout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE))
        );
    }

    private void registerSideNavigator() {
        sideNavigatorController.addPropertyChangeListener(evt -> {
            if (SideNavigatorController.CLICK.equals(evt.getPropertyName())) {
                actOnSideBarClickEventFired((MouseEvent) evt.getNewValue());
            }
        });
        mainPanel.add(
                sideNavigatorController
                        .getSideNavigatorScreen()
                        .getLeftPanel(),
                BorderLayout.LINE_START
        );
    }

    private void registerTopNavigator() {
        mainPanel.add(
                topNavigatorController
                        .getTopNavigatorScreen()
                        .getTopPanel(),
                BorderLayout.PAGE_START
        );
    }

    private void registerRightPanel() {
        rightPanel.add(flightsPanelController
                        .getFlightsPanelScreen()
                        .getFlightsPanel(),
                "card1");
        rightPanel.add(airlinesPanelController
                        .getAirlinesPanelScreen()
                        .getAirlinesPanel(),
                "card2");

        rightPanel.add(departuresPanelController
                        .getDeparturesPanelScreen()
                        .getDeparturesPanel(),
                "card3");

        rightPanel.add(issuesPanelController
                        .getIssuesPanelScreen()
                        .getIssuesPanel(),
                "card4");


        flightsPanelController.show();
    }

    private void actOnSideBarClickEventFired(MouseEvent evt) {
        if (evt.getSource() == sideNavigatorController.getSideNavigatorScreen().getFlightsBtn()) {
            flightsPanelController.show();

            airlinesPanelController.close();
            departuresPanelController.close();
            issuesPanelController.close();
        }
        if (evt.getSource() == sideNavigatorController.getSideNavigatorScreen().getAirlinesBtn()) {
            airlinesPanelController.show();

            flightsPanelController.close();
            departuresPanelController.close();
            issuesPanelController.close();
        }
        if (evt.getSource() == sideNavigatorController.getSideNavigatorScreen().getCheckinBtn()) {
            departuresPanelController.show();

            flightsPanelController.close();
            airlinesPanelController.close();
            issuesPanelController.close();
        }
        if (evt.getSource() == sideNavigatorController.getSideNavigatorScreen().getIssuesBtn()) {
            issuesPanelController.show();

            flightsPanelController.close();
            airlinesPanelController.close();
            departuresPanelController.close();
        }
    }

    public static void main(String... args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        EventQueue.invokeLater(() -> {
            MainScreen mainScreen = new MainScreen();
            mainScreen.setLocationRelativeTo(null);
            mainScreen.setVisible(true);
        });
    }

}
