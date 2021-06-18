package byr.win.planthelper.controller;

import byr.win.planthelper.beans.PlantUpdateInfo;
import byr.win.planthelper.domain.CategoryInfo;
import byr.win.planthelper.domain.DeviceInfo;
import byr.win.planthelper.domain.PlantInfo;
import byr.win.planthelper.service.CategoryInfoService;
import byr.win.planthelper.service.DeviceInfoService;
import byr.win.planthelper.service.PlantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/plant")
public class PlantInfoController
{
    @Autowired
    private PlantInfoService plantInfoService;
    @Autowired
    private DeviceInfoService deviceInfoService;
    @Autowired
    private CategoryInfoService categoryInfoService;

    @RequestMapping("/getByOwner")
    public ArrayList<PlantInfo> getByOwner(Integer ownerId)
    {
        ArrayList<PlantInfo> res = plantInfoService.getByOwnerId(ownerId);
        return res;
    }

    @RequestMapping("/getById")
    public PlantInfo getById(Integer plantId)
    {
        PlantInfo res = plantInfoService.getById(plantId);
        return res;
    }

    @RequestMapping("/addPlant")
    public void addPlant(Integer ownerId, Integer categoryId, String plantName)
    {
        PlantInfo plantInfo = new PlantInfo();
        plantInfo.setOwnerId(ownerId);
        plantInfo.setCategoryId(categoryId);
        plantInfo.setState(111);
        plantInfo.setPlantName(plantName);
        plantInfoService.insertInfo(plantInfo);
    }

    @RequestMapping("/bindDevice")
    public void bindDevice(Integer plantId, Integer deviceId)
    {
        PlantInfo plantInfo = new PlantInfo();
        DeviceInfo deviceInfo = new DeviceInfo();
        plantInfo.setPlantId(plantId);
        plantInfo.setDeviceId(deviceId);
        deviceInfo.setPlantId(plantId);
        deviceInfo.setDeviceId(deviceId);
        plantInfoService.updateInfo(plantInfo);
        deviceInfoService.updateInfo(deviceInfo);
    }

    @RequestMapping("/addName")
    public void addName(Integer plantId, String plantName)
    {
        PlantInfo plantInfo = new PlantInfo();
        plantInfo.setPlantId(plantId);
        plantInfo.setPlantName(plantName);
        plantInfoService.updateInfo(plantInfo);
    }

//    @RequestMapping("/updateState")
//    public void updateState(int deviceId, int devicePsw, float temperature, float humidity, float illuminance)
//    {
//        ArrayList<DeviceInfo> deviceInfo = deviceInfoService.getById(deviceId);
//        DeviceInfo device;
//        if(deviceInfo == null)
//            return;
//        else
//            device = deviceInfo.get(0);
//        if(device.getDevicePsw() != devicePsw)
//            return;
//
//        int plantId = device.getPlantId();
//
//        ArrayList<PlantInfo> plantInfo = plantInfoService.getById(plantId);
//        PlantInfo plant;
//        if(plantInfo == null)
//            return;
//        else
//            plant = plantInfo.get(0);
//
//        plant.setPlantId(plantId);
//        plant.setTemperature(temperature);
//        plant.setHumidity(humidity);
//        plant.setIlluminance(illuminance);
//        plant.setUpdateTime(new Date());
//
//        plantInfoService.updateInfo(plant);
//    }

    @RequestMapping("/deletePlant")
    public void deletePlant(Integer plantId)
    {
        plantInfoService.deleteInfo(plantId);
    }

    @PostMapping("/updateInfo")
    public void updateInfo(@RequestBody PlantUpdateInfo plantUpdateInfo)
    {
        DeviceInfo device = deviceInfoService.getById(Integer.parseInt(plantUpdateInfo.getDeviceId()));
        if(device == null)
            return;

        PlantInfo plantInfo = plantInfoService.getById(device.getPlantId());
        if(plantInfo == null)
            return;

        CategoryInfo categoryInfo = categoryInfoService.getById(plantInfo.getCategoryId());

        float temp = Float.parseFloat(plantUpdateInfo.getTemperature());
        float humi = Float.parseFloat(plantUpdateInfo.getHumidity());
        float illumi = Float.parseFloat(plantUpdateInfo.getIlluminance());
        /*以下各flag表示温度、湿度、光照强度是否处于适宜范围内
        * 值为1：适宜
        *     0：低于下界
        *     2：高于上界
        */
        int flagT = 1;
        int flagH = 1;
        int flagI = 1;
        if(temp < categoryInfo.getTempLowBound())
            flagT = 0;
        else if(temp > categoryInfo.getTempHighBound())
            flagT = 2;

        if(humi < categoryInfo.getHumiLowBound())
            flagH = 0;
        else if(humi > categoryInfo.getHumiHighBound())
            flagH = 2;

        if(illumi < categoryInfo.getIllumLowBound())
            flagI = 0;
        else if(illumi > categoryInfo.getIllumHighBound())
            flagI = 2;
        plantInfo.setTemperature(temp);
        plantInfo.setHumidity(humi);
        plantInfo.setIlluminance(illumi);
        plantInfo.setUpdateTime(new Date());
        /*flagT == state%10
        * flagH == state/10%10
        * flagI == state/100*/
        plantInfo.setState(100*flagI + 10*flagH + flagT);

        plantInfoService.updateInfo(plantInfo);
    }

}
