package byr.win.planthelper.service;

import byr.win.planthelper.domain.FriendInfo;

import java.util.ArrayList;

public interface FriendInfoService
{
    public ArrayList<FriendInfo> getAllFriends(Integer userId);

    public void insertInfo(FriendInfo friendInfo);

    public Boolean getIfFriends(Integer userId, Integer friendId);
}
