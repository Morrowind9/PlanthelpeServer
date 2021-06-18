package byr.win.planthelper.dao;

import byr.win.planthelper.domain.AccountInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface AccountInfoMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(AccountInfo record);

    int insertSelective(AccountInfo record);

    ArrayList<AccountInfo> selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(AccountInfo record);

    int updateByPrimaryKey(AccountInfo record);
}