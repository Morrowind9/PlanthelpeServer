package byr.win.planthelper.dao;

import byr.win.planthelper.domain.NewsInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface NewsInfoMapper {
    int deleteByPrimaryKey(Integer newsId);

    int insert(NewsInfo record);

    int insertSelective(NewsInfo record);

    ArrayList<NewsInfo> selectByPrimaryKey(Integer newsId);

    ArrayList<NewsInfo> selectByUserId(Integer userId);

    int updateByPrimaryKeySelective(NewsInfo record);

    int updateByPrimaryKey(NewsInfo record);
}