package byr.win.planthelper.service.impl;

import byr.win.planthelper.dao.LikeInfoMapper;
import byr.win.planthelper.domain.LikeInfo;
import byr.win.planthelper.service.LikeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LikeInfoServiceImpl implements LikeInfoService {
    @Autowired
    private LikeInfoMapper likeInfoMapper;

    @Override
    public void insertInfo(LikeInfo likeInfo){
        likeInfoMapper.insert(likeInfo);
    }

    @Override
    public Boolean getIfLiked(Integer newsId, Integer userId) {
        ArrayList<LikeInfo> res = likeInfoMapper.selectByNewsIdAndUserId(newsId, userId);
        return res.size() != 0;
    }

    @Override
    public void cancelLike(Integer newsId, Integer userId){
        likeInfoMapper.deleteByPrimaryKey(newsId, userId);
    }
}
