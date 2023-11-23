package org.example;

public enum Priority {

HIGH,
    MEDIUM,
    LOW,
NONE;

    public static Priority getPriority(String typeMessage) {

        switch (typeMessage) {
            case "A":
                return  HIGH;

            case "B":
               return MEDIUM;

            case "C":
                return  LOW;

            case "D":
                return LOW;

        }

    }
}
