package com.presentation.screens.panels;

import com.assets.utils.AssetsPath;
import lombok.Getter;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.nio.file.Path;

@Getter
public class DeparturesPanelScreen {

    private JPanel departuresPanel;
    private JPanel departureRunway;
    private JLabel waitingForTaxiLabel;
    private JLabel waitingForDepartureLabel;
    private JLabel airborneLabel;
    private JLabel runwayStatusLabel;
    private JLabel runwayStatusValue;
    private JLabel airplaneIcon;
    private JScrollPane waitingForDepartureScroll;
    private JScrollPane waitingForTaxiScroll;
    private JScrollPane airborneScroll;
    private JList<String> waitingForDepartureList;
    private JList<String> waitingForTaxiList;
    private JList<String> airborneList;

    public DeparturesPanelScreen() {
        initComponents();
    }

    private void initComponents() {
        departuresPanel = new JPanel();
        departureRunway = new JPanel();
        waitingForTaxiLabel = new JLabel();
        waitingForDepartureLabel = new JLabel();
        airborneLabel = new JLabel();
        runwayStatusLabel = new JLabel();
        runwayStatusValue = new JLabel();
        airplaneIcon = new JLabel();
        waitingForDepartureScroll = new JScrollPane();
        waitingForTaxiScroll = new JScrollPane();
        airborneScroll = new JScrollPane();
        waitingForDepartureList = new JList<>();
        waitingForTaxiList = new JList<>();
        airborneList = new JList<>();

        departuresPanel.setBackground(new Color(238, 238, 238));
        departuresPanel.setLayout(new AbsoluteLayout());

        waitingForTaxiScroll.setBackground(new Color(238, 238, 238));

        waitingForTaxiList.setFont(new Font("Segoe UI", 1, 14));
        waitingForTaxiList.setForeground(new Color(91, 91, 91));
        waitingForTaxiList.setModel(new DefaultListModel<>());
        waitingForTaxiList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        waitingForTaxiList.setFixedCellHeight(36);
        waitingForTaxiList.setFixedCellWidth(36);
        waitingForTaxiList.setSelectionBackground(new Color(109, 150, 244));
        waitingForTaxiList.setVisibleRowCount(20);
        waitingForTaxiScroll.setViewportView(waitingForTaxiList);

        departuresPanel.add(waitingForTaxiScroll, new AbsoluteConstraints(30, 110, 350, 320));

        waitingForDepartureScroll.setBackground(new Color(238, 238, 238));

        waitingForDepartureList.setFont(new Font("Segoe UI", 1, 14));
        waitingForDepartureList.setForeground(new Color(91, 91, 91));
        waitingForDepartureList.setModel(new DefaultListModel<>());
        waitingForDepartureList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        waitingForDepartureList.setFixedCellHeight(36);
        waitingForDepartureList.setFixedCellWidth(36);
        waitingForDepartureList.setSelectionBackground(new Color(109, 150, 244));
        waitingForDepartureList.setVisibleRowCount(20);
        waitingForDepartureScroll.setViewportView(waitingForDepartureList);

        departuresPanel.add(waitingForDepartureScroll, new AbsoluteConstraints(510, 110, 350, 200));

        airborneScroll.setBackground(new Color(238, 238, 238));

        airborneList.setFont(new Font("Segoe UI", 1, 14));
        airborneList.setForeground(new Color(91, 91, 91));
        airborneList.setModel(new DefaultListModel<>());
        airborneList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        airborneList.setFixedCellHeight(36);
        airborneList.setFixedCellWidth(36);
        airborneList.setSelectionBackground(new Color(109, 150, 244));
        airborneList.setVisibleRowCount(20);
        airborneScroll.setViewportView(airborneList);

        departuresPanel.add(airborneScroll, new AbsoluteConstraints(510, 390, 350, 200));

        waitingForTaxiLabel.setFont(new Font("Segoe UI", 1, 18));
        waitingForTaxiLabel.setForeground(new Color(91, 91, 91));
        waitingForTaxiLabel.setText("WAITING FOR TAXI");
        waitingForTaxiLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        departuresPanel.add(waitingForTaxiLabel, new AbsoluteConstraints(30, 40, 230, 40));

        waitingForDepartureLabel.setFont(new Font("Segoe UI", 1, 18));
        waitingForDepartureLabel.setForeground(new Color(91, 91, 91));
        waitingForDepartureLabel.setText("WAITING FOR DEPARTURE");
        waitingForDepartureLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        departuresPanel.add(waitingForDepartureLabel, new AbsoluteConstraints(510, 40, 240, 40));

        airborneLabel.setFont(new Font("Segoe UI", 1, 18));
        airborneLabel.setForeground(new Color(91, 91, 91));
        airborneLabel.setText("AIRBORNE");
        airborneLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        departuresPanel.add(airborneLabel, new AbsoluteConstraints(510, 330, 110, 40));

        runwayStatusLabel.setFont(new Font("Segoe UI", 1, 18));
        runwayStatusLabel.setForeground(new Color(91, 91, 91));
        runwayStatusLabel.setText("Taxi runway status :");
        departuresPanel.add(runwayStatusLabel, new AbsoluteConstraints(30, 490, 180, 40));

        runwayStatusValue.setBackground(new Color(255, 255, 255));
        runwayStatusValue.setFont(new Font("Segoe UI", 1, 18));
        runwayStatusValue.setForeground(new Color(0, 204, 0));

        departuresPanel.add(runwayStatusValue, new AbsoluteConstraints(220, 490, 120, 40));

        departureRunway.setBackground(new Color(153, 153, 153));

        Path path = AssetsPath.getAbsolute("airplane.png");
        airplaneIcon.setIcon(new ImageIcon(path.toString()));

        GroupLayout departureRunwayLayout = new GroupLayout(departureRunway);
        departureRunway.setLayout(departureRunwayLayout);
        departureRunwayLayout.setHorizontalGroup(departureRunwayLayout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING,
                        departureRunwayLayout.createSequentialGroup()
                                .addContainerGap(25, Short.MAX_VALUE)
                                .addComponent(airplaneIcon)
                                .addGap(21, 21, 21))
        );
        departureRunwayLayout.setVerticalGroup(departureRunwayLayout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(departureRunwayLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(airplaneIcon,
                                GroupLayout.PREFERRED_SIZE, 80,
                                GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(443, Short.MAX_VALUE))
        );

        departuresPanel.add(departureRunway, new AbsoluteConstraints(1000, 40, 110, 550));
    }
}
