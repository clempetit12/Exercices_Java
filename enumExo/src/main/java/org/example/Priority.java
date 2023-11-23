package org.example;

public enum Priority {

    HIGH,
    MEDIUM,
    LOW,
    NONE;

    public static Priority getPriority(TpeMessage typeMessage) {

        switch (typeMessage) {
            case A:
                return HIGH;
            case B:
                return MEDIUM;
            case C:
                return LOW;
            case D :
                return LOW;
            default:
                return NONE;

        }

    }
}
