package byr.win.planthelper.domain;

public class DeviceInfo {
    private Integer deviceId;

    private Integer devicePsw;

    private Integer plantId;

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getDevicePsw() {
        return devicePsw;
    }

    public void setDevicePsw(Integer devicePsw) {
        this.devicePsw = devicePsw;
    }

    public Integer getPlantId() {
        return plantId;
    }

    public void setPlantId(Integer plantId) {
        this.plantId = plantId;
    }
}