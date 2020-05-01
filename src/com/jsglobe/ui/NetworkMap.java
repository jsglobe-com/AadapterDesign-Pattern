package com.jsglobe.ui;

import com.jsglobe.service.adapter.DeviceAdapter;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetworkMap extends JPanel {
    private Map<String, DeviceAdapter> deviceMap = new HashMap<>();

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        paintConnections(g);
        paintDevices(g);
    }

    private void paintDevices(Graphics g) {
        for (DeviceAdapter device : this.deviceMap.values()) {
            device.draw(g);
        }
    }

    private void paintConnections(Graphics g) {
        for (final DeviceAdapter adapter : deviceMap.values()) {
            for (String address : adapter.getDevice().getConnections()) {
                final Point source = adapter.getLocation();
                final Point target = deviceMap.get(address).getLocation();
                g.setColor(Color.LIGHT_GRAY);
                g.drawLine(source.x, source.y, target.x, target.y);
            }
        }
    }

    public void setDevices(List<DeviceAdapter> devices) {
        for (DeviceAdapter device : devices) {
            deviceMap.put(device.getDevice().getAddress(), device);
        }
    }
}
