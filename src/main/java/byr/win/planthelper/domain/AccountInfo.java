package byr.win.planthelper.domain;

public class AccountInfo {
    private Integer userId;

    private String userName;

    private String userPsw;

    private Integer locationId;

    private Integer highestDiffy;

    private Boolean gender;

    private Boolean login;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPsw() {
        return userPsw;
    }

    public void setUserPsw(String userPsw) {
        this.userPsw = userPsw == null ? null : userPsw.trim();
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getHighestDiffy() {
        return highestDiffy;
    }

    public void setHighestDiffy(Integer highestDiffy) {
        this.highestDiffy = highestDiffy;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Boolean getLogin() {
        return login;
    }

    public void setLogin(Boolean login) {
        this.login = login;
    }
}