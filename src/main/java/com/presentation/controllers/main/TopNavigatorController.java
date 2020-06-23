package com.presentation.controllers.main;

import com.presentation.screens.main.TopNavigatorScreen;
import lombok.Getter;

@Getter
public class TopNavigatorController {

    private TopNavigatorScreen topNavigatorScreen;

    public TopNavigatorController() {
        topNavigatorScreen = new TopNavigatorScreen();
    }
}
