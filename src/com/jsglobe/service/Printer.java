package com.jsglobe.service;

public class Printer extends GenericNetworkDevice implements NetworkDevice {

    public Printer(String address, String name, DeviceStatus status) {
        super(address, name, status);
    }

    public void print(String data) {
        if (getStatus() != DeviceStatus.READY) {
            throw new RuntimeException("Printer is not ready.");
        }
        System.out.println("PRINT SOME DATA: " + data);
    }

}
