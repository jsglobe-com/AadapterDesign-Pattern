package com.jsglobe.service;

import java.util.HashSet;
import java.util.Set;

public abstract class GenericNetworkDevice implements NetworkDevice {
    private final String address;
    private final String name;
    private final DeviceStatus status;
    private final Set<String> connections = new HashSet<>();

    public GenericNetworkDevice(String address, String name, DeviceStatus status) {
        this.address = address;
        this.name = name;
        this.status = status;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public DeviceStatus getStatus() {
        return status;
    }

    @Override
    public Set<String> getConnections() {
        return connections;
    }

    public void connect(NetworkDevice device) {
        this.connections.add(device.getAddress());
    }

}
