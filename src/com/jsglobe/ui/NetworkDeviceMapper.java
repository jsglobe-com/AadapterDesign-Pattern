package com.jsglobe.ui;

import com.jsglobe.service.NetworkDevice;
import com.jsglobe.service.adapter.DeviceAdapter;

import java.awt.*;
import java.util.List;

public interface NetworkDeviceMapper {
    List<DeviceAdapter> map(List<NetworkDevice> devices, Dimension size);
}
