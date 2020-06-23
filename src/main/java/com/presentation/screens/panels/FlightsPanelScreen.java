package com.presentation.screens.panels;

import com.presentation.screens.tables.InboundTableScreen;
import com.presentation.screens.tables.OutboundTableScreen;
import lombok.Getter;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

@Getter
public class FlightsPanelScreen {

    private JPanel flightsPanel;
    private JLabel inboundFlightsLabel;
    private JLabel outboundFlightsLabel;
    private InboundTableScreen inboundTableScreen;
    private OutboundTableScreen outboundTableScreen;

    public FlightsPanelScreen() {
        initComponents();
        initLayout();
    }

    private void initComponents() {
        flightsPanel = new JPanel();
        inboundFlightsLabel = new JLabel();
        outboundFlightsLabel = new JLabel();
        inboundTableScreen = new InboundTableScreen();
        outboundTableScreen = new OutboundTableScreen();

        flightsPanel.setBackground(new Color(238, 238, 238));

        inboundFlightsLabel.setFont(new Font("Segoe UI", 1, 18));
        inboundFlightsLabel.setForeground(new Color(91, 91, 91));
        inboundFlightsLabel.setText("Inbound Flights");
        inboundFlightsLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        outboundFlightsLabel.setFont(new Font("Segoe UI", 1, 18));
        outboundFlightsLabel.setForeground(new Color(91, 91, 91));
        outboundFlightsLabel.setText("Outbound Flights");
        outboundFlightsLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }

    private void initLayout() {
        GroupLayout flightsPanelLayout = new GroupLayout(flightsPanel);
        flightsPanel.setLayout(flightsPanelLayout);
        flightsPanelLayout.setHorizontalGroup(flightsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(flightsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(flightsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(inboundTableScreen.getInboundTableScroll(),
                                        GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE)
                                .addComponent(inboundFlightsLabel,
                                        GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addGroup(flightsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(outboundTableScreen.getOutboundTableScroll(),
                                        GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE)
                                .addComponent(outboundFlightsLabel,
                                        GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
        );
        flightsPanelLayout.setVerticalGroup(
                flightsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, flightsPanelLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(flightsPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(inboundFlightsLabel,
                                                GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(outboundFlightsLabel,
                                                GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addGroup(flightsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(outboundTableScreen.getOutboundTableScroll(),
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(inboundTableScreen.getInboundTableScroll(),
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGap(85, 85, 85))
        );
    }
}
