package byr.win.planthelper.service;

import byr.win.planthelper.domain.DeviceInfo;

import java.util.ArrayList;

public interface DeviceInfoService
{
    DeviceInfo getById(Integer deviceId);
    void updateInfo(DeviceInfo deviceInfo);
}
