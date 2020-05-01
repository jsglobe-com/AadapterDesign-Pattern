package com.jsglobe.service.adapter;

import com.jsglobe.service.NetworkDevice;
import com.jsglobe.service.Storage;

import java.awt.*;

public class StorageAdapter  extends BaseAdapter implements DeviceAdapter {
    private final Point point;
    private final Storage storage;

    public StorageAdapter(Storage device, Point point) {
        this.point = point;
        this.storage = device;
    }

    @Override
    public Point getLocation() {
        return point;
    }

    @Override
    public NetworkDevice getDevice() {
        return storage;
    }

    protected void drawIcon(Graphics graphics) {
        final int x = point.x;
        final int y = point.y - 50;
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(x, y + 5, 30, 30);

        graphics.setColor(Color.black);
        graphics.drawRect(x, y + 5, 30, 30);

        graphics.setColor(Color.YELLOW);
        graphics.fillOval(x, y, 30, 10);
        graphics.setColor(Color.black);
        graphics.drawOval(x, y, 30, 10);

        graphics.setColor(Color.YELLOW);
        graphics.fillOval(x, y + 30, 30, 10);

        graphics.setColor(Color.black);
        graphics.drawArc(x, y + 30, 30, 10, 180, 180);
    }
}
