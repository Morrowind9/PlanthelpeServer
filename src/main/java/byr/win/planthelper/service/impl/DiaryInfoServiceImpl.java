package byr.win.planthelper.service.impl;

import byr.win.planthelper.dao.DiaryInfoMapper;
import byr.win.planthelper.domain.DiaryInfo;
import byr.win.planthelper.service.DiaryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DiaryInfoServiceImpl implements DiaryInfoService
{
    @Autowired
    private DiaryInfoMapper diaryInfoMapper;

    @Override
    public ArrayList<DiaryInfo> getByUserId(Integer userId)
    {
        ArrayList<DiaryInfo> res = diaryInfoMapper.selectByUserId(userId);

        if(res.size() == 0)
            return null;
        else
            return res;
    }

    @Override
    public void insertInfo(DiaryInfo diaryInfo)
    {
        diaryInfoMapper.insert(diaryInfo);
    }
}
