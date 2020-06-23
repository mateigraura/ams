
package com.presentation.screens.widgets;

import com.assets.utils.AssetsPath;
import com.domain.entities.Issue;
import com.domain.entities.enumerators.IssueCategory;
import com.domain.entities.enumerators.IssueStatus;
import com.domain.repositories.IssuesRepositoryImpl;
import lombok.Getter;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.file.Path;

@Getter
public class EditIssueBox extends JFrame {
    public static final String UPDATED = "updated";

    private JComboBox<String> categoryDropdown;
    private JLabel categoryDropdownLabel;
    private JButton createBtn;
    private JLabel descriptionFieldLabel;
    private JTextPane descriptionPane;
    private JScrollPane descriptionScroll;
    private JPanel editIssueBox;
    private JComboBox<String> statusDropdown;
    private JLabel statusDropdownLabel;
    private JLabel titleIcon;
    private JLabel titleLabel;

    private int id;

    public EditIssueBox(int id) {
        this.id = id;
        initComponents();
        initLayout();
        addListeners();
        pack();
    }

    private void initComponents() {
        editIssueBox = new JPanel();
        titleIcon = new JLabel();
        titleLabel = new JLabel();
        descriptionFieldLabel = new JLabel();
        descriptionScroll = new JScrollPane();
        descriptionPane = new JTextPane();
        statusDropdownLabel = new JLabel();
        categoryDropdownLabel = new JLabel();
        statusDropdown = new JComboBox<>();
        categoryDropdown = new JComboBox<>();
        createBtn = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new AbsoluteLayout());

        editIssueBox.setBackground(new Color(255, 255, 255));

        createIcon();
        createTitle();
        createDescriptionLabel();

        descriptionScroll.setHorizontalScrollBarPolicy(
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        createDescriptionScroll();

        createStatusDropdown();
        createCategoryDropdown();

        createSubmitBtn();
    }

    private void initLayout() {
        GroupLayout group = new GroupLayout(editIssueBox);
        editIssueBox.setLayout(group);
        group.setHorizontalGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, group.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(createBtn,
                                GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144))
                .addGroup(group.createSequentialGroup().addGroup(group
                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(group.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(titleIcon,
                                        GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(titleLabel,
                                        GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
                        .addGroup(group.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(descriptionFieldLabel,
                                        GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(group.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(descriptionScroll)
                                .addGroup(GroupLayout.Alignment.TRAILING, group.createSequentialGroup().addGroup(group
                                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(statusDropdown,
                                                GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(statusDropdownLabel,
                                                GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                                        .addGroup(group
                                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(categoryDropdown,
                                                        GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(categoryDropdownLabel,
                                                        GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
        );
        group.setVerticalGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(group
                .createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(group.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(titleIcon,
                                GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addGroup(group.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(titleLabel)))
                .addGap(20, 20, 20)
                .addComponent(descriptionFieldLabel,
                        GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionScroll,
                        GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(group.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(categoryDropdownLabel,
                                GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                        .addComponent(statusDropdownLabel,
                                GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(group.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(statusDropdown,
                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(categoryDropdown,
                                GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(createBtn, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        getContentPane().add(editIssueBox, new AbsoluteConstraints(0, 0, -1, -1));
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

    private void createDescriptionLabel() {
        descriptionFieldLabel.setFont(new Font("Calibri", 0, 18));
        descriptionFieldLabel.setForeground(new Color(91, 91, 91));
        descriptionFieldLabel.setText("Description");
    }

    private void createDescriptionScroll() {
        descriptionScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        descriptionPane.setFont(new Font("Segoe UI", 0, 14));
        descriptionPane.setText("");
        descriptionPane.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        descriptionPane.setDisabledTextColor(new Color(0, 0, 0));
        descriptionPane.setDoubleBuffered(true);
        descriptionPane.setDragEnabled(true);
        descriptionPane.setMargin(new Insets(5, 5, 5, 5));
        descriptionScroll.setViewportView(descriptionPane);
    }

    private void createStatusDropdown() {
        statusDropdownLabel.setFont(new Font("Calibri", 0, 18));
        statusDropdownLabel.setForeground(new Color(91, 91, 91));
        statusDropdownLabel.setText("Status");
        statusDropdown.setFont(new Font("Calibri", 0, 18));
        statusDropdown.setModel(new DefaultComboBoxModel<>(new String[]{"Select...", "Pending", "Solved", "Cancelled"}));
        statusDropdown.setToolTipText("");
        statusDropdown.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        statusDropdown.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        statusDropdown.setFocusable(false);
        statusDropdown.setName("");
    }

    private void createCategoryDropdown() {
        categoryDropdownLabel.setFont(new Font("Calibri", 0, 18));
        categoryDropdownLabel.setForeground(new Color(91, 91, 91));
        categoryDropdownLabel.setText("Category");
        categoryDropdown.setFont(new Font("Calibri", 0, 18));
        categoryDropdown.setModel(new DefaultComboBoxModel<>(new String[]{"Select...", "Luggage", "Immigration", "Passport"}));
        categoryDropdown.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        categoryDropdown.setFocusable(false);
    }

    private void createSubmitBtn() {
        createBtn.setBackground(new Color(109, 150, 244));
        createBtn.setFont(new Font("Calibri", 1, 18));
        createBtn.setForeground(new Color(255, 255, 255));
        createBtn.setText("Submit");
        createBtn.setBorder(null);
    }

    private void addListeners() {
        createBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    IssuesRepositoryImpl issuesRepository = new IssuesRepositoryImpl();
                    String cat = (String) categoryDropdown.getSelectedItem();
                    String sts = (String) statusDropdown.getSelectedItem();
                    IssueCategory issueCategory = getCategory(cat);
                    IssueStatus issueStatus = getStatus(sts);

                    Issue issue = issuesRepository.update(new Issue(
                            id,
                            issueCategory,
                            issueStatus,
                            null,
                            null,
                            null,
                            descriptionPane.getText(),
                            null
                    ));
                    firePropertyChange(UPDATED, null, issue.getId());
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
