package byr.win.planthelper.service.impl;

import byr.win.planthelper.dao.AccountInfoMapper;
import byr.win.planthelper.domain.AccountInfo;
import byr.win.planthelper.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AccountInfoServiceImpl implements AccountInfoService
{
    @Autowired
    private AccountInfoMapper accountInfoMapper;

    @Override
    public AccountInfo getById(Integer id)
    {
        ArrayList<AccountInfo> res = accountInfoMapper.selectByPrimaryKey(id);
        if(res.size() == 0)
            return null;
        else
            return res.get(0);
    }

    @Override
    public AccountInfo insertInfo(AccountInfo accountInfo)
    {
        accountInfoMapper.insert(accountInfo);
        return accountInfo;
    }

    @Override
    public void updateInfo(AccountInfo accountInfo)
    {
        accountInfoMapper.updateByPrimaryKeySelective(accountInfo);
    }
}
