package com.jsglobe.service;

import java.util.Set;

public interface NetworkDevice {
    String getAddress();

    String getName();

    DeviceStatus getStatus();

    Set<String> getConnections();

    void connect(NetworkDevice device);
}
