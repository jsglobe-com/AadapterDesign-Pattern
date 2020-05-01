package com.jsglobe.ui;

import com.jsglobe.service.*;
import com.jsglobe.service.Random;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

import static java.util.Collections.emptyList;

public class NetworkMap extends JPanel {

    private List<NetworkDevice> devices = emptyList();
    private Map<String, Point> locations = new HashMap<>();

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        g.clearRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);

        paintDevices(g);
    }

    private void paintDevices(Graphics g) {
        for (NetworkDevice device : devices) {
            paintConnections(g, device, locations.get(device.getAddress()));
        }
        for (NetworkDevice device : devices) {
            paintDevice(g, device, locations.get(device.getAddress()));
        }
    }

    private void paintConnections(Graphics g, NetworkDevice device, Point point) {
        for (String connection : device.getConnections()) {
            if (!locations.containsKey(connection)) continue;
            final Point target = locations.get(connection);
            g.setColor(Color.LIGHT_GRAY);
            g.drawLine(point.x, point.y, target.x, target.y);
        }
    }

    private void paintDevice(Graphics g, NetworkDevice device, Point point) {
        if (device instanceof Printer) {
            paintPrinter(g, point);
        } else if (device instanceof Storage) {
            paintStorage(g, point);
        } else if (device instanceof Computer) {
            paintComputer(g, point);
        }

        drawTitle(g, device, point);
    }

    private void paintComputer(Graphics g, Point point) {
        final int x = point.x;
        final int y = point.y - 40;
        g.setColor(Color.darkGray);
        g.fillRoundRect(x, y, 30, 30, 10, 10);
        g.setColor(Color.BLACK);
        g.drawRoundRect(x, y, 30, 30, 10, 10);

        g.setColor(Color.lightGray);
        g.fillRoundRect(x + 5, y + 5, 20, 20, 5, 5);
        g.setColor(Color.BLACK);
        g.drawRoundRect(x + 5, y + 5, 20, 20, 5, 5);
    }

    private void paintPrinter(Graphics g, Point point) {
        final int x = point.x;
        final int y = point.y - 50;
        g.setColor(Color.lightGray);
        g.fillRoundRect(x, y + 10, 40, 25, 5, 10);

        g.setColor(Color.BLACK);
        g.drawRoundRect(x, y + 10, 40, 25, 5, 10);

        g.setColor(Color.WHITE);
        g.fillRect(x + 5, y + 5, 30, 20);

        g.setColor(Color.BLACK);
        g.drawRect(x + 5, y + 5, 30, 20);

        var delta = 10;
        for (int i = 0; i < 5; i++) {
            int extra = Random.number(3, 5);
            g.drawLine(
                    x + 10,
                    y + delta,
                    x + 20 + extra,
                    y + delta
            );
            delta += 3;
        }
    }

    private void paintStorage(Graphics g, Point point) {
        final int x = point.x;
        final int y = point.y - 50;
        g.setColor(Color.YELLOW);
        g.fillRect(x, y + 5, 30, 30);

        g.setColor(Color.black);
        g.drawRect(x, y + 5, 30, 30);

        g.setColor(Color.YELLOW);
        g.fillOval(x, y, 30, 10);
        g.setColor(Color.black);
        g.drawOval(x, y, 30, 10);

        g.setColor(Color.YELLOW);
        g.fillOval(x, y + 30, 30, 10);

        g.setColor(Color.black);
        g.drawArc(x, y + 30, 30, 10, 180, 180);
    }

    private Color statusColor(DeviceStatus status) {
        if (status == DeviceStatus.READY) return Color.GREEN;
        if (status == DeviceStatus.IDLE) return Color.ORANGE;
        if (status == DeviceStatus.UNREACHABLE) return Color.RED;
        return Color.GRAY;
    }

    private void drawTitle(Graphics g, NetworkDevice device, Point point) {
        g.setColor(statusColor(device.getStatus()));
        g.fillOval(point.x - 5, point.y - 5, 10, 10);
        g.setColor(Color.BLACK);
        g.drawOval(point.x - 5, point.y - 5, 10, 10);
        g.drawString(device.getName(), point.x + 15, point.y + 5);
    }

    public void setDevices(List<NetworkDevice> devices) {
        this.devices = devices;
        final double step = 2 * Math.PI / devices.size();
        final int margin = 70;
        final int radius = Math.min(getWidth(), getHeight()) / 2 - margin;
        double angle = 0;
        for (NetworkDevice device : devices) {
            final int x = Math.toIntExact(Math.round(Math.sin(angle) * radius)) + this.getWidth() / 2;
            final int y = Math.toIntExact(Math.round(Math.cos(angle) * radius)) + this.getHeight() / 2;
            locations.put(device.getAddress(), new Point(x, y));
            angle += step;
        }

    }
}
