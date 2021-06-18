package byr.win.planthelper.beans;

import lombok.Data;

import java.util.Date;

@Data
public class DetailedNewsInfo {
    private Integer newsId;

    private Integer userId;

    private String content;

    private Integer likedNum;

    private Date releaseTime;

    private Boolean ifLikedByU;
}
