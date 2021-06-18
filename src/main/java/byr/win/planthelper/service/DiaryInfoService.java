package byr.win.planthelper.service;

import byr.win.planthelper.domain.DiaryInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface DiaryInfoService
{
    ArrayList<DiaryInfo> getByUserId(Integer userId);

    void insertInfo(DiaryInfo diaryInfo);
}
