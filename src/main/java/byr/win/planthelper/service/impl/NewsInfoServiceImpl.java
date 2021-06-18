package byr.win.planthelper.service.impl;

import byr.win.planthelper.dao.NewsInfoMapper;
import byr.win.planthelper.domain.NewsInfo;
import byr.win.planthelper.service.NewsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NewsInfoServiceImpl implements NewsInfoService
{
    @Autowired
    private NewsInfoMapper newsInfoMapper;

    @Override
    public NewsInfo getByNewsId(Integer newsId)
    {
        ArrayList<NewsInfo> res = newsInfoMapper.selectByPrimaryKey(newsId);

        if(res.size() == 0)
            return null;
        else
            return res.get(0);
    }

    @Override
    public ArrayList<NewsInfo> getByUserId(Integer userId)
    {
        ArrayList<NewsInfo> res = newsInfoMapper.selectByUserId(userId);

        if(res.size() == 0)
            return null;
        else
            return res;
    }

    @Override
    public void insertInfo(NewsInfo newsInfo)
    {
        newsInfoMapper.insert(newsInfo);
    }

    @Override
    public void updateInfo(NewsInfo newsInfo)
    {
        newsInfoMapper.updateByPrimaryKeySelective(newsInfo);
    }

}
