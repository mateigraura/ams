package com.presentation.screens.widgets;

import com.assets.utils.AssetsPath;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;

@Getter
public class FlightDetailsBox extends JFrame {

    private JLabel airlineCodeLabel;
    private JLabel airlineCodeValueLabel;
    private JLabel callSignLabel;
    private JLabel callSignValueLabel;
    private JLabel destinationLabel;
    private JLabel destinationValueLabel;
    private JPanel editIssueBox;
    private JLabel planeIdLabel;
    private JLabel planeIdValueLabel;
    private JLabel sourceLabel;
    private JLabel sourceValueLabel;
    private JLabel statusLabel;
    private JLabel statusValueLabel;
    private JLabel titleIcon;
    private JLabel titleLabel;

    public FlightDetailsBox() {
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
        airlineCodeLabel = new JLabel();
        planeIdLabel = new JLabel();
        sourceValueLabel = new JLabel();
        destinationValueLabel = new JLabel();
        statusValueLabel = new JLabel();
        callSignValueLabel = new JLabel();
        airlineCodeValueLabel = new JLabel();
        planeIdValueLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        editIssueBox.setBackground(new Color(255, 255, 255));

        createIcon();
        createTitle();
        createSourceLabel();
        createDestinationLabel();
        createStatusLabel();
        createCallSignLabel();
        createAirlineCodeLabel();
        createPlaneIdLabel();
        createSourceValueLabel();
        createDestinationValueLabel();
        createStatusValueLabel();
        createCallSignValueLabel();
        createAirlineCodeValueLabel();
        createPlaneIdValueLabel();
    }

    private void createIcon() {
        Path path = AssetsPath.getAbsolute("icon.png");
        titleIcon.setIcon(new ImageIcon(path.toString()));
    }

    private void createTitle() {
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

    private void createStatusLabel() {
        statusLabel.setFont(new Font("Calibri", 0, 18));
        statusLabel.setForeground(new Color(91, 91, 91));
        statusLabel.setText("Status:");
    }

    private void createCallSignLabel() {
        callSignLabel.setFont(new Font("Calibri", 0, 18));
        callSignLabel.setForeground(new Color(91, 91, 91));
        callSignLabel.setText("Call sign:");
    }

    private void createAirlineCodeLabel() {
        airlineCodeLabel.setFont(new Font("Calibri", 0, 18));
        airlineCodeLabel.setForeground(new Color(91, 91, 91));
        airlineCodeLabel.setText("Airline Code: ");
    }

    private void createPlaneIdLabel() {
        planeIdLabel.setFont(new Font("Calibri", 0, 18));
        planeIdLabel.setForeground(new Color(91, 91, 91));
        planeIdLabel.setText("Plane Id:");
    }

    private void createSourceValueLabel() {
        sourceValueLabel.setFont(new Font("Calibri", 0, 18));
        sourceValueLabel.setForeground(new Color(109, 150, 244));
    }

    private void createDestinationValueLabel() {
        destinationValueLabel.setFont(new Font("Calibri", 0, 18));
        destinationValueLabel.setForeground(new Color(109, 150, 244));
    }

    private void createStatusValueLabel() {
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

    private void initLayout() {
        GroupLayout group = new GroupLayout(editIssueBox);
        editIssueBox.setLayout(group);
        group.setHorizontalGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(group.createSequentialGroup().addGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(group.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(titleIcon,
                                        GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(titleLabel,
                                        GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
                        .addGroup(group.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(group
                                                .createSequentialGroup()
                                                .addComponent(destinationLabel,
                                                        GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(destinationValueLabel,
                                                        GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(group.createSequentialGroup()
                                                .addComponent(sourceLabel,
                                                        GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(sourceValueLabel,
                                                        GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(group.createSequentialGroup()
                                                .addComponent(statusLabel,
                                                        GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(statusValueLabel,
                                                        GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(group.createSequentialGroup()
                                                .addComponent(callSignLabel,
                                                        GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(callSignValueLabel,
                                                        GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(group.createSequentialGroup()
                                                .addComponent(airlineCodeLabel,
                                                        GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(airlineCodeValueLabel,
                                                        GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(group.createSequentialGroup()
                                                .addComponent(planeIdLabel,
                                                        GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(planeIdValueLabel,
                                                        GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGap(54, 54, 54)
                        .addGroup(group.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(sourceLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(sourceValueLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(group.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(destinationLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(destinationValueLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(group.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(statusLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(statusValueLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(group.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(callSignLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(callSignValueLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(group.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(airlineCodeLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(airlineCodeValueLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(group.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(planeIdLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(planeIdValueLabel,
                                        GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(54, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(editIssueBox,
                        GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(editIssueBox,
                        GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
    }
}
