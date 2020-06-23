package com.presentation.controllers.main;

import com.presentation.screens.main.SideNavigatorScreen;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Getter
public class SideNavigatorController extends JFrame {

    public static final String CLICK = "clicked";

    private final Color enteredColor;
    private final Color exitedColor;

    private SideNavigatorScreen sideNavigatorScreen;

    public SideNavigatorController() {
        sideNavigatorScreen = new SideNavigatorScreen();
        enteredColor = new Color(153, 153, 153);
        exitedColor = new Color(91, 91, 91);
        addListeners();
    }

    private void addListeners() {
        sideNavigatorScreen.getFlightsBtn().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                clicked(evt);
            }

            public void mouseEntered(MouseEvent evt) {
                entered(evt);
            }

            public void mouseExited(MouseEvent evt) {
                exited(evt);
            }
        });

        sideNavigatorScreen.getAirlinesBtn().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                clicked(evt);
            }

            public void mouseEntered(MouseEvent evt) {
                entered(evt);
            }

            public void mouseExited(MouseEvent evt) {
                exited(evt);
            }
        });

        sideNavigatorScreen.getCheckinBtn().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                clicked(evt);
            }

            public void mouseEntered(MouseEvent evt) {
                entered(evt);
            }

            public void mouseExited(MouseEvent evt) {
                exited(evt);
            }
        });

        sideNavigatorScreen.getIssuesBtn().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                clicked(evt);
            }

            public void mouseEntered(MouseEvent evt) {
                entered(evt);
            }

            public void mouseExited(MouseEvent evt) {
                exited(evt);
            }
        });
    }

    private void setButtonColorEnter(JPanel jPanel) {
        jPanel.setBackground(enteredColor);
    }

    private void setButtonColorExit(JPanel jPanel) {
        jPanel.setBackground(exitedColor);
    }

    public void clicked(MouseEvent evt) {
        if (evt.getSource() instanceof JPanel) {
            firePropertyChange(CLICK, null, evt);
        }
    }

    public void entered(MouseEvent evt) {
        if (evt.getSource() == sideNavigatorScreen.getFlightsBtn()) {
            setButtonColorEnter(sideNavigatorScreen.getFlightsBtn());
        }
        if (evt.getSource() == sideNavigatorScreen.getAirlinesBtn()) {
            setButtonColorEnter(sideNavigatorScreen.getAirlinesBtn());
        }
        if (evt.getSource() == sideNavigatorScreen.getCheckinBtn()) {
            setButtonColorEnter(sideNavigatorScreen.getCheckinBtn());
        }
        if (evt.getSource() == sideNavigatorScreen.getIssuesBtn()) {
            setButtonColorEnter(sideNavigatorScreen.getIssuesBtn());
        }
    }

    public void exited(MouseEvent evt) {
        if (evt.getSource() == sideNavigatorScreen.getFlightsBtn()) {
            setButtonColorExit(sideNavigatorScreen.getFlightsBtn());
        }
        if (evt.getSource() == sideNavigatorScreen.getAirlinesBtn()) {
            setButtonColorExit(sideNavigatorScreen.getAirlinesBtn());
        }
        if (evt.getSource() == sideNavigatorScreen.getCheckinBtn()) {
            setButtonColorExit(sideNavigatorScreen.getCheckinBtn());
        }
        if (evt.getSource() == sideNavigatorScreen.getIssuesBtn()) {
            setButtonColorExit(sideNavigatorScreen.getIssuesBtn());
        }
    }
}
