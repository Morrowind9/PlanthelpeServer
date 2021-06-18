package byr.win.planthelper.beans;

import lombok.Data;

@Data
public class PlantUpdateInfo
{
    private String deviceId;

    private String temperature;

    private String humidity;

    private String illuminance;
}
