
package com.presentation.screens.widgets;

import com.assets.utils.AssetsPath;
import lombok.Getter;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.file.Path;

@Getter
public class FlightDepartureBox extends JFrame {

    public static final String GRANTED = "granted";

    private JLabel callSignLabel;
    private JLabel callSignValueLabel;
    private JButton createBtn;
    private JLabel destinationLabel;
    private JLabel destinationValueLabel;
    private JPanel editIssueBox;
    private JLabel sourceLabel;
    private JLabel sourceValueLabel;
    private JLabel titleIcon;
    private JLabel titleLabel;
    private JLabel waitingForLabel;
    private JLabel waitingForValueLabel;

    public FlightDepartureBox() {
        initComponents();
        initLayout();
        addListeners();
        pack();
    }

    private void initComponents() {
        editIssueBox = new JPanel();
        titleIcon = new JLabel();
        titleLabel = new JLabel();
        sourceLabel = new JLabel();
        destinationLabel = new JLabel();
        callSignLabel = new JLabel();
        sourceValueLabel = new JLabel();
        destinationValueLabel = new JLabel();
        callSignValueLabel = new JLabel();
        waitingForLabel = new JLabel();
        waitingForValueLabel = new JLabel();
        createBtn = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        editIssueBox.setBackground(new Color(255, 255, 255));

        createIcon();
        createTitle();
        createSourceLabel();
        createDestinationLabel();
        createCallSignLabel();
        createSourceValueLabel();
        createDestinationValueLabel();
        createCallSignValueLabel();
        createWaitingForLabel();
        createWaitingForValueLabel();
        createBtn();
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

    private void createCallSignLabel() {
        callSignLabel.setFont(new Font("Calibri", 0, 18));
        callSignLabel.setForeground(new Color(91, 91, 91));
        callSignLabel.setText("Call sign:");
    }

    private void createSourceValueLabel() {
        sourceValueLabel.setFont(new Font("Calibri", 0, 18));
        sourceValueLabel.setForeground(new Color(109, 150, 244));
    }

    private void createDestinationValueLabel() {
        destinationValueLabel.setFont(new Font("Calibri", 0, 18));
        destinationValueLabel.setForeground(new Color(109, 150, 244));
    }

    private void createCallSignValueLabel() {
        callSignValueLabel.setFont(new Font("Calibri", 0, 18));
        callSignValueLabel.setForeground(new Color(109, 150, 244));
    }

    private void createWaitingForLabel() {
        waitingForLabel.setFont(new Font("Calibri", 1, 18));
        waitingForLabel.setForeground(new Color(91, 91, 91));
        waitingForLabel.setText("REASON:");
    }

    private void createWaitingForValueLabel() {
        waitingForValueLabel.setFont(new Font("Calibri", 1, 14));
        waitingForValueLabel.setForeground(new Color(109, 150, 244));
        waitingForValueLabel.setText("DEPARTURE");
        waitingForValueLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }

    private void createBtn() {
        createBtn.setBackground(new Color(109, 150, 244));
        createBtn.setFont(new Font("Calibri", 0, 18));
        createBtn.setForeground(new Color(255, 255, 255));
        createBtn.setText("GRANT PERMISSION");
        createBtn.setBorder(null);
    }

    private void initLayout() {
        GroupLayout editIssueBoxLayout = new GroupLayout(editIssueBox);
        editIssueBox.setLayout(editIssueBoxLayout);
        editIssueBoxLayout.setHorizontalGroup(editIssueBoxLayout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(editIssueBoxLayout.createSequentialGroup()
                        .addGroup(editIssueBoxLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(editIssueBoxLayout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addGroup(editIssueBoxLayout
                                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(callSignLabel,
                                                        GroupLayout.PREFERRED_SIZE, 110,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addComponent(waitingForLabel,
                                                        GroupLayout.PREFERRED_SIZE, 110,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addComponent(destinationLabel,
                                                        GroupLayout.PREFERRED_SIZE, 110,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addComponent(sourceLabel,
                                                        GroupLayout.PREFERRED_SIZE, 110,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(editIssueBoxLayout
                                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(sourceValueLabel,
                                                        GroupLayout.PREFERRED_SIZE, 88,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addComponent(destinationValueLabel,
                                                        GroupLayout.PREFERRED_SIZE, 88,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addComponent(callSignValueLabel,
                                                        GroupLayout.PREFERRED_SIZE, 88,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addComponent(waitingForValueLabel,
                                                        GroupLayout.PREFERRED_SIZE, 140,
                                                        GroupLayout.PREFERRED_SIZE)))
                                .addGroup(editIssueBoxLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(titleIcon,
                                                GroupLayout.PREFERRED_SIZE, 54,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(titleLabel,
                                                GroupLayout.PREFERRED_SIZE, 68,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGroup(editIssueBoxLayout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addComponent(createBtn,
                                                GroupLayout.PREFERRED_SIZE, 230,
                                                GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(17, Short.MAX_VALUE))
        );
        editIssueBoxLayout.setVerticalGroup(editIssueBoxLayout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(editIssueBoxLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(editIssueBoxLayout
                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(titleIcon,
                                        GroupLayout.PREFERRED_SIZE, 39,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGroup(editIssueBoxLayout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(titleLabel)))
                        .addGap(54, 54, 54)
                        .addGroup(editIssueBoxLayout
                                .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(sourceLabel,
                                        GroupLayout.PREFERRED_SIZE, 34,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(sourceValueLabel,
                                        GroupLayout.PREFERRED_SIZE, 34,
                                        GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(editIssueBoxLayout
                                .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(destinationLabel,
                                        GroupLayout.PREFERRED_SIZE, 34,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(destinationValueLabel,
                                        GroupLayout.PREFERRED_SIZE, 34,
                                        GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(editIssueBoxLayout
                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(callSignValueLabel,
                                        GroupLayout.PREFERRED_SIZE, 34,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(callSignLabel,
                                        GroupLayout.PREFERRED_SIZE, 34,
                                        GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(editIssueBoxLayout
                                .createParallelGroup(GroupLayout.Alignment.BASELINE))
                        .addGap(18, 18, 18)
                        .addGroup(editIssueBoxLayout
                                .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(waitingForLabel,
                                        GroupLayout.PREFERRED_SIZE, 34,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(waitingForValueLabel,
                                        GroupLayout.PREFERRED_SIZE, 34,
                                        GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(createBtn,
                                GroupLayout.PREFERRED_SIZE, 42,
                                GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(40, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(editIssueBox,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(editIssueBox,
                        GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
        );
    }

    private void addListeners() {
        createBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                firePropertyChange(GRANTED, null, null);
            }
        });
    }
}
