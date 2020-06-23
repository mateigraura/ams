package com.presentation.controllers.panels;

import com.business.services.DepartureService;
import com.domain.entities.Checkin;
import com.domain.entities.Flight;
import com.domain.entities.enumerators.FlightStatus;
import com.domain.mock.repositories.CheckinRepositoryMock;
import com.domain.repositories.CheckinRepositoryImpl;
import com.presentation.screens.panels.DeparturesPanelScreen;
import com.presentation.screens.widgets.FlightDepartureBox;
import com.presentation.utils.JSONUtil;
import lombok.Getter;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Queue;
import java.util.Timer;
import java.util.*;

@Getter
public class DeparturesPanelController {

    private final DeparturesPanelScreen departuresPanelScreen;
    private DepartureService departureService;
    private DefaultListModel<String> waitingForTaxiModel;
    private DefaultListModel<String> waitingForTakeoffModel;
    private DefaultListModel<String> airborneModel;

    private List<Checkin> checkinFlights;

    private Queue<Checkin> waitingForTaxiFlights;
    private Queue<Checkin> waitingForTakeoffFlights;
    private List<Checkin> airBorneFlights;

    private final String waitingForTaxiStatus = "WAITING_FOR_TAXI";
    private final String waitingForTakeoffStatus = "WAITING_FOR_TAKEOFF";
    private final String airborneStatus = "AIRBORNE";
    private final String runwayInUseMsg = "IN-USE";
    private final String runwayClearMsg = "CLEAR";

    private final Color inUseColor = new Color(255, 0, 0);
    private final Color clearColor = new Color(0, 204, 0);

    private int taxiRow = 0;
    private int takeoffRow = 0;
    private int airborneRow = 0;
    private boolean taxiRunwayInUse = false;
    private boolean takeoffRunwayInUse = false;

    public DeparturesPanelController() {
        departuresPanelScreen = new DeparturesPanelScreen();
        departuresPanelScreen.getAirplaneIcon().setVisible(false);

        String dataOrigin = JSONUtil.getDataOriginFromSettings("departures");

        try {
            if (!dataOrigin.equals("mock")) {
                departureService = new DepartureService(new CheckinRepositoryImpl());
            } else {
                departureService = new DepartureService(new CheckinRepositoryMock());
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Internal error");
        }

        addListeners();
    }

    public void show() {
        if (checkinFlights == null || checkinFlights.isEmpty()) {
            loadData();
        }

        departuresPanelScreen.getDeparturesPanel().setVisible(true);
    }

    public void close() {
        departuresPanelScreen
                .getDeparturesPanel().setVisible(false);
    }

    private void loadData() {
        try {

            checkinFlights = departureService.getCheckinFlights();

            waitingForTaxiFlights = new LinkedList<>();
            waitingForTakeoffFlights = new LinkedList<>();
            airBorneFlights = new ArrayList<>();

            checkinFlights.stream()
                    .filter(c -> c.getFlight().getFlightStatus().equals(FlightStatus.WAITING_FOR_TAXI))
                    .forEach(c -> waitingForTaxiFlights.add(c));

            checkinFlights.stream()
                    .filter(c -> c.getFlight().getFlightStatus().equals(FlightStatus.WAITING_FOR_TAKEOFF))
                    .forEach(c -> waitingForTakeoffFlights.add(c));

            checkinFlights.stream()
                    .filter(c -> c.getFlight().getFlightStatus().equals(FlightStatus.AIRBORNE))
                    .forEach(c -> airBorneFlights.add(c));

            setData();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Couldn't load data");
        }
    }

    private void setData() {
        String tabs_1 = "   ";

        waitingForTaxiModel =
                (DefaultListModel<String>) departuresPanelScreen
                        .getWaitingForTaxiList()
                        .getModel();
        if (!waitingForTaxiFlights.isEmpty()) {
            for (Checkin checkin : waitingForTaxiFlights) {
                Flight flight = checkin.getFlight();
                waitingForTaxiModel.add(taxiRow++,
                        flight.getId() +
                                tabs_1 + flight.getFlightStatus() +
                                tabs_1 + flight.getDelay() +
                                tabs_1 + flight.getCallSign());
            }
        }

        waitingForTakeoffModel =
                (DefaultListModel<String>) departuresPanelScreen
                        .getWaitingForDepartureList()
                        .getModel();
        if (!waitingForTakeoffFlights.isEmpty()) {
            for (Checkin checkin : waitingForTakeoffFlights) {
                Flight flight = checkin.getFlight();
                waitingForTakeoffModel.add(takeoffRow++,
                        flight.getId() +
                                tabs_1 + flight.getFlightStatus() +
                                tabs_1 + flight.getDelay() +
                                tabs_1 + flight.getCallSign());
            }
        }

        airborneModel =
                (DefaultListModel<String>) departuresPanelScreen
                        .getAirborneList()
                        .getModel();
        if (!airBorneFlights.isEmpty()) {
            for (Checkin checkin : airBorneFlights) {
                Flight flight = checkin.getFlight();
                airborneModel.add(airborneRow++,
                        flight.getId() +
                                tabs_1 + flight.getFlightStatus() +
                                tabs_1 + flight.getDelay() +
                                tabs_1 + flight.getCallSign());
            }
        }

        departuresPanelScreen.getRunwayStatusValue().setText(runwayClearMsg);
        departuresPanelScreen.getRunwayStatusValue().setForeground(clearColor);
    }

    private void setDepartureBoxData(FlightDepartureBox box, Flight flight) {
        box.getSourceValueLabel().setText(flight.getSource());
        box.getDestinationValueLabel().setText(flight.getDestination());
        box.getCallSignValueLabel().setText(flight.getCallSign());
        box.getWaitingForValueLabel().setText(flight.getFlightStatus().toString());
    }

    private void lockTaxiRunway(Checkin checkin, String value) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                setTaxiRunwayStatus();
                waitingForTakeoffFlights.add(checkin);
                waitingForTakeoffModel.add(takeoffRow++, value);
                departuresPanelScreen.getAirplaneIcon().setVisible(true);
                timer.cancel();
                timer.purge();
                return;
            }
        };

        setTaxiRunwayStatus();

        timer.schedule(task, 3500);
    }

    private void lockTakeoffRunway(Checkin checkin, String value) {
        Timer timer = new Timer();
        final int[] counter = {0};
        TimerTask task = new TimerTask() {
            @SneakyThrows
            @Override
            public void run() {
                if (counter[0] == 75) {
                    airBorneFlights.add(checkin);
                    airborneModel.add(airborneRow++, value);
                    takeoffRunwayInUse = !takeoffRunwayInUse;
                    timer.cancel();
                    timer.purge();
                    return;
                }
                vroomVroomAirplaneOff();
                counter[0]++;
            }
        };
        takeoffRunwayInUse = !takeoffRunwayInUse;
        timer.schedule(task, 200, 100);
    }

    private void setTaxiRunwayStatus() {
        taxiRunwayInUse = !taxiRunwayInUse;
        departuresPanelScreen
                .getRunwayStatusValue()
                .setText(taxiRunwayInUse ? runwayInUseMsg : runwayClearMsg);
        departuresPanelScreen
                .getRunwayStatusValue()
                .setForeground(taxiRunwayInUse ? inUseColor : clearColor);
    }

    private void addListeners() {
        departuresPanelScreen
                .getWaitingForTaxiList()
                .addMouseListener(waitingForTaxiListMouseListener());

        departuresPanelScreen
                .getWaitingForDepartureList()
                .addMouseListener(waitingForDepartureListMouseListener());
    }

    private void vroomVroomAirplaneOff() {
        JLabel airplaneIcon = departuresPanelScreen.getAirplaneIcon();
        Point point = airplaneIcon.getLocation();

        airplaneIcon.setLocation(point.x, (point.y + 10));
    }

    private Flight findById(int flightId) {
        return checkinFlights.stream()
                .filter(c -> c.getFlightId().equals(flightId))
                .findAny()
                .orElse(null)
                .getFlight();
    }

    private MouseAdapter waitingForTaxiListMouseListener() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JList list = departuresPanelScreen.getWaitingForTaxiList();
                String value = (String) list.getModel().getElementAt(list.locationToIndex(evt.getPoint()));

                int flightId = Integer.parseInt(value.split(" {2}")[0]);
                Flight flight = findById(flightId);

                FlightDepartureBox flightDepartureBox = new FlightDepartureBox();
                flightDepartureBox.addPropertyChangeListener(prop -> {
                    if (prop.getPropertyName().equals(FlightDepartureBox.GRANTED) &&
                            !taxiRunwayInUse &&
                            waitingForTakeoffFlights.isEmpty()
                    ) {
                        flightDepartureBox.setVisible(false);

                        if (flightId == waitingForTaxiFlights.peek().getFlightId()) {
                            String newValue = value.replace(waitingForTaxiStatus, waitingForTakeoffStatus);

                            Checkin checkin = waitingForTaxiFlights.poll();
                            checkin.getFlight().setFlightStatus(FlightStatus.WAITING_FOR_TAKEOFF);
                            waitingForTaxiModel.remove(0);
                            taxiRow--;

                            lockTaxiRunway(checkin, newValue);

                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Selected flight is not the first in Queue\n " +
                                            "Please select first flight waiting!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Taxi or takeoff runway is in use");
                    }
                });

                setDepartureBoxData(flightDepartureBox, flight);

                flightDepartureBox.setLocationRelativeTo(null);
                flightDepartureBox.setVisible(true);
            }
        };
    }

    private MouseAdapter waitingForDepartureListMouseListener() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JList list = departuresPanelScreen.getWaitingForDepartureList();
                String value = (String) list.getModel().getElementAt(list.locationToIndex(evt.getPoint()));

                int flightId = Integer.parseInt(value.split(" {2}")[0]);
                Flight flight = findById(flightId);

                FlightDepartureBox flightDepartureBox = new FlightDepartureBox();
                flightDepartureBox.addPropertyChangeListener(prop -> {
                    if (prop.getPropertyName().equals(FlightDepartureBox.GRANTED) && !takeoffRunwayInUse) {
                        flightDepartureBox.setVisible(false);

                        if (flightId == waitingForTakeoffFlights.peek().getFlightId()) {
                            String newValue = value.replace(waitingForTakeoffStatus, airborneStatus);

                            Checkin checkin = waitingForTakeoffFlights.poll();
                            checkin.getFlight().setFlightStatus(FlightStatus.AIRBORNE);
                            waitingForTakeoffModel.remove(0);
                            takeoffRow--;

                            lockTakeoffRunway(checkin, newValue);

                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Selected flight is not the first in Queue\n " +
                                            "Please select first flight waiting!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Taxi runway is in use. Wait for it to be available");
                    }
                });

                setDepartureBoxData(flightDepartureBox, flight);

                flightDepartureBox.setLocationRelativeTo(null);
                flightDepartureBox.setVisible(true);
            }
        };
    }
}
