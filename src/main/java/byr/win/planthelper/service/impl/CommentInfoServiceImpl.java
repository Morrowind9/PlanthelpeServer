package byr.win.planthelper.service.impl;

import byr.win.planthelper.dao.CommentInfoMapper;
import byr.win.planthelper.domain.CommentInfo;
import byr.win.planthelper.service.CommentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CommentInfoServiceImpl implements CommentInfoService
{
    @Autowired
    private CommentInfoMapper commentInfoMapper;

    @Override
    public ArrayList<CommentInfo> getByNewsId(Integer newsId)
    {
        ArrayList<CommentInfo> res = commentInfoMapper.selectByNewsId(newsId);

        if(res.size() == 0)
            return null;
        else
            return res;
    }

    @Override
    public CommentInfo insertInfo(CommentInfo commentInfo)
    {
        commentInfoMapper.insert(commentInfo);
        return commentInfo;
    }
}
