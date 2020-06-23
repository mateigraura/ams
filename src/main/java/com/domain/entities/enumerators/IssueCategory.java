package com.domain.entities.enumerators;

public enum IssueCategory {
    LOST_LUGGAGE(1),
    VISA_PASSPORT(2),
    IMMIGRATION(3);

    private final int value;

    public int getValue() {
        return value;
    }

    public static String getEnumName(int value) {
        for (IssueCategory e : IssueCategory.values())
            if (e.value == value) return e.name();
        return null;
    }

    public static IssueCategory getEnum(int value) {
        for (IssueCategory e : IssueCategory.values())
            if (e.value == value) return e;
        return null;
    }

    IssueCategory(int value) {
        this.value = value;
    }
}
