package byr.win.planthelper.dao;

import byr.win.planthelper.domain.LikeInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface LikeInfoMapper {
    int deleteByPrimaryKey(@Param("newsId") Integer newsId, @Param("userId") Integer userId);

    ArrayList<LikeInfo> selectByNewsIdAndUserId(Integer newsId, Integer userId);

    int insert(LikeInfo record);

    int insertSelective(LikeInfo record);
}