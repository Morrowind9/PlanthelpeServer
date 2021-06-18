package byr.win.planthelper.service;

import byr.win.planthelper.domain.CommentInfo;

import java.util.ArrayList;

public interface CommentInfoService
{
    ArrayList<CommentInfo> getByNewsId(Integer newsId);

    CommentInfo insertInfo(CommentInfo commentInfo);
}
