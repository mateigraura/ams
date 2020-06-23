package com.presentation.screens.panels;

import com.presentation.screens.tables.IssuesTableScreen;
import lombok.Getter;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

@Getter
public class IssuesPanelScreen {

    private JPanel issuesPanel;
    private JPanel issueSummary;
    private JLabel issueSummaryTitle;
    private JLabel passengerNameLabel;
    private JLabel passengerNamePlaceholder;
    private JLabel filedByLabel;
    private JLabel filedByPlaceholder;
    private JLabel flightRefLabel;
    private JLabel flightRefPlaceholder;
    private JLabel issueFlightDetailsBtn;
    private JLabel issueDescriptionLabel;
    private JScrollPane descriptionScroll;
    private JTextPane descriptionPane;
    private JButton editIssueBtn;
    private JSeparator separatorDescription;
    private JSeparator separatorTitle;
    private JButton createIssueBtn;
    private IssuesTableScreen issuesTableScreen;


    public IssuesPanelScreen() {
        initComponents();
    }

    private void initComponents() {
        issuesPanel = new JPanel();
        issueSummary = new JPanel();
        issueSummaryTitle = new JLabel();
        passengerNameLabel = new JLabel();
        passengerNamePlaceholder = new JLabel();
        filedByLabel = new JLabel();
        filedByPlaceholder = new JLabel();
        flightRefLabel = new JLabel();
        flightRefPlaceholder = new JLabel();
        issueFlightDetailsBtn = new JLabel();
        issueDescriptionLabel = new JLabel();
        descriptionScroll = new JScrollPane();
        descriptionPane = new JTextPane();
        editIssueBtn = new JButton();
        separatorDescription = new JSeparator();
        separatorTitle = new JSeparator();
        createIssueBtn = new JButton();
        issuesTableScreen = new IssuesTableScreen();

        issuesPanel.setBackground(new Color(238, 238, 238));
        issuesPanel.setLayout(new AbsoluteLayout());

        issuesPanel.add(issuesTableScreen.getIssuesTableScroll(), new AbsoluteConstraints(10, 40, 620, 510));

        issueSummary.setBackground(new Color(255, 255, 255));

        issueSummaryTitle.setFont(new Font("Segoe UI", 1, 18));
        issueSummaryTitle.setForeground(new Color(91, 91, 91));
        issueSummaryTitle.setText("Issue Summary");

        passengerNameLabel.setFont(new Font("Segoe UI", 1, 14));
        passengerNameLabel.setForeground(new Color(91, 91, 91));
        passengerNameLabel.setText("Passenger Name :");

        passengerNamePlaceholder.setFont(new Font("Segoe UI", 1, 14));
        passengerNamePlaceholder.setForeground(new Color(109, 150, 244));
        passengerNamePlaceholder.setText("Smith johnson");

        filedByLabel.setFont(new Font("Segoe UI", 1, 14));
        filedByLabel.setForeground(new Color(91, 91, 91));
        filedByLabel.setText("Filed by :");

        filedByPlaceholder.setFont(new Font("Segoe UI", 1, 14));
        filedByPlaceholder.setForeground(new Color(109, 150, 244));
        filedByPlaceholder.setText("Tamara Trump Jr.");

        flightRefLabel.setFont(new Font("Segoe UI", 1, 14));
        flightRefLabel.setForeground(new Color(91, 91, 91));
        flightRefLabel.setText("Flight ref no. :");

        flightRefPlaceholder.setFont(new Font("Segoe UI", 1, 14));
        flightRefPlaceholder.setForeground(new Color(109, 150, 244));
        flightRefPlaceholder.setText("43");

        issueFlightDetailsBtn.setFont(new Font("Segoe UI", 1, 14));
        issueFlightDetailsBtn.setForeground(new Color(109, 150, 244));
        issueFlightDetailsBtn.setText("Details");
        issueFlightDetailsBtn.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        issueDescriptionLabel.setFont(new Font("Segoe UI", 1, 18));
        issueDescriptionLabel.setForeground(new Color(91, 91, 91));
        issueDescriptionLabel.setText("Issue Description");

        descriptionScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        descriptionPane.setFont(new Font("Segoe UI", 0, 14));
        descriptionPane.setText("Ce sa faci n-ai ce sa faci");
        descriptionPane.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        descriptionPane.setDisabledTextColor(new Color(0, 0, 0));
        descriptionPane.setDoubleBuffered(true);
        descriptionPane.setDragEnabled(true);
        descriptionPane.setEnabled(false);
        descriptionPane.setMargin(new Insets(5, 5, 5, 5));
        descriptionScroll.setViewportView(descriptionPane);

        editIssueBtn.setBackground(new Color(109, 150, 244));
        editIssueBtn.setFont(new Font("Calibri", 1, 18));
        editIssueBtn.setForeground(new Color(255, 255, 255));
        editIssueBtn.setText("Edit issue");
        editIssueBtn.setBorder(null);

        separatorDescription.setForeground(new Color(91, 91, 91));
        separatorTitle.setForeground(new Color(91, 91, 91));

        initSummaryLayout();
        issuesPanel.add(issueSummary, new AbsoluteConstraints(640, 40, 520, 510));

        createIssueBtn.setBackground(new Color(109, 150, 244));
        createIssueBtn.setFont(new Font("Calibri", 1, 18));
        createIssueBtn.setForeground(new Color(255, 255, 255));
        createIssueBtn.setText("+ New Issue");
        createIssueBtn.setBorder(null);
        issuesPanel.add(createIssueBtn, new AbsoluteConstraints(10, 560, 147, 42));
    }

    private void initSummaryLayout() {
        GroupLayout issueSummaryLayout = new GroupLayout(issueSummary);
        issueSummary.setLayout(issueSummaryLayout);
        issueSummaryLayout.setHorizontalGroup(issueSummaryLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(issueSummaryLayout.createSequentialGroup().addGroup(issueSummaryLayout
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, issueSummaryLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(issueSummaryLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(separatorDescription)
                                        .addComponent(separatorTitle, GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.LEADING, issueSummaryLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(issueSummaryLayout
                                                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(issueSummaryLayout.createSequentialGroup()
                                                                .addGroup(issueSummaryLayout
                                                                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(passengerNameLabel,
                                                                                GroupLayout.PREFERRED_SIZE, 127,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(filedByLabel,
                                                                                GroupLayout.DEFAULT_SIZE, 158,
                                                                                Short.MAX_VALUE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(issueSummaryLayout
                                                                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(filedByPlaceholder,
                                                                                GroupLayout.PREFERRED_SIZE, 270,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(passengerNamePlaceholder,
                                                                                GroupLayout.PREFERRED_SIZE, 270,
                                                                                GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(issueSummaryLayout.createSequentialGroup()
                                                                .addComponent(flightRefLabel,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(flightRefPlaceholder,
                                                                        GroupLayout.PREFERRED_SIZE, 55,
                                                                        GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(issueFlightDetailsBtn,
                                                                        GroupLayout.PREFERRED_SIZE, 55,
                                                                        GroupLayout.PREFERRED_SIZE)
                                                                .addGap(154, 154, 154)))
                                                .addGap(0, 56, Short.MAX_VALUE))))
                        .addGroup(issueSummaryLayout.createSequentialGroup().addGroup(issueSummaryLayout
                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(issueSummaryLayout.createSequentialGroup()
                                        .addGap(180, 180, 180)
                                        .addComponent(issueSummaryTitle,
                                                GroupLayout.PREFERRED_SIZE, 142,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGroup(issueSummaryLayout.createSequentialGroup()
                                        .addGap(181, 181, 181)
                                        .addComponent(issueDescriptionLabel)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                .addGroup(GroupLayout.Alignment.TRAILING, issueSummaryLayout
                        .createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(editIssueBtn,
                                GroupLayout.PREFERRED_SIZE, 147,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(185, 185, 185))
                .addGroup(issueSummaryLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(descriptionScroll)
                        .addContainerGap())
        );
        issueSummaryLayout.setVerticalGroup(issueSummaryLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(issueSummaryLayout.createSequentialGroup()
                        .addComponent(issueSummaryTitle,
                                GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(separatorTitle,
                                GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(issueSummaryLayout
                                .createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(passengerNameLabel,
                                        GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                .addComponent(passengerNamePlaceholder,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(issueSummaryLayout
                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(filedByLabel,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addComponent(filedByPlaceholder,
                                        GroupLayout.PREFERRED_SIZE, 48,
                                        GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(issueSummaryLayout
                                .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(flightRefPlaceholder,
                                        GroupLayout.PREFERRED_SIZE, 48,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(flightRefLabel,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addComponent(issueFlightDetailsBtn))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(separatorDescription,
                                GroupLayout.PREFERRED_SIZE, 10,
                                GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(issueDescriptionLabel,
                                GroupLayout.PREFERRED_SIZE, 37,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(descriptionScroll,
                                GroupLayout.PREFERRED_SIZE, 153,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editIssueBtn,
                                GroupLayout.PREFERRED_SIZE, 42,
                                GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
        );
    }
}
