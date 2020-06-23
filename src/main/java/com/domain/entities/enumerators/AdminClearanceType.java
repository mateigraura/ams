package com.domain.entities.enumerators;

public enum AdminClearanceType {
    SUPERADMIN(1),
    MODERATOR(2);

    private final int value;

    public int getValue() {
        return value;
    }

    public static String getEnumName(int value) {
        for (AdminClearanceType e : AdminClearanceType.values())
            if (e.value == value) return e.name();

        return null;
    }

    AdminClearanceType(int value) {
        this.value = value;
    }
}
