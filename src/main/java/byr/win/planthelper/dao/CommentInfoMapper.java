package byr.win.planthelper.dao;

import byr.win.planthelper.domain.CommentInfo;
import org.springframework.stereotype.Component;

import javax.xml.stream.events.Comment;
import java.util.ArrayList;

@Component
public interface CommentInfoMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(CommentInfo record);

    int insertSelective(CommentInfo record);

    CommentInfo selectByPrimaryKey(Integer commentId);

    ArrayList<CommentInfo> selectByNewsId(Integer newsId);

    int updateByPrimaryKeySelective(CommentInfo record);

    int updateByPrimaryKey(CommentInfo record);
}