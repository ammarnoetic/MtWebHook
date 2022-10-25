package com.noeticworld.apiEndpoint;

public class Car implements Vehicle, Alarm{
    @Override
    public String turnAlarmOn() {
        return Vehicle.super.turnAlarmOn();
    }

    @Override
    public String turnAlarmOff() {
        return Alarm.super.turnAlarmOff();
    }
}
