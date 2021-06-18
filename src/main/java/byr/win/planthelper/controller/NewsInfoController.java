package byr.win.planthelper.controller;

import byr.win.planthelper.beans.DetailedNewsInfo;
import byr.win.planthelper.domain.LikeInfo;
import byr.win.planthelper.domain.NewsInfo;
import byr.win.planthelper.service.LikeInfoService;
import byr.win.planthelper.service.NewsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/news")
public class NewsInfoController
{
    @Autowired
    private NewsInfoService newsInfoService;

    @Autowired
    private LikeInfoService likeInfoService;

    @RequestMapping("/getByUser")
    public ArrayList<NewsInfo> getByUser(Integer userId)//此处userId为发布者id
    {
        ArrayList<NewsInfo> res = newsInfoService.getByUserId(userId);
        return res;
    }

    @RequestMapping("/getByNewsId")
    public DetailedNewsInfo getByNewsId(Integer newsId, Integer userId)//此处userId为查询者id
    {
        NewsInfo res = newsInfoService.getByNewsId(newsId);
        DetailedNewsInfo detailedNewsInfo = new DetailedNewsInfo();
        detailedNewsInfo.setNewsId(res.getNewsId());
        detailedNewsInfo.setContent(res.getContent());
        detailedNewsInfo.setLikedNum(res.getLikedNum());
        detailedNewsInfo.setUserId(res.getUserId());
        detailedNewsInfo.setReleaseTime(res.getReleaseTime());
        detailedNewsInfo.setIfLikedByU(likeInfoService.getIfLiked(newsId, userId));
        return detailedNewsInfo;
    }

    @RequestMapping("/releaseNews")
    public void releaseNews(Integer userId, String content)
    {
        NewsInfo newsInfo = new NewsInfo();
        newsInfo.setUserId(userId);
        newsInfo.setContent(content);
        newsInfo.setLikedNum(0);
        newsInfo.setReleaseTime(new Date());
        newsInfoService.insertInfo(newsInfo);
    }

    @RequestMapping("/likeNews")
    public LikeInfo likeNews(Integer newsId, Integer userId)//此处userId为点赞者id
    {
        if(likeInfoService.getIfLiked(newsId, userId))
            return null;

        NewsInfo newsInfo = newsInfoService.getByNewsId(newsId);
        if(newsInfo == null)
            return null;
        int num = newsInfo.getLikedNum() + 1;
        newsInfo.setLikedNum(num);

        LikeInfo likeInfo = new LikeInfo();
        likeInfo.setNewsId(newsId);
        likeInfo.setUserId(userId);

        newsInfoService.updateInfo(newsInfo);
        likeInfoService.insertInfo(likeInfo);
        return likeInfo;
    }

    @RequestMapping("/cancelLike")
    public void cancelLike(Integer newsId, Integer userId)
    {
        NewsInfo newsInfo = newsInfoService.getByNewsId(newsId);
        if(newsInfo == null)
            return;

        int num = newsInfo.getLikedNum() + 1;
        newsInfo.setLikedNum(num);

        newsInfoService.updateInfo(newsInfo);
        likeInfoService.cancelLike(newsId, userId);
    }
}
