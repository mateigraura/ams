package com.presentation.controllers.panels;

import com.domain.entities.Flight;
import com.domain.entities.Issue;
import com.domain.repositories.FlightRepositoryImpl;
import com.domain.repositories.IssuesRepositoryImpl;
import com.presentation.screens.panels.IssuesPanelScreen;
import com.presentation.screens.widgets.CreateIssueBox;
import com.presentation.screens.widgets.EditIssueBox;
import com.presentation.screens.widgets.FlightDetailsBox;
import com.presentation.utils.JSONUtil;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

@Getter
public class IssuesPanelController {

    private IssuesPanelScreen issuesPanelScreen;
    private IssuesRepositoryImpl issuesRepository;
    private FlightRepositoryImpl flightRepository;

    private List<Issue> issues;
    private int currRow = 0;
    private int selectedIssueId = -1;

    public IssuesPanelController() {
        issuesPanelScreen = new IssuesPanelScreen();

        String dataOrigin = JSONUtil.getDataOriginFromSettings("issues");

        try {
            if (!dataOrigin.equals("mock")) {
                issuesRepository = new IssuesRepositoryImpl();
                flightRepository = new FlightRepositoryImpl();
            } else {
                // issuesRepository = new IssuesRepositoryMock();
                // flightRepository = new FlightRepositoryMock();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Internal error");
        }
        addListeners();
    }

    public void show() {
        if (issues == null || issues.isEmpty()) {
            loadData();
        }

        issuesPanelScreen.getIssuesPanel().setVisible(true);
    }

    public void close() {
        issuesPanelScreen.getIssuesPanel().setVisible(false);
    }

    private void loadData() {
        try {
            issues = issuesRepository.getMany();

            setTableData();
            setIssueSummary(issues.get(0));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Couldn't load data");
        }
    }

    private void setTableData() {
        for (Issue issue : issues) {
            setTableRow(issue);
        }
    }

    private void setTableRow(Issue issue) {
        JTable table = issuesPanelScreen.getIssuesTableScreen().getIssuesTable();
        table.setValueAt(issue.getId(), currRow, 0);
        table.setValueAt(issue.getIssueCategory(), currRow, 1);
        table.setValueAt(issue.getIssueStatus(), currRow, 2);
        table.setValueAt(issue.getFiledAt(), currRow, 3);
        currRow++;
    }

    private void setIssueSummary(Issue issue) {
        selectedIssueId = issue.getId();

        issuesPanelScreen.getPassengerNamePlaceholder().setText(issue.getPassengerName());
        issuesPanelScreen.getFiledByPlaceholder().setText(issue.getFiledBy());
        issuesPanelScreen.getFlightRefPlaceholder().setText(issue.getFlightRef().toString());
        issuesPanelScreen.getDescriptionPane().setText(issue.getDescription());
    }

    private void addListeners() {
        issuesPanelScreen
                .getIssuesTableScreen()
                .getIssuesTable()
                .addMouseListener(issueTableMouseListener());

        issuesPanelScreen
                .getIssueFlightDetailsBtn()
                .addMouseListener(issueFlightDetailsMouseListener());

        issuesPanelScreen
                .getCreateIssueBtn()
                .addMouseListener(issueCreateBtnMouseListener());

        issuesPanelScreen
                .getEditIssueBtn()
                .addMouseListener(issueEditBtnMouseListener());
    }

    private MouseAdapter issueTableMouseListener() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JTable source = (JTable) evt.getSource();
                int row = source.rowAtPoint(evt.getPoint());
                int issueId = (int) source.getModel().getValueAt(row, 0);

                try {
                    Issue issue = issuesRepository.get(issueId);
                    setIssueSummary(issue);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Couldn't load issue summary");
                }
            }
        };
    }

    private MouseAdapter issueFlightDetailsMouseListener() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int flightId = Integer.parseInt(issuesPanelScreen.getFlightRefPlaceholder().getText());
                FlightDetailsBox flightDetailsBox = new FlightDetailsBox();

                try {
                    Flight flight = flightRepository.get(flightId);

                    flightDetailsBox.getSourceValueLabel().setText(flight.getSource());
                    flightDetailsBox.getDestinationValueLabel().setText(flight.getDestination());
                    flightDetailsBox.getStatusValueLabel().setText(flight.getFlightStatus().toString());
                    flightDetailsBox.getCallSignValueLabel().setText(flight.getCallSign());
                    flightDetailsBox.getAirlineCodeValueLabel().setText(flight.getAirlineCode().toString());
                    flightDetailsBox.getPlaneIdValueLabel().setText(flight.getPlaneId().toString());

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Couldn't load flight details");
                }

                flightDetailsBox.setLocationRelativeTo(null);
                flightDetailsBox.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                issuesPanelScreen
                        .getIssueFlightDetailsBtn()
                        .setFont(new Font("Segoe UI", Font.BOLD, 15));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                issuesPanelScreen
                        .getIssueFlightDetailsBtn()
                        .setFont(new Font("Segoe UI", Font.BOLD, 14));
            }
        };
    }

    private MouseAdapter issueCreateBtnMouseListener() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                CreateIssueBox createIssueBox = new CreateIssueBox();
                createIssueBox.addPropertyChangeListener(prop -> {
                    if (prop.getPropertyName().equals(CreateIssueBox.CREATED)) {
                        int id = (int) prop.getNewValue();

                        try {
                            Issue issue = issuesRepository.get(id);
                            setTableRow(issue);
                            createIssueBox.setVisible(false);

                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Couldn't load issue");
                        }
                    }
                });
                createIssueBox.setLocationRelativeTo(null);
                createIssueBox.setVisible(true);
            }
        };
    }

    private MouseAdapter issueEditBtnMouseListener() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EditIssueBox editIssueBox = new EditIssueBox(selectedIssueId);
                editIssueBox.addPropertyChangeListener(prop -> {
                    if (prop.getPropertyName().equals(EditIssueBox.UPDATED)) {
                        int issueId = (int) prop.getNewValue();

                        try {
                            Issue issue = issuesRepository.get(issueId);
                            issuesPanelScreen.getDescriptionPane().setText(issue.getDescription());
                            editIssueBox.setVisible(false);

                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Couldn't load issue");
                        }
                    }
                });

                editIssueBox.setLocationRelativeTo(null);
                editIssueBox.setVisible(true);
            }
        };
    }
}
