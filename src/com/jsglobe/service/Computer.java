package com.jsglobe.service;

public class Computer extends GenericNetworkDevice implements NetworkDevice {

    public Computer(String address, String name, DeviceStatus status) {
        super(address, name, status);
    }
}
