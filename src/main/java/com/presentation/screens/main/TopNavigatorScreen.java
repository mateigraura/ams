package com.presentation.screens.main;

import com.assets.utils.AssetsPath;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;

@Getter
public class TopNavigatorScreen extends JFrame {

    private JPanel topPanel;
    private JLabel titleText;
    private JLabel titleIcon;

    public TopNavigatorScreen() {
        initComponents();
        initLayout();
        pack();
    }

    private void initComponents() {
        topPanel = new JPanel();
        titleText = new JLabel();
        titleIcon = new JLabel();

        topPanel.setBackground(new Color(91, 91, 91));

        createTitleText();
        createIcon();
    }

    private void initLayout() {
        GroupLayout topPanelLayout = new GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(topPanelLayout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(topPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(titleIcon)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titleText,
                                GroupLayout.PREFERRED_SIZE, 98,
                                GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(1191, Short.MAX_VALUE)
                )
        );
        topPanelLayout.setVerticalGroup(topPanelLayout
                .createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(topPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(topPanelLayout
                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(titleText)
                                .addComponent(titleIcon,
                                        GroupLayout.PREFERRED_SIZE, 53,
                                        GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                )
        );
    }

    private void createTitleText() {
        titleText.setBackground(new Color(223, 223, 226));
        titleText.setFont(new Font("Tw Cen MT Condensed Extra Bold", 0, 48));
        titleText.setForeground(new Color(223, 223, 226));
        titleText.setText("AMS");
    }

    private void createIcon() {
        Path icon = AssetsPath.getAbsolute("icon.png");
        titleIcon.setIcon(new ImageIcon(icon.toString()));
    }
}
