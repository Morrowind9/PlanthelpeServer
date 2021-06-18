package byr.win.planthelper.service;

import byr.win.planthelper.domain.PlantInfo;

import java.util.ArrayList;

public interface PlantInfoService {
    public PlantInfo getById(Integer id);
    public ArrayList<PlantInfo> getByOwnerId(Integer id);
    public PlantInfo insertInfo(PlantInfo plantInfo);
    public void updateInfo(PlantInfo plantInfo);
    public void deleteInfo(Integer id);
}
