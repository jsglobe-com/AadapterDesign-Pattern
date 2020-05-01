package com.jsglobe.service;

import java.util.ArrayList;
import java.util.List;

public class NetworkDiscoveryService {
    private static NetworkDiscoveryService instance;

    public static NetworkDiscoveryService getInstance() {
        synchronized (NetworkDiscoveryService.class) {
            if (instance == null) {
                instance = new NetworkDiscoveryService();
            }
        }
        return instance;
    }

    public List<NetworkDevice> discover() {
        final List<NetworkDevice> devices = new ArrayList<>();
        final double random = 5 + Math.ceil(Math.random() * 10);
        for (int i = 0; i < random; i++) {
            devices.add(randomDevice());
        }
        makeRandomConnections(devices);
        return devices;
    }

    private void makeRandomConnections(List<NetworkDevice> devices) {
        for (NetworkDevice device : devices) {
            for (int i = 0; i < 3; i++) {
                if (Random.number(1, 5) < 3) {
                    device.connect(devices.get(Random.number(0, devices.size() - 1)));
                }
            }
        }
    }

    private NetworkDevice randomDevice() {
        final double random = Math.random();
        if (random < 0.5) return randomComputer();
        if (random < 0.8) return randomStorage();
        return randomPrinter();
    }

    private Printer randomPrinter() {
        return new Printer(
                Random.address(),
                Random.name() + "'s printer",
                DeviceStatus.values()[Random.number(0, DeviceStatus.values().length - 1)]
        );
    }

    private Storage randomStorage() {
        return new Storage(
                Random.address(),
                Random.city(),
                DeviceStatus.values()[Random.number(0, DeviceStatus.values().length - 1)]
        );
    }

    private Computer randomComputer() {
        return new Computer(
                Random.address(),
                Random.fullName(),
                DeviceStatus.values()[Random.number(0, DeviceStatus.values().length - 1)]
        );
    }
}
