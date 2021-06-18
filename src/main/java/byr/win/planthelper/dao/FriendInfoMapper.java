package byr.win.planthelper.dao;

import byr.win.planthelper.domain.FriendInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface FriendInfoMapper {
    int deleteByPrimaryKey(@Param("userId") Integer userId, @Param("friendId") Integer friendId);

    int insert(FriendInfo record);

    int insertSelective(FriendInfo record);

    FriendInfo selectByPrimaryKey(@Param("userId") Integer userId, @Param("friendId") Integer friendId);

    ArrayList<FriendInfo> selectByUserId(int userId);

    ArrayList<FriendInfo> selectByUserIdAndFriendId(int userId, int friendId);

    int updateByPrimaryKeySelective(FriendInfo record);

    int updateByPrimaryKey(FriendInfo record);
}