package byr.win.planthelper.dao;

import byr.win.planthelper.domain.PlantInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface PlantInfoMapper {
    int deleteByPrimaryKey(Integer plantId);

    int insert(PlantInfo record);

    int insertSelective(PlantInfo record);

    ArrayList<PlantInfo> selectByPrimaryKey(Integer plantId);

    ArrayList<PlantInfo> selectByOwnerId(Integer ownerId);

    int updateByPrimaryKeySelective(PlantInfo record);

    int updateByPrimaryKey(PlantInfo record);
}