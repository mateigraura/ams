package com.domain.entities.enumerators;

public enum CheckinStatus {
    ONGOING(1),
    DELAYED(2),
    CLOSED(3),
    ONHOLD(4);

    private final int value;

    public int getValue() {
        return value;
    }

    public static String getEnumName(int value) {
        for (CheckinStatus e : CheckinStatus.values())
            if (e.value == value) return e.name();

        return null;
    }

    public static CheckinStatus getEnum(int value) {
        for (CheckinStatus e : CheckinStatus.values())
            if (e.value == value) return e;

        return null;
    }

    CheckinStatus(int value) {
        this.value = value;
    }
}
