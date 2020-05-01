package com.jsglobe.service.adapter;

import com.jsglobe.service.NetworkDevice;

import java.awt.*;

public interface DeviceAdapter {
    Point getLocation();

    NetworkDevice getDevice();

    void draw(Graphics graphics);
}
