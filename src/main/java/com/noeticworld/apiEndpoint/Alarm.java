package com.noeticworld.apiEndpoint;

public interface Alarm {
    default String turnAlarmOn() {
        return "Turning the alarm on. alarm";
    }

    default String turnAlarmOff() {
        return "Turning the alarm off.alarm";
    }
}
