package com.jsglobe.ui;

import com.jsglobe.service.NetworkDevice;
import com.jsglobe.service.NetworkDiscoveryService;
import com.jsglobe.service.adapter.DeviceAdapter;

import javax.swing.*;
import java.awt.event.ActionEvent;
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
        final NetworkDeviceMapper mapper = new CircularMapper();
        final List<DeviceAdapter> elements = mapper.map(devices, networkMap.getSize());

        networkMap.setDevices(elements);
        networkMap.repaint();
    }
}