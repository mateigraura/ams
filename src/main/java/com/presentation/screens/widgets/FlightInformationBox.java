package com.presentation.screens.widgets;

import com.assets.utils.AssetsPath;
import lombok.Getter;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.nio.file.Path;

@Getter
public class FlightInformationBox extends JFrame {

    private JLabel airlineAllianceLabel;
    private JLabel airlineAllianceValueLabel;
    private JLabel checkinStatusLabel;
    private JLabel airlineCodeLabel;
    private JLabel airlineCodeValueLabel;
    private JLabel checkinStatusValueLabel;
    private JLabel airlineInfoLabel;
    private JLabel airlineNameLabel;
    private JLabel airlineNameValueLabel;
    private JLabel airplaneInfoLabel;
    private JLabel airplaneModelLabel;
    private JLabel airplaneModelValueLabel;
    private JLabel callSignLabel;
    private JLabel callSignValueLabel;
    private JLabel delayLabel;
    private JLabel delayValueLabel;
    private JLabel departureTimeLabel;
    private JLabel departureTimeValueLabel;
    private JLabel destinationLabel;
    private JLabel destinationValueLabel;
    private JPanel editIssueBox;
    private JLabel flightDateLabel;
    private JLabel flightDateValueLabel;
    private JLabel maintenanceLabel;
    private JLabel maintenanceValueLabel;
    private JLabel passengersLabel;
    private JLabel passengersValueLabel;
    private JLabel planeIdLabel;
    private JLabel planeIdValueLabel;
    private JSeparator separator;
    private JLabel sourceLabel;
    private JLabel sourceValueLabel;
    private JLabel statusLabel;
    private JLabel statusValueLabel;
    private JLabel titleIcon;
    private JLabel titleLabel;

    public FlightInformationBox() {
        initComponents();
        initLayout();
        pack();
    }

    private void initComponents() {

        editIssueBox = new JPanel();
        titleIcon = new JLabel();
        titleLabel = new JLabel();
        sourceLabel = new JLabel();
        destinationLabel = new JLabel();
        statusLabel = new JLabel();
        callSignLabel = new JLabel();
        checkinStatusLabel = new JLabel();
        planeIdLabel = new JLabel();
        flightDateValueLabel = new JLabel();
        departureTimeValueLabel = new JLabel();
        statusValueLabel = new JLabel();
        callSignValueLabel = new JLabel();
        airlineCodeValueLabel = new JLabel();
        planeIdValueLabel = new JLabel();
        passengersLabel = new JLabel();
        passengersValueLabel = new JLabel();
        delayValueLabel = new JLabel();
        delayLabel = new JLabel();
        flightDateLabel = new JLabel();
        airlineNameValueLabel = new JLabel();
        departureTimeLabel = new JLabel();
        destinationValueLabel = new JLabel();
        airlineInfoLabel = new JLabel();
        airlineNameLabel = new JLabel();
        airlineAllianceLabel = new JLabel();
        airlineAllianceValueLabel = new JLabel();
        airplaneInfoLabel = new JLabel();
        maintenanceLabel = new JLabel();
        maintenanceValueLabel = new JLabel();
        sourceValueLabel = new JLabel();
        airplaneModelLabel = new JLabel();
        airplaneModelValueLabel = new JLabel();
        separator = new JSeparator();
        airlineCodeLabel = new JLabel();
        checkinStatusValueLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        editIssueBox.setBackground(new Color(255, 255, 255));

        createIcon();
        createTitleLabel();
        createSourceLabel();
        createDestinationLabel();
        createFlightStatusLabel();
        createCallSignLabel();
        createCheckinStatusLabel();
        createPlaneIdLabel();
        createPassengersLabel();
        createDelayLabel();
        createFlightDateLabel();
        createDepartureTimeLabel();
        createAirlineInfoLabel();
        createAirlineNameLabel();
        createAirlineAllianceLabel();
        createAirplaneInfoLabel();
        createMaintenanceLabel();
        createAirplaneModelLabel();

        createAirplaneModelValueLabel();
        createSourceValueLabel();
        createMaintenanceValueLabel();
        createAirlineCodeLabel();
        createCheckinStatusValueLabel();
        createFlightDateValueLabel();
        createDepartureTimeValueLabel();
        createFlightStatusValueLabel();
        createCallSignValueLabel();
        createAirlineCodeValueLabel();
        createPlaneIdValueLabel();
        createPassengersValueLabel();
        createDelayValueLabel();
        createAirlineNameValueLabel();
        createDestinationValueLabel();
        createAirlineAllianceValueLabel();
    }

    private void initLayout() {
        GroupLayout group = new GroupLayout(editIssueBox);
        editIssueBox.setLayout(group);
        group.setHorizontalGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(group.createSequentialGroup().addGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(group.createSequentialGroup()
                        .addGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(group.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(titleIcon,
                                                GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(titleLabel,
                                                GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
                                .addGroup(group.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(airlineCodeLabel,
                                                GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(airlineCodeValueLabel,
                                                GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 283, Short.MAX_VALUE))
                .addGroup(group.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(group.createSequentialGroup().addGroup(group
                                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(flightDateLabel,
                                                GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sourceLabel,
                                                GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(statusLabel,
                                                GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passengersLabel,
                                                GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(group
                                                .createSequentialGroup().addComponent(flightDateValueLabel,
                                                        GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(departureTimeLabel)
                                                .addGap(11, 11, 11)
                                                .addComponent(departureTimeValueLabel,
                                                        GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                                                .addGroup(group.createSequentialGroup().addGroup(group
                                                        .createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(passengersValueLabel,
                                                                GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(group.createSequentialGroup().addGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(statusValueLabel,
                                                                        GroupLayout.PREFERRED_SIZE, 88,
                                                                        GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(sourceValueLabel,
                                                                        GroupLayout.PREFERRED_SIZE, 80,
                                                                        GroupLayout.PREFERRED_SIZE))
                                                                .addGap(31, 31, 31)
                                                                .addGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(group.createSequentialGroup()
                                                                        .addComponent(destinationLabel,
                                                                                GroupLayout.PREFERRED_SIZE, 110,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(26, 26, 26)
                                                                        .addComponent(destinationValueLabel,
                                                                                GroupLayout.PREFERRED_SIZE, 88,
                                                                                GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(GroupLayout.Alignment.TRAILING, group.createSequentialGroup()
                                                                                .addGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(callSignLabel,
                                                                                                GroupLayout.PREFERRED_SIZE, 110,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(delayLabel,
                                                                                                GroupLayout.PREFERRED_SIZE, 110,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(planeIdLabel,
                                                                                                GroupLayout.PREFERRED_SIZE, 110,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(delayValueLabel,
                                                                                                GroupLayout.PREFERRED_SIZE, 75,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(callSignValueLabel,
                                                                                                GroupLayout.PREFERRED_SIZE, 88,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(planeIdValueLabel,
                                                                                                GroupLayout.PREFERRED_SIZE, 88,
                                                                                                GroupLayout.PREFERRED_SIZE))))))
                                                        .addGap(0, 0, Short.MAX_VALUE))))
                                .addComponent(separator)
                                .addGroup(group.createSequentialGroup()
                                        .addGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(airlineInfoLabel,
                                                        GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(group.createSequentialGroup().addComponent(airlineNameLabel,
                                                        GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(airlineNameValueLabel,
                                                                GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE))
                                                .addComponent(airplaneInfoLabel,
                                                        GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(group.createSequentialGroup()
                                                        .addComponent(maintenanceLabel,
                                                                GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(maintenanceValueLabel,
                                                                GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(group.createSequentialGroup()
                                                        .addComponent(airplaneModelLabel,
                                                                GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(airplaneModelValueLabel,
                                                                GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(group.createSequentialGroup()
                                                        .addComponent(airlineAllianceLabel,
                                                                GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(airlineAllianceValueLabel,
                                                                GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(group.createSequentialGroup()
                                                        .addComponent(checkinStatusLabel,
                                                                GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(checkinStatusValueLabel,
                                                                GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        group.setVerticalGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(group.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(titleIcon,
                                        GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addGroup(group.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(titleLabel)))
                        .addGap(14, 14, 14)
                        .addGroup(group.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(flightDateLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(departureTimeLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(departureTimeValueLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(flightDateValueLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(group.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(sourceLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(destinationLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(destinationValueLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(sourceValueLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(group.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(statusLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(statusValueLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(callSignLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(callSignValueLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(group.
                                createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(delayValueLabel,
                                        GroupLayout.Alignment.TRAILING,
                                        GroupLayout.PREFERRED_SIZE, 34,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGroup(group
                                        .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(passengersLabel,
                                                GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passengersValueLabel,
                                                GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(delayLabel,
                                                GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(group.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(airlineCodeValueLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(planeIdLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(planeIdValueLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(airlineCodeLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(group.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(checkinStatusLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(checkinStatusValueLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(separator,
                                GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(airlineInfoLabel,
                                GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(group.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(airlineNameValueLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(airlineNameLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(group.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(airlineAllianceLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(airlineAllianceValueLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(airplaneInfoLabel,
                                GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(group.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(airplaneModelLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(airplaneModelValueLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(group.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(maintenanceLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(maintenanceValueLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(editIssueBox,
                        GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(editIssueBox,
                        GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    private void createIcon() {
        Path path = AssetsPath.getAbsolute("icon.png");
        titleIcon.setIcon(new ImageIcon(path.toString()));
    }

    private void createTitleLabel() {
        titleLabel.setFont(new Font("Calibri", 0, 24));
        titleLabel.setForeground(new Color(91, 91, 91));
        titleLabel.setText("AMS");
    }

    private void createSourceLabel() {
        sourceLabel.setFont(new Font("Calibri", 0, 18));
        sourceLabel.setForeground(new Color(91, 91, 91));
        sourceLabel.setText("Source: ");
    }

    private void createDestinationLabel() {
        destinationLabel.setFont(new Font("Calibri", 0, 18));
        destinationLabel.setForeground(new Color(91, 91, 91));
        destinationLabel.setText("Destination:");
    }

    private void createFlightStatusLabel() {
        statusLabel.setFont(new Font("Calibri", 0, 18));
        statusLabel.setForeground(new Color(91, 91, 91));
        statusLabel.setText("Status:");
    }

    private void createCallSignLabel() {
        callSignLabel.setFont(new Font("Calibri", 0, 18));
        callSignLabel.setForeground(new Color(91, 91, 91));
        callSignLabel.setText("Call sign:");
    }

    private void createCheckinStatusLabel() {
        checkinStatusLabel.setFont(new Font("Calibri", 0, 18));
        checkinStatusLabel.setForeground(new Color(91, 91, 91));
        checkinStatusLabel.setText("Check-in status:");
    }

    private void createPlaneIdLabel() {
        planeIdLabel.setFont(new Font("Calibri", 0, 18));
        planeIdLabel.setForeground(new Color(91, 91, 91));
        planeIdLabel.setText("Plane Id:");
    }

    private void createPassengersLabel() {
        passengersLabel.setFont(new Font("Calibri", 0, 18));
        passengersLabel.setForeground(new Color(91, 91, 91));
        passengersLabel.setText("Passengers:");
    }

    private void createDelayLabel() {
        delayLabel.setFont(new Font("Calibri", 0, 18));
        delayLabel.setForeground(new Color(91, 91, 91));
        delayLabel.setText("Delay:");
    }

    private void createFlightDateLabel() {
        flightDateLabel.setFont(new Font("Calibri", 0, 18));
        flightDateLabel.setForeground(new Color(91, 91, 91));
        flightDateLabel.setText("Flight Date:");
    }

    private void createDepartureTimeLabel() {
        departureTimeLabel.setFont(new Font("Calibri", 0, 18));
        departureTimeLabel.setForeground(new Color(91, 91, 91));
        departureTimeLabel.setText("Departure Time:");
    }

    private void createAirlineInfoLabel() {
        airlineInfoLabel.setFont(new Font("Calibri", 1, 18));
        airlineInfoLabel.setForeground(new Color(91, 91, 91));
        airlineInfoLabel.setText("Airline Information");
    }

    private void createAirlineNameLabel() {
        airlineNameLabel.setFont(new Font("Calibri", 0, 18));
        airlineNameLabel.setForeground(new Color(91, 91, 91));
        airlineNameLabel.setText("Name:");
    }

    private void createAirlineAllianceLabel() {
        airlineAllianceLabel.setFont(new Font("Calibri", 0, 18));
        airlineAllianceLabel.setForeground(new Color(91, 91, 91));
        airlineAllianceLabel.setText("Alliance:");
    }

    private void createAirplaneInfoLabel() {
        airplaneInfoLabel.setFont(new Font("Calibri", 1, 18));
        airplaneInfoLabel.setForeground(new Color(91, 91, 91));
        airplaneInfoLabel.setText("Airplane Information");
    }

    private void createMaintenanceLabel() {
        maintenanceLabel.setFont(new Font("Calibri", 0, 18));
        maintenanceLabel.setForeground(new Color(91, 91, 91));
        maintenanceLabel.setText("Last maintenance:");
    }

    private void createSourceValueLabel() {
        sourceValueLabel.setFont(new Font("Calibri", 0, 18));
        sourceValueLabel.setForeground(new Color(109, 150, 244));
    }

    private void createAirplaneModelLabel() {
        airplaneModelLabel.setFont(new Font("Calibri", 0, 18));
        airplaneModelLabel.setForeground(new Color(91, 91, 91));
        airplaneModelLabel.setText("Model:");
    }

    private void createMaintenanceValueLabel() {
        maintenanceValueLabel.setFont(new Font("Calibri", 0, 18));
        maintenanceValueLabel.setForeground(new Color(109, 150, 244));
    }

    private void createAirplaneModelValueLabel() {
        airplaneModelValueLabel.setFont(new Font("Calibri", 0, 18));
        airplaneModelValueLabel.setForeground(new Color(109, 150, 244));
    }

    private void createAirlineCodeLabel() {
        airlineCodeLabel.setFont(new Font("Calibri", 0, 18));
        airlineCodeLabel.setForeground(new Color(91, 91, 91));
        airlineCodeLabel.setText("Airline Code: ");
    }

    private void createCheckinStatusValueLabel() {
        checkinStatusValueLabel.setFont(new Font("Calibri", 0, 18));
        checkinStatusValueLabel.setForeground(new Color(109, 150, 244));
    }

    private void createFlightDateValueLabel() {
        flightDateValueLabel.setFont(new Font("Calibri", 0, 18));
        flightDateValueLabel.setForeground(new Color(109, 150, 244));
    }

    private void createDepartureTimeValueLabel() {
        departureTimeValueLabel.setFont(new Font("Calibri", 0, 18));
        departureTimeValueLabel.setForeground(new Color(109, 150, 244));
    }

    private void createFlightStatusValueLabel() {
        statusValueLabel.setFont(new Font("Calibri", 0, 18));
        statusValueLabel.setForeground(new Color(109, 150, 244));
    }

    private void createCallSignValueLabel() {
        callSignValueLabel.setFont(new Font("Calibri", 0, 18));
        callSignValueLabel.setForeground(new Color(109, 150, 244));
    }

    private void createAirlineCodeValueLabel() {
        airlineCodeValueLabel.setFont(new Font("Calibri", 0, 18));
        airlineCodeValueLabel.setForeground(new Color(109, 150, 244));
    }

    private void createPlaneIdValueLabel() {
        planeIdValueLabel.setFont(new Font("Calibri", 0, 18));
        planeIdValueLabel.setForeground(new Color(109, 150, 244));
    }

    private void createPassengersValueLabel() {
        passengersValueLabel.setFont(new Font("Calibri", 0, 18));
        passengersValueLabel.setForeground(new Color(109, 150, 244));
    }

    private void createDelayValueLabel() {
        delayValueLabel.setFont(new Font("Calibri", 0, 18));
        delayValueLabel.setForeground(new Color(109, 150, 244));
    }

    private void createAirlineNameValueLabel() {
        airlineNameValueLabel.setFont(new Font("Calibri", 0, 18));
        airlineNameValueLabel.setForeground(new Color(109, 150, 244));
    }

    private void createDestinationValueLabel() {
        destinationValueLabel.setFont(new Font("Calibri", 0, 18));
        destinationValueLabel.setForeground(new Color(109, 150, 244));
    }

    private void createAirlineAllianceValueLabel() {
        airlineAllianceValueLabel.setFont(new Font("Calibri", 0, 18));
        airlineAllianceValueLabel.setForeground(new Color(109, 150, 244));
    }
}
