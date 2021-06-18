package byr.win.planthelper.controller;

import byr.win.planthelper.domain.CommentInfo;
import byr.win.planthelper.service.CommentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.ArrayList;

@RestController
@RequestMapping("/comment")
public class CommentInfoController
{
    @Autowired
    private CommentInfoService commentInfoService;

    @RequestMapping("/showComments")
    public ArrayList<CommentInfo> getComments(Integer newsId)
    {
        return commentInfoService.getByNewsId(newsId);
    }

    @RequestMapping("/postComment")
    public CommentInfo postComment(Integer newsId, String content, Integer userId)
    {
        CommentInfo commentInfo = new CommentInfo();
        commentInfo.setNewsId(newsId);
        commentInfo.setContent(content);
        commentInfo.setUserId(userId);
        commentInfo.setCommentTime(new Date());
        commentInfoService.insertInfo(commentInfo);
        return commentInfo;
    }

}
