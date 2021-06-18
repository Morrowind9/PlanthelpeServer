package byr.win.planthelper.dao;

import byr.win.planthelper.domain.DeviceInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface DeviceInfoMapper {
    int deleteByPrimaryKey(Integer deviceId);

    int insert(DeviceInfo record);

    int insertSelective(DeviceInfo record);

    ArrayList<DeviceInfo> selectByPrimaryKey(Integer deviceId);

    int updateByPrimaryKeySelective(DeviceInfo record);

    int updateByPrimaryKey(DeviceInfo record);
}