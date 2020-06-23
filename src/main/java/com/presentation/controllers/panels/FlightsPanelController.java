package com.presentation.controllers.panels;

import com.business.repositories.*;
import com.domain.entities.*;
import com.domain.repositories.*;
import com.presentation.screens.panels.FlightsPanelScreen;
import com.presentation.screens.widgets.FlightInformationBox;
import com.presentation.utils.JSONUtil;
import lombok.Getter;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

@Getter
public class FlightsPanelController {

    private final FlightsPanelScreen flightsPanelScreen;
    private InboundRepository inboundRepository;
    private OutboundRepository outboundRepository;

    private CheckinRepository checkinRepository;
    private AirlinesRepository airlineRepository;
    private AirplaneRepository airplaneRepository;

    private List<Inbound> inboundFlights;
    private List<Outbound> outboundFlights;

    public FlightsPanelController() {
        flightsPanelScreen = new FlightsPanelScreen();

        String dataOrigin = JSONUtil.getDataOriginFromSettings("airlines");

        try {

            // TODO: inject into a service
            if (!dataOrigin.equals("mock")) {
                inboundRepository = new InboundRepositoryImpl();
                outboundRepository = new OutboundRepositoryImpl();
                checkinRepository = new CheckinRepositoryImpl();
                airlineRepository = new AirlinesRepositoryImpl();
                airplaneRepository = new AirplaneRepositoryImpl();
            } else {
                // TODO: impl mock repo
                // inboundRepository = new InboundRepositoryMock();
                // outboundRepository = new OutboundRepositoryMock();
                // checkinRepository = new CheckinRepositoryMock();
                // airlineRepository = new AirlinesRepositoryMock();
                // airplaneRepository = new AirplaneRepositoryMock();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Internal error");
        }
        addListeners();
    }

    public void show() {
        if ((inboundFlights == null || inboundFlights.isEmpty()) &&
                (outboundFlights == null || outboundFlights.isEmpty())
        ) {
            loadData();
        }

        flightsPanelScreen.getFlightsPanel().setVisible(true);
    }

    public void close() {
        flightsPanelScreen.getFlightsPanel().setVisible(false);
    }

    private void loadData() {
        try {
            inboundFlights = inboundRepository.getMany();
            outboundFlights = outboundRepository.getMany();

            setTableData();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Couldn't load data");
        }
    }

    private void setTableData() {
        JTable inboundTable = flightsPanelScreen.getInboundTableScreen().getInboundTable();
        JTable outboundTable = flightsPanelScreen.getOutboundTableScreen().getOutboundTable();
        int row = 0;
        for (Inbound inbound : inboundFlights) {
            inboundTable.setValueAt(inbound.getId(), row, 0);
            inboundTable.setValueAt(inbound.getFlight().getSource(), row, 1);
            inboundTable.setValueAt(inbound.getFlight().getDestination(), row, 2);
            inboundTable.setValueAt(inbound.getFlight().getFlightStatus(), row, 3);
            ++row;
        }

        row = 0;
        for (Outbound outbound : outboundFlights) {
            outboundTable.setValueAt(outbound.getId(), row, 0);
            outboundTable.setValueAt(outbound.getFlight().getSource(), row, 1);
            outboundTable.setValueAt(outbound.getFlight().getDestination(), row, 2);
            outboundTable.setValueAt(outbound.getFlight().getFlightStatus(), row, 3);
            ++row;
        }
    }

    private void addListeners() {
        flightsPanelScreen
                .getInboundTableScreen()
                .getInboundTable()
                .addMouseListener(inboundTableMouseListener());
        flightsPanelScreen
                .getOutboundTableScreen()
                .getOutboundTable()
                .addMouseListener(outboundTableMouseListener());
    }

    private MouseAdapter inboundTableMouseListener() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JTable source = (JTable) evt.getSource();
                int row = source.rowAtPoint(evt.getPoint());
                Integer id = (Integer) source.getModel().getValueAt(row, 0);
                Inbound currFlight = null;
                for (Inbound inbound : inboundFlights) {
                    if (inbound.getId().equals(id)) {
                        currFlight = inbound;
                        break;
                    }
                }
                try {
                    FlightInformationBox box = new FlightInformationBox();

                    Checkin checkin = checkinRepository.getCheckinByFlightId(currFlight.getFlight().getId());
                    Airline airline = airlineRepository.get(currFlight.getFlightId());
                    Airplane airplane = airplaneRepository.get(currFlight.getFlightId());

                    box.getCheckinStatusValueLabel().setText(checkin.getCheckinStatus().toString());
                    box.getAirlineAllianceValueLabel().setText(airline.getAlliance());
                    box.getAirlineNameValueLabel().setText(airline.getName());
                    box.getAirplaneModelValueLabel().setText(String.format(
                            "%s %s", airplane.getManufacturer(), airplane.getModel()));
                    box.getMaintenanceValueLabel().setText(airplane.getLastMaintenance().toString());

                    box.getFlightDateValueLabel().setText(currFlight.getFlightDate().toString());
                    box.getDepartureTimeValueLabel().setText(currFlight.getDepartureTime().toString());
                    box.getSourceValueLabel().setText(currFlight.getFlight().getSource());
                    box.getDestinationValueLabel().setText(currFlight.getFlight().getDestination());
                    box.getStatusValueLabel().setText(currFlight.getFlight().getFlightStatus().toString());
                    box.getCallSignValueLabel().setText(currFlight.getFlight().getCallSign());
                    box.getPassengersValueLabel().setText(currFlight.getFlight().getPassengers().toString());
                    box.getDelayValueLabel().setText(currFlight.getFlight().getDelay().toString());
                    box.getAirlineCodeValueLabel().setText(airline.getCode().toString());
                    box.getPlaneIdValueLabel().setText(airplane.getId().toString());

                    box.setLocationRelativeTo(null);
                    box.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    private MouseAdapter outboundTableMouseListener() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JTable source = (JTable) evt.getSource();
                int row = source.rowAtPoint(evt.getPoint());
                Integer id = (Integer) source.getModel().getValueAt(row, 0);
                Outbound currFlight = null;
                for (Outbound outbound : outboundFlights) {
                    if (outbound.getId().equals(id)) {
                        currFlight = outbound;
                        break;
                    }
                }
                try {
                    FlightInformationBox box = new FlightInformationBox();

                    Checkin checkin = checkinRepository.getCheckinByFlightId(currFlight.getFlight().getId());
                    Airline airline = airlineRepository.get(currFlight.getFlightId());
                    Airplane airplane = airplaneRepository.get(currFlight.getFlightId());

                    box.getCheckinStatusValueLabel().setText(checkin.getCheckinStatus().toString());
                    box.getAirlineAllianceValueLabel().setText(airline.getAlliance());
                    box.getAirlineNameValueLabel().setText(airline.getName());
                    box.getAirplaneModelValueLabel().setText(String.format(
                            "%s %s", airplane.getManufacturer(), airplane.getModel()));
                    box.getMaintenanceValueLabel().setText(airplane.getLastMaintenance().toString());

                    box.getFlightDateValueLabel().setText(currFlight.getFlightDate().toString());
                    box.getDepartureTimeValueLabel().setText(currFlight.getDepartureTime().toString());
                    box.getSourceValueLabel().setText(currFlight.getFlight().getSource());
                    box.getDestinationValueLabel().setText(currFlight.getFlight().getDestination());
                    box.getStatusValueLabel().setText(currFlight.getFlight().getFlightStatus().toString());
                    box.getCallSignValueLabel().setText(currFlight.getFlight().getCallSign());
                    box.getPassengersValueLabel().setText(currFlight.getFlight().getPassengers().toString());
                    box.getDelayValueLabel().setText(currFlight.getFlight().getDelay().toString());
                    box.getAirlineCodeValueLabel().setText(airline.getCode().toString());
                    box.getPlaneIdValueLabel().setText(airplane.getId().toString());

                    box.setLocationRelativeTo(null);
                    box.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
