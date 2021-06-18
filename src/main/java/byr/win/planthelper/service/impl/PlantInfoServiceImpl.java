package byr.win.planthelper.service.impl;

import byr.win.planthelper.dao.PlantInfoMapper;
import byr.win.planthelper.domain.PlantInfo;
import byr.win.planthelper.service.PlantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlantInfoServiceImpl implements PlantInfoService
{
    @Autowired
    private PlantInfoMapper plantInfoMapper;

    @Override
    public PlantInfo getById(Integer id)
    {
        ArrayList<PlantInfo> res = plantInfoMapper.selectByPrimaryKey(id);
        if(res.size() == 0)
            return null;
        else
            return res.get(0);
    }

    @Override
    public ArrayList<PlantInfo> getByOwnerId(Integer id)
    {
        ArrayList<PlantInfo> res = plantInfoMapper.selectByOwnerId(id);
        if(res.size() == 0)
            return null;
        else
            return res;
    }

    @Override
    public PlantInfo insertInfo(PlantInfo plantInfo)
    {
        plantInfoMapper.insert(plantInfo);
        return plantInfo;
    }

    @Override
    public void updateInfo(PlantInfo plantInfo)
    {
        plantInfoMapper.updateByPrimaryKeySelective(plantInfo);
    }

    @Override
    public void deleteInfo(Integer id)
    {
        plantInfoMapper.deleteByPrimaryKey(id);
    }
}
