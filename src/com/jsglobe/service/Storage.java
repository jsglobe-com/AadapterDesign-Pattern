package com.jsglobe.service;

import java.util.HashMap;
import java.util.Map;

public class Storage extends GenericNetworkDevice implements NetworkDevice {
    private Map<String, String> data = new HashMap<>();

    public Storage(String address, String name, DeviceStatus status) {
        super(address, name, status);
    }

    public String read(String file) {
        if (getStatus() != DeviceStatus.READY) {
            throw new RuntimeException("Device is not ready.");
        }
        if (!data.containsKey(file)) {
            throw new RuntimeException("File not found.");
        }
        return data.get(file);
    }

    public String write(String file) {
        if (getStatus() != DeviceStatus.READY) {
            throw new RuntimeException("Device is not ready.");
        }

        return data.get(file);
    }
}
