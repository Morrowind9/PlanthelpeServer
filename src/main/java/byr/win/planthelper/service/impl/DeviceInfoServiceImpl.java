package byr.win.planthelper.service.impl;

import byr.win.planthelper.dao.DeviceInfoMapper;
import byr.win.planthelper.domain.DeviceInfo;
import byr.win.planthelper.service.DeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DeviceInfoServiceImpl implements DeviceInfoService
{
    @Autowired
    private DeviceInfoMapper deviceInfoMapper;

    @Override
    public DeviceInfo getById(Integer deviceId)
    {
        ArrayList<DeviceInfo> res = deviceInfoMapper.selectByPrimaryKey(deviceId);

        if(res.size() == 0)
            return null;
        else
            return res.get(0);
    }

    @Override
    public void updateInfo(DeviceInfo deviceInfo)
    {
        deviceInfoMapper.updateByPrimaryKeySelective(deviceInfo);
    }

}
