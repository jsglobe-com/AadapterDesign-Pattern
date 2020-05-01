package com.jsglobe.service.adapter;

import com.jsglobe.service.Computer;
import com.jsglobe.service.NetworkDevice;
import com.jsglobe.service.Printer;
import com.jsglobe.service.Storage;

import java.awt.*;

public class AdapterFactory {
    public static DeviceAdapter create(NetworkDevice device, Point point) {
        if (device instanceof Printer) {
            return new PrinterAdapter((Printer) device, point);
        } else if (device instanceof Computer) {
            return new ComputerAdapter((Computer) device, point);
        } else if (device instanceof Storage) {
            return new StorageAdapter((Storage) device, point);
        }
        throw new RuntimeException("Not supported device");
    }
}
