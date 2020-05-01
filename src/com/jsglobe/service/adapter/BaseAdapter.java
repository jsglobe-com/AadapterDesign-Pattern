package com.jsglobe.service.adapter;

import com.jsglobe.service.DeviceStatus;
import com.jsglobe.service.NetworkDevice;

import java.awt.*;

public abstract class BaseAdapter implements DeviceAdapter {
    protected Color getStatusColor() {
        final DeviceStatus status = getDevice().getStatus();
        if (status == DeviceStatus.READY) return Color.GREEN;
        if (status == DeviceStatus.IDLE) return Color.ORANGE;
        if (status == DeviceStatus.UNREACHABLE) return Color.RED;
        return Color.GRAY;
    }

    protected void drawTitle(Graphics graphics) {
        final NetworkDevice device = getDevice();
        final Point point = getLocation();

        graphics.setColor(getStatusColor());
        graphics.fillOval(point.x - 5, point.y - 5, 10, 10);
        graphics.setColor(Color.BLACK);
        graphics.drawOval(point.x - 5, point.y - 5, 10, 10);
        graphics.drawString(device.getName(), point.x + 15, point.y + 5);
    }

    @Override
    public void draw(Graphics graphics) {
        drawTitle(graphics);
        drawIcon(graphics);
    }

    protected abstract void drawIcon(Graphics graphics);
}
