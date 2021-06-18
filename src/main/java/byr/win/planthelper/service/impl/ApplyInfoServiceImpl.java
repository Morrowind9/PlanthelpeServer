package byr.win.planthelper.service.impl;

import byr.win.planthelper.dao.ApplyInfoMapper;
import byr.win.planthelper.domain.ApplyInfo;
import byr.win.planthelper.service.ApplyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ApplyInfoServiceImpl implements ApplyInfoService
{
    @Autowired
    private ApplyInfoMapper applyInfoMapper;

    @Override
    public ArrayList<ApplyInfo> getByApplyId(Integer applyId)
    {
        ArrayList<ApplyInfo> res = applyInfoMapper.selectByPrimaryKey(applyId);

        if(res.size() == 0)
            return null;
        else
            return res;
    }

    @Override
    public ArrayList<ApplyInfo> getBySenderId(Integer userId)
    {
        ArrayList<ApplyInfo> res = applyInfoMapper.selectByUserId(userId);

        if(res.size() == 0)
            return null;
        else
            return res;
    }

    @Override
    public ArrayList<ApplyInfo> getByReceiverId(Integer friendId)
    {
        ArrayList<ApplyInfo> res = applyInfoMapper.selectByFriendId(friendId);

        if(res.size() == 0)
            return null;
        else
            return res;
    }

    @Override
    public ApplyInfo insertInfo(ApplyInfo applyInfo)
    {
        applyInfoMapper.insert(applyInfo);
        return applyInfo;
    }

    @Override
    public void updateInfo(ApplyInfo applyInfo)
    {
        applyInfoMapper.updateByPrimaryKeySelective(applyInfo);
    }

}
