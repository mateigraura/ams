package com.domain.entities.enumerators;

public enum FlightStatus {
    BOARDING(1),
    WAITING_FOR_TAXI(2),
    AIRBORNE(3),
    LANDED(4),
    STATIONED(5),
    WAITING_FOR_TAKEOFF(6);

    private final int value;

    public int getValue() {
        return value;
    }

    public static String getEnumName(int value) {
        for (FlightStatus e : FlightStatus.values())
            if (e.value == value) return e.name();
        return null;
    }

    public static FlightStatus getEnum(int value) {
        for (FlightStatus e : FlightStatus.values())
            if (e.value == value) return e;
        return null;
    }

    FlightStatus(int value) {
        this.value = value;
    }
}
