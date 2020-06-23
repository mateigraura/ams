package com.domain.entities.enumerators;

public enum RunwayStatus {
    FUNCTIONAL(1),
    MAINTAINANCE(2),
    DEFUNCT(3);

    private final int value;

    public int getValue() {
        return value;
    }

    public static String getEnumName(int value) {
        for (RunwayStatus e : RunwayStatus.values())
            if (e.value == value) return e.name();

        return null;
    }

    RunwayStatus(int value) {
        this.value = value;
    }
}
