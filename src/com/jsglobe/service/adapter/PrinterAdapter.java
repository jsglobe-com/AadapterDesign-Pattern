package com.jsglobe.service.adapter;

import com.jsglobe.service.Printer;
import com.jsglobe.service.Random;

import java.awt.*;

public class PrinterAdapter implements DeviceAdapter {
    private final Printer printer;
    private final Point point;

    public PrinterAdapter(Printer printer, Point point) {
        this.printer = printer;
        this.point = point;
    }

    @Override
    public Point getLocation() {
        return point;
    }

    @Override
    public void draw(Graphics graphics) {
        final int x = point.x;
        final int y = point.y - 50;
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRoundRect(x, y + 10, 40, 25, 5, 10);

        graphics.setColor(Color.BLACK);
        graphics.drawRoundRect(x, y + 10, 40, 25, 5, 10);

        graphics.setColor(Color.WHITE);
        graphics.fillRect(x + 5, y + 5, 30, 20);

        graphics.setColor(Color.BLACK);
        graphics.drawRect(x + 5, y + 5, 30, 20);

        var delta = 10;
        for (int i = 0; i < 5; i++) {
            int extra = Random.number(3, 5);
            graphics.drawLine(
                    x + 10,
                    y + delta,
                    x + 20 + extra,
                    y + delta
            );
            delta += 3;
        }
    }

    public void print(String data) {
        printer.print(data);
    }
}
