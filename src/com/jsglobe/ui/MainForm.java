package com.jsglobe.ui;

import com.jsglobe.service.NetworkDevice;
import com.jsglobe.service.NetworkDiscoveryService;
import com.jsglobe.service.adapter.AdapterFactory;
import com.jsglobe.service.adapter.DeviceAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class MainForm extends JFrame {
    private final JButton button = new JButton();
    private final NetworkMap networkMap = new NetworkMap();

    public MainForm() {
        setTitle("Network Map");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1060, 840);
        setLayout(null);
        add(networkMap);
        add(button);

        button.setText("Discover");
        button.setSize(140, 40);
        button.setLocation(890, 760);
        button.addActionListener(this::onButtonClick);

        networkMap.setLocation(10, 10);
        networkMap.setSize(1040, 730);
    }

    void onButtonClick(ActionEvent actionEvent) {
        final List<NetworkDevice> devices = NetworkDiscoveryService.getInstance().discover();
        final double step = 2 * Math.PI / devices.size();
        final int margin = 70;
        final int radius = Math.min(networkMap.getWidth(), networkMap.getHeight()) / 2 - margin;
        final List<DeviceAdapter> elements = new ArrayList<>();

        double angle = 0;
        for (NetworkDevice device : devices) {
            final int x = Math.toIntExact(Math.round(Math.sin(angle) * radius)) + networkMap.getWidth() / 2;
            final int y = Math.toIntExact(Math.round(Math.cos(angle) * radius)) + networkMap.getHeight() / 2;
            elements.add(AdapterFactory.create(device, new Point(x, y)));
            angle += step;
        }

        networkMap.setDevices(elements);
        networkMap.repaint();
    }
}