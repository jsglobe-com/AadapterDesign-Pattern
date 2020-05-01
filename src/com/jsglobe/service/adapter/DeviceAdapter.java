package com.jsglobe.service.adapter;

import java.awt.*;

public interface DeviceAdapter {
    Point getLocation();

    void draw(Graphics graphics);
}
