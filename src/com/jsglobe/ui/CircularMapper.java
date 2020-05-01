package com.jsglobe.ui;

import com.jsglobe.service.NetworkDevice;
import com.jsglobe.service.adapter.AdapterFactory;
import com.jsglobe.service.adapter.DeviceAdapter;
import com.sun.jdi.DoubleValue;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CircularMapper implements NetworkDeviceMapper {

    @Override
    public List<DeviceAdapter> map(List<NetworkDevice> devices, Dimension size) {
        final double step = 2 * Math.PI / devices.size();
        final int margin = 70;
        final double radius = Math.min(size.getWidth(), size.getHeight()) / 2 - margin;
        final List<DeviceAdapter> elements = new ArrayList<>();

        double angle = 0;
        for (NetworkDevice device : devices) {
            final double x = Math.round(Math.sin(angle) * radius) + size.getWidth() / 2;
            final double y = Math.round(Math.cos(angle) * radius) + size.getHeight() / 2;
            final Point point = new Point(
                    Double.valueOf(x).intValue(),
                    Double.valueOf(y).intValue()
            );
            elements.add(AdapterFactory.create(device, point));
            angle += step;
        }

        return elements;
    }
}
