package com.presentation.controllers.panels;

import com.business.repositories.AirlinesRepository;
import com.domain.entities.Airline;
import com.domain.repositories.AirlinesRepositoryImpl;
import com.presentation.screens.panels.AirlinesPanelScreen;
import com.presentation.screens.widgets.CreateAirlineBox;
import com.presentation.utils.JSONUtil;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

@Getter
public class AirlinesPanelController {

    private AirlinesPanelScreen airlinesPanelScreen;
    private AirlinesRepository airlinesRepository;
    private CreateAirlineBox createAirlineBox;

    private List<Airline> airlines;
    private int currRow = 0;

    public AirlinesPanelController() {
        airlinesPanelScreen = new AirlinesPanelScreen();

        String dataOrigin = JSONUtil.getDataOriginFromSettings("airlines");

        try {

            // TODO: inject into a service
            if (!dataOrigin.equals("mock")) {
                airlinesRepository = new AirlinesRepositoryImpl();
            } else {
                // TODO: impl mock repo
                // airlinesRepository = new AirlinesRepositoryMock();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Internal error");
        }
        addListeners();
    }

    public void show() {
        if (airlines == null || airlines.isEmpty()) {
            loadData();
        }

        airlinesPanelScreen.getAirlinesPanel().setVisible(true);
    }

    public void close() {
        airlinesPanelScreen.getAirlinesPanel().setVisible(false);
    }

    private void loadData() {
        try {
            airlines = airlinesRepository.getMany();

            setTableData();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Couldn't load data");
        }
    }

    private void setTableData() {
        for (Airline airline : airlines) {
            setTableRow(airline);
        }
    }

    private void setTableRow(Airline airline) {
        JTable table = airlinesPanelScreen.getAirlinesTableScreen().getAirlinesTable();
        table.setValueAt(airline.getCode(), currRow, 0);
        table.setValueAt(airline.getName(), currRow, 1);
        table.setValueAt(airline.getAlliance(), currRow, 2);
        table.setValueAt(airline.getMainHub(), currRow, 3);
        currRow++;
    }

    private void addListeners() {
        airlinesPanelScreen
                .getCreateAirlineBtn()
                .addMouseListener(createAirlineMouseListener());
    }

    private MouseAdapter createAirlineMouseListener() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                createAirlineBox = new CreateAirlineBox();
                createAirlineBox.addPropertyChangeListener(prop -> {
                    if (prop.getPropertyName().equals(CreateAirlineBox.CREATED)) {
                        try {
                            Airline airline = airlinesRepository.insert((Airline) prop.getNewValue());
                            setTableRow(airline);

                            createAirlineBox.setVisible(false);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }
                    }
                });

                createAirlineBox.setLocationRelativeTo(null);
                createAirlineBox.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                airlinesPanelScreen.getCreateAirlineBtn().setFont(new Font("Segoe UI", Font.BOLD, 23));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                airlinesPanelScreen.getCreateAirlineBtn().setFont(new Font("Segoe UI", Font.BOLD, 22));
            }
        };
    }
}
