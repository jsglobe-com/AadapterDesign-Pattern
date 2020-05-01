package com.jsglobe.service.adapter;

import com.jsglobe.service.Computer;

import java.awt.*;

public class ComputerAdapter implements DeviceAdapter {
    private final Point point;
    private final Computer computer;

    public ComputerAdapter(Computer device, Point point) {
        computer = device;
        this.point =point;
    }

    @Override
    public Point getLocation() {
        return point;
    }

    @Override
    public void draw(Graphics graphics) {
        final int x = point.x;
        final int y = point.y - 40;
        graphics.setColor(Color.darkGray);
        graphics.fillRoundRect(x, y, 30, 30, 10, 10);
        graphics.setColor(Color.BLACK);
        graphics.drawRoundRect(x, y, 30, 30, 10, 10);

        graphics.setColor(Color.lightGray);
        graphics.fillRoundRect(x + 5, y + 5, 20, 20, 5, 5);
        graphics.setColor(Color.BLACK);
        graphics.drawRoundRect(x + 5, y + 5, 20, 20, 5, 5);
    }
}
