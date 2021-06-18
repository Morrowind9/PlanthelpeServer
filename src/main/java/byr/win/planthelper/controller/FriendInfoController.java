package byr.win.planthelper.controller;

import byr.win.planthelper.domain.ApplyInfo;
import byr.win.planthelper.domain.FriendInfo;
import byr.win.planthelper.service.ApplyInfoService;
import byr.win.planthelper.service.FriendInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/friend")
public class FriendInfoController
{
    @Autowired
    private FriendInfoService friendInfoService;

    @Autowired
    private ApplyInfoService applyInfoService;

    @RequestMapping("/newApply")
    public ApplyInfo addApply(Integer userId, Integer friendId, String additionInfo)
    {
        //若已经是好友则不再发出好友申请
        if(!friendInfoService.getIfFriends(userId, friendId))
        {
            ApplyInfo applyInfo = new ApplyInfo();
            applyInfo.setUserId(userId);
            applyInfo.setFriendId(friendId);
            applyInfo.setAdditionInfo(additionInfo);
            applyInfo.setState(false);
            applyInfo.setApplyTime(new Date());
            applyInfoService.insertInfo(applyInfo);
            return applyInfo;
        }
        return null;
    }

    @RequestMapping("/getApplyBySender")
    public ArrayList<ApplyInfo> getApplyBySender(Integer userId)
    {
        ArrayList<ApplyInfo> res = applyInfoService.getBySenderId(userId);
        return res;
    }

    @RequestMapping("/getApplyByReceiver")
    public ArrayList<ApplyInfo> getApplyByReceiver(Integer friendId)
    {
        ArrayList<ApplyInfo> res = applyInfoService.getByReceiverId(friendId);
        return res;
    }

    @RequestMapping("/newFriend")
    public void newFriend(Integer applyId)
    {
        ArrayList<ApplyInfo> res = applyInfoService.getByApplyId(applyId);
        if(res == null)
            return;
        ApplyInfo applyInfo = res.get(0);
        applyInfo.setState(true);
        applyInfoService.updateInfo(applyInfo);

        FriendInfo friendInfo1 = new FriendInfo();
        friendInfo1.setUserId(applyInfo.getUserId());
        friendInfo1.setFriendId(applyInfo.getFriendId());

        FriendInfo friendInfo2 = new FriendInfo();
        friendInfo2.setUserId(applyInfo.getFriendId());
        friendInfo2.setFriendId(applyInfo.getUserId());

        friendInfoService.insertInfo(friendInfo1);
        friendInfoService.insertInfo(friendInfo2);
    }

    @RequestMapping("/getFriendList")
    public ArrayList<FriendInfo> getFriendList(Integer userId)
    {
        ArrayList<FriendInfo> res = friendInfoService.getAllFriends(userId);
        return res;
    }

}
