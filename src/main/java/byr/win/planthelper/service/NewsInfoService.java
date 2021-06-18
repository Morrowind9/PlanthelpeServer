package byr.win.planthelper.service;

import byr.win.planthelper.domain.NewsInfo;

import java.util.ArrayList;

public interface NewsInfoService
{
    NewsInfo getByNewsId(Integer newsId);

    ArrayList<NewsInfo> getByUserId(Integer userId);

    void insertInfo(NewsInfo newsInfo);

    void updateInfo(NewsInfo newsInfo);
}
