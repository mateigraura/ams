
package com.presentation.screens.widgets;

import com.assets.utils.AssetsPath;
import com.domain.entities.Airline;
import lombok.Getter;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.file.Path;

@Getter
public class CreateAirlineBox extends JFrame {
    public static final String CREATED = "created";

    private JTextField allianceField;
    private JLabel allianceFieldLabel;
    private JPanel createAirlineBox;
    private JButton createBtn;
    private JTextField hubField;
    private JLabel hubFieldLabel;
    private JTextField nameField;
    private JLabel nameFieldLabel;
    private JLabel titleIcon;
    private JLabel titleLabel;

    public CreateAirlineBox() {
        initComponents();
        initLayout();
        addListeners();
        pack();
    }

    private void initComponents() {
        createAirlineBox = new JPanel();
        titleIcon = new JLabel();
        titleLabel = new JLabel();
        nameFieldLabel = new JLabel();
        nameField = new JTextField();
        allianceFieldLabel = new JLabel();
        allianceField = new JTextField();
        hubFieldLabel = new JLabel();
        hubField = new JTextField();
        createBtn = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        createAirlineBox.setBackground(new Color(255, 255, 255));
        createAirlineBox.setLayout(new AbsoluteLayout());

        createIcon();
        createAirlineBox.add(titleIcon, new AbsoluteConstraints(10, 11, 54, 39));

        createTitleLabel();
        createAirlineBox.add(titleLabel, new AbsoluteConstraints(70, 30, 68, -1));

        createNameFieldLabel();
        createAirlineBox.add(nameFieldLabel, new AbsoluteConstraints(20, 80, 60, 29));

        createNameField();
        createAirlineBox.add(nameField, new AbsoluteConstraints(10, 110, 330, 40));

        createAllianceFieldLabel();
        createAirlineBox.add(allianceFieldLabel, new AbsoluteConstraints(20, 180, 80, 29));

        createAllianceField();
        createAirlineBox.add(allianceField, new AbsoluteConstraints(10, 210, 330, 40));

        createHubFieldLabel();
        createAirlineBox.add(hubFieldLabel, new AbsoluteConstraints(20, 280, 80, 29));

        createHubField();
        createAirlineBox.add(hubField, new AbsoluteConstraints(10, 310, 330, 40));

        createSubmitBtn();
        createAirlineBox.add(createBtn, new AbsoluteConstraints(100, 380, 147, 42));
    }

    private void initLayout() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(createAirlineBox,
                                GroupLayout.Alignment.TRAILING,
                                GroupLayout.PREFERRED_SIZE, 350,
                                GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(createAirlineBox,
                                GroupLayout.PREFERRED_SIZE, 455,
                                GroupLayout.PREFERRED_SIZE)
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

    private void createNameFieldLabel() {
        nameFieldLabel.setFont(new Font("Calibri", 0, 18));
        nameFieldLabel.setForeground(new Color(91, 91, 91));
        nameFieldLabel.setText("Name");
    }

    private void createNameField() {
        nameField.setFont(new Font("Calibri", 0, 18));
        nameField.setForeground(new Color(51, 51, 51));
        nameField.setBorder(new LineBorder(new Color(153, 153, 153), 1, true));
    }

    private void createAllianceFieldLabel() {
        allianceFieldLabel.setFont(new Font("Calibri", 0, 18));
        allianceFieldLabel.setForeground(new Color(91, 91, 91));
        allianceFieldLabel.setText("Alliance");
    }

    private void createAllianceField() {
        allianceField.setFont(new Font("Calibri", 0, 18));
        allianceField.setForeground(new Color(51, 51, 51));
        allianceField.setBorder(new LineBorder(new Color(153, 153, 153), 1, true));
    }

    private void createHubFieldLabel() {
        hubFieldLabel.setFont(new Font("Calibri", 0, 18));
        hubFieldLabel.setForeground(new Color(91, 91, 91));
        hubFieldLabel.setText("Main Hub");
    }

    private void createHubField() {
        hubField.setFont(new Font("Calibri", 0, 18));
        hubField.setForeground(new Color(51, 51, 51));
        hubField.setBorder(new LineBorder(new Color(153, 153, 153), 1, true));
    }

    private void createSubmitBtn() {
        createBtn.setBackground(new Color(109, 150, 244));
        createBtn.setFont(new Font("Calibri", 0, 18));
        createBtn.setForeground(new Color(255, 255, 255));
        createBtn.setText("CREATE");
        createBtn.setBorder(null);
    }

    // TODO: fix boxes (should fire event not mutate state themselves)
    private void addListeners() {
        createBtn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                try {
                    firePropertyChange(CREATED, null,
                            new Airline(
                                    nameField.getText(),
                                    allianceField.getText(),
                                    hubField.getText()
                            )
                    );
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
