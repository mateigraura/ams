package com.domain.entities.enumerators;

public enum RunwayType {
    TAXIWAY(1),
    LANDING(2),
    DEPARTURE(3);

    private final int value;

    public int getValue() {
        return value;
    }

    public static String getEnumName(int value) {
        for (RunwayType e : RunwayType.values())
            if (e.value == value) return e.name();

        return null;
    }

    RunwayType(int value) {
        this.value = value;
    }
}
