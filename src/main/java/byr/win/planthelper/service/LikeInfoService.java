package byr.win.planthelper.service;

import byr.win.planthelper.domain.LikeInfo;

public interface LikeInfoService {
    void insertInfo(LikeInfo likeInfo);

    Boolean getIfLiked(Integer newsId, Integer userId);

    void cancelLike(Integer newsId, Integer userId);
}
