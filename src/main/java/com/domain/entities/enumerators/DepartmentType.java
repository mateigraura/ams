package com.domain.entities.enumerators;

public enum DepartmentType {
    FINANCIAL(1),
    CHECKIN(2),
    CUSTOMS(3),
    GROUNDCONTROL(4);

    private final int value;

    public int getValue() {
        return value;
    }

    public static String getEnumName(int value) {
        for (DepartmentType e : DepartmentType.values())
            if (e.value == value) return e.name();

        return null;
    }

    DepartmentType(int value) {
        this.value = value;
    }
}
