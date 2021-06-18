package byr.win.planthelper.dao;

import byr.win.planthelper.domain.DiaryInfo;

import java.util.ArrayList;

public interface DiaryInfoMapper {
    int deleteByPrimaryKey(Integer diaryId);

    int insert(DiaryInfo record);

    int insertSelective(DiaryInfo record);

    ArrayList<DiaryInfo> selectByPrimaryKey(Integer diaryId);

    ArrayList<DiaryInfo> selectByUserId(Integer userId);

    int updateByPrimaryKeySelective(DiaryInfo record);

    int updateByPrimaryKey(DiaryInfo record);
}