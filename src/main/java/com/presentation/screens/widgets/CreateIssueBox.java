
package com.presentation.screens.widgets;


import com.assets.utils.AssetsPath;
import com.domain.entities.Issue;
import com.domain.entities.enumerators.IssueCategory;
import com.domain.entities.enumerators.IssueStatus;
import com.domain.repositories.IssuesRepositoryImpl;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.file.Path;
import java.sql.Date;

public class CreateIssueBox extends JFrame {

    public static final String CREATED = "created";

    private JComboBox<String> categoryDropdown;
    private JLabel categoryLabel;
    private JPanel createAirlineBox;
    private JButton createBtn;
    private JLabel descriptionLabel;
    private JTextPane descriptionPane;
    private JScrollPane descriptionScroll;
    private JLabel filedByLabel;
    private JTextField filedByPlaceholder;
    private JLabel flightRefLabel;
    private JTextField flightRefPlaceholder;
    private JLabel passengerNameLabel;
    private JTextField passengerNamePlaceholder;
    private JComboBox<String> statusDropdown;
    private JLabel statusLabel;
    private JLabel titleIcon;
    private JLabel titleLabel;

    public CreateIssueBox() {
        initComponents();
        initLayout();
        addListeners();
        pack();
    }

    private void initComponents() {
        createAirlineBox = new JPanel();
        titleIcon = new JLabel();
        titleLabel = new JLabel();
        statusLabel = new JLabel();
        categoryLabel = new JLabel();
        flightRefLabel = new JLabel();
        passengerNameLabel = new JLabel();
        filedByLabel = new JLabel();
        descriptionLabel = new JLabel();
        statusDropdown = new JComboBox<>();
        categoryDropdown = new JComboBox<>();
        flightRefPlaceholder = new JTextField();
        passengerNamePlaceholder = new JTextField();
        filedByPlaceholder = new JTextField();
        descriptionScroll = new JScrollPane();
        descriptionPane = new JTextPane();
        createBtn = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        createAirlineBox.setBackground(new Color(255, 255, 255));

        createIcon();
        createTitleLabel();
        createStatusLabel();
        createCategoryLabel();
        createFlightRefLabel();
        createPassengerNameLabel();
        createFiledByLabel();
        createDescriptionLabel();

        createStatusDropDown();
        createCategoryDropDown();

        createFlightRefPlaceholder();
        createPassengerNamePlaceholder();
        createFiledByPlaceholder();
        createDescriptionScroll();
        createDescriptionPane();
        createSubmitBtn();
    }

    private void initLayout() {
        GroupLayout group = new GroupLayout(createAirlineBox);
        createAirlineBox.setLayout(group);
        group.setHorizontalGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(group.createSequentialGroup()
                .addGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(group.createSequentialGroup().addContainerGap().addGroup(group
                                .createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(group
                                        .createSequentialGroup().addGroup(group
                                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(statusDropdown,
                                                        GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(statusLabel,
                                                        GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(categoryDropdown,
                                                        GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(categoryLabel,
                                                        GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(group.createSequentialGroup()
                                                        .addComponent(flightRefLabel,
                                                                GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, Short.MAX_VALUE))
                                                .addComponent(flightRefPlaceholder)))
                                .addGroup(group.createSequentialGroup().addGroup(group
                                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(passengerNamePlaceholder,
                                                GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passengerNameLabel,
                                                GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(filedByLabel,
                                                        GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(filedByPlaceholder,
                                                        GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(group.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(descriptionScroll))
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
                                                .addGap(227, 227, 227)
                                                .addComponent(createBtn,
                                                        GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(group.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(descriptionLabel,
                                                        GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        group.setVerticalGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(group.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(titleIcon, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addGroup(group.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(titleLabel)))
                .addGap(36, 36, 36)
                .addGroup(group.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(statusLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addComponent(categoryLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addComponent(flightRefLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(group.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(statusDropdown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(categoryDropdown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(flightRefPlaceholder, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(group.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(filedByLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addComponent(passengerNameLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(group.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(passengerNamePlaceholder, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                        .addComponent(filedByPlaceholder, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(descriptionLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(descriptionScroll, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(createBtn, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(createAirlineBox, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(createAirlineBox, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void createStatusLabel() {
        statusLabel.setFont(new Font("Calibri", 0, 18));
        statusLabel.setForeground(new Color(91, 91, 91));
        statusLabel.setText("Status");
    }

    private void createCategoryLabel() {
        categoryLabel.setFont(new Font("Calibri", 0, 18));
        categoryLabel.setForeground(new Color(91, 91, 91));
        categoryLabel.setText("Category");
    }

    private void createFlightRefLabel() {
        flightRefLabel.setFont(new Font("Calibri", 0, 18));
        flightRefLabel.setForeground(new Color(91, 91, 91));
        flightRefLabel.setText("Flight ref");
    }

    private void createPassengerNameLabel() {
        passengerNameLabel.setFont(new Font("Calibri", 0, 18));
        passengerNameLabel.setForeground(new Color(91, 91, 91));
        passengerNameLabel.setText("Passenger Name");
    }

    private void createFiledByLabel() {
        filedByLabel.setFont(new Font("Calibri", 0, 18));
        filedByLabel.setForeground(new Color(91, 91, 91));
        filedByLabel.setText("Filed by");
    }

    private void createDescriptionLabel() {
        descriptionLabel.setFont(new Font("Calibri", 0, 18));
        descriptionLabel.setForeground(new Color(91, 91, 91));
        descriptionLabel.setText("Description");
    }

    private void createStatusDropDown() {
        statusDropdown.setFont(new Font("Calibri", 0, 18));
        statusDropdown.setModel(new DefaultComboBoxModel<>(new String[]{"Select...", "Pending", "Solved", "Cancelled"}));
        statusDropdown.setToolTipText("");
        statusDropdown.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        statusDropdown.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        statusDropdown.setFocusable(false);
        statusDropdown.setName("");
    }

    private void createCategoryDropDown() {
        categoryDropdown.setFont(new Font("Calibri", 0, 18));
        categoryDropdown.setModel(new DefaultComboBoxModel<>(new String[]{"Select...", "Luggage", "Immigration", "Passport"}));
        categoryDropdown.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        categoryDropdown.setFocusable(false);
    }


    private void createFlightRefPlaceholder() {
        flightRefPlaceholder.setFont(new Font("Calibri", 0, 18));
        flightRefPlaceholder.setForeground(new Color(51, 51, 51));
        flightRefPlaceholder.setBorder(new LineBorder(new Color(153, 153, 153), 1, true));

    }

    private void createPassengerNamePlaceholder() {
        passengerNamePlaceholder.setFont(new Font("Calibri", 0, 18));
        passengerNamePlaceholder.setForeground(new Color(51, 51, 51));
        passengerNamePlaceholder.setBorder(new LineBorder(new Color(153, 153, 153), 1, true));

    }

    private void createFiledByPlaceholder() {
        filedByPlaceholder.setFont(new Font("Calibri", 0, 18));
        filedByPlaceholder.setForeground(new Color(51, 51, 51));
        filedByPlaceholder.setBorder(new LineBorder(new Color(153, 153, 153), 1, true));

    }

    private void createDescriptionScroll() {
        descriptionScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    }

    private void createDescriptionPane() {
        descriptionPane.setFont(new Font("Segoe UI", 0, 14));
        descriptionPane.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        descriptionPane.setDisabledTextColor(new Color(0, 0, 0));
        descriptionPane.setDoubleBuffered(true);
        descriptionPane.setDragEnabled(true);
        descriptionPane.setMargin(new Insets(5, 5, 5, 5));
        descriptionScroll.setViewportView(descriptionPane);
    }

    private void createSubmitBtn() {
        createBtn.setBackground(new Color(109, 150, 244));
        createBtn.setFont(new Font("Calibri", 0, 18));
        createBtn.setForeground(new Color(255, 255, 255));
        createBtn.setText("CREATE");
        createBtn.setBorder(null);
    }

    private void addListeners() {
        createBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    IssuesRepositoryImpl repo = new IssuesRepositoryImpl();
                    Issue issue = repo.insert(new Issue(
                            getCategory((String) categoryDropdown.getSelectedItem()),
                            getStatus((String) statusDropdown.getSelectedItem()),
                            passengerNamePlaceholder.getText(),
                            filedByPlaceholder.getText(),
                            new Date(System.currentTimeMillis()),
                            descriptionPane.getText(),
                            Integer.parseInt(flightRefPlaceholder.getText())
                    ));
                    firePropertyChange(CREATED, null, issue.getId());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private IssueCategory getCategory(String c) {
        IssueCategory issueCategory = null;
        if (c.equals("Luggage")) {
            issueCategory = IssueCategory.LOST_LUGGAGE;
        }
        if (c.equals("Immigration")) {
            issueCategory = IssueCategory.IMMIGRATION;
        }
        if (c.equals("Passport")) {
            issueCategory = IssueCategory.VISA_PASSPORT;
        }
        return issueCategory;
    }

    private IssueStatus getStatus(String s) {
        IssueStatus issueStatus = null;
        if (s.equals("Pending")) {
            issueStatus = IssueStatus.PENDING;
        }
        if (s.equals("Solved")) {
            issueStatus = IssueStatus.RESOLVED;
        }
        if (s.equals("Cancelled")) {
            issueStatus = IssueStatus.CANCELLED;
        }
        return issueStatus;
    }
}
