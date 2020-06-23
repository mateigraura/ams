package com.domain.entities.enumerators;

public enum IssueStatus {
    PENDING(1),
    CANCELLED(2),
    RESOLVED(3);

    private final int value;

    public int getValue() {
        return value;
    }

    public static String getEnumName(int value) {
        for (IssueStatus e : IssueStatus.values())
            if (e.value == value) return e.name();
        return null;
    }

    public static IssueStatus getEnum(int value) {
        for (IssueStatus e : IssueStatus.values())
            if (e.value == value) return e;
        return null;
    }

    IssueStatus(int value) {
        this.value = value;
    }
}
