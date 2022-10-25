package com.noeticworld.apiEndpoint;

public interface Vehicle {
    default String turnAlarmOn() {
        return "Turning the alarm on. vehicle";
    }

    default String turnAlarmOff() {
        return "Turning the alarm off. vehicle";
    }

}
