package byr.win.planthelper.controller;

import byr.win.planthelper.domain.DiaryInfo;
import byr.win.planthelper.service.DiaryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.ArrayList;

@RestController
@RequestMapping("/diary")
public class DiaryInfoController
{
    @Autowired
    private DiaryInfoService diaryInfoService;

    @RequestMapping("/getByUser")
    public ArrayList<DiaryInfo> getByUser(Integer userId)
    {
        return diaryInfoService.getByUserId(userId);
    }

    @RequestMapping("/addDiary")
    public DiaryInfo addDiary(Integer userId, Integer opt, Integer plantId)
    {
        DiaryInfo diaryInfo = new DiaryInfo();
        diaryInfo.setUserId(userId);
        diaryInfo.setOpt(opt);
        diaryInfo.setPlantId(plantId);
        diaryInfo.setOptDate(new Date());
        diaryInfoService.insertInfo(diaryInfo);
        return diaryInfo;
    }
}
