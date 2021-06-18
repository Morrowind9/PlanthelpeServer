package byr.win.planthelper.dao;

import byr.win.planthelper.domain.AccountInfo;
import byr.win.planthelper.domain.ApplyInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface ApplyInfoMapper {
    int deleteByPrimaryKey(Integer applyId);

    int insert(ApplyInfo record);

    int insertSelective(ApplyInfo record);

    ArrayList<ApplyInfo> selectByPrimaryKey(Integer applyId);

    ArrayList<ApplyInfo> selectByUserId(Integer userId);

    ArrayList<ApplyInfo> selectByFriendId(Integer friendId);

    int updateByPrimaryKeySelective(ApplyInfo record);

    int updateByPrimaryKey(ApplyInfo record);
}