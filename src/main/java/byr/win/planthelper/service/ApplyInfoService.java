package byr.win.planthelper.service;

import byr.win.planthelper.domain.ApplyInfo;

import java.util.ArrayList;

public interface ApplyInfoService
{
    ArrayList<ApplyInfo> getByApplyId(Integer applyId);

    ArrayList<ApplyInfo> getBySenderId(Integer userId);

    ArrayList<ApplyInfo> getByReceiverId(Integer friendId);

    void updateInfo(ApplyInfo applyInfo);

    ApplyInfo insertInfo(ApplyInfo applyInfo);
}
