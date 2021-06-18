package byr.win.planthelper.service.impl;

import byr.win.planthelper.dao.FriendInfoMapper;
import byr.win.planthelper.domain.FriendInfo;
import byr.win.planthelper.service.FriendInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FriendInfoServiceImpl implements FriendInfoService
{
    @Autowired
    private FriendInfoMapper friendInfoMapper;

    @Override
    public ArrayList<FriendInfo> getAllFriends(Integer userId)
    {
        ArrayList<FriendInfo> res = friendInfoMapper.selectByUserId(userId);

        if(res.size() == 0)
            return null;
        else
            return res;
    }

    @Override
    public void insertInfo(FriendInfo friendInfo)
    {
        friendInfoMapper.insert(friendInfo);
    }

    @Override
    public Boolean getIfFriends(Integer userId, Integer friendId)
    {
        ArrayList<FriendInfo> res = friendInfoMapper.selectByUserIdAndFriendId(userId, friendId);
        return res.size() != 0;
    }
}
