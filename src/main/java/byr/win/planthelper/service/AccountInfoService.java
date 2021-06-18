package byr.win.planthelper.service;

import byr.win.planthelper.domain.AccountInfo;

import java.util.ArrayList;

public interface AccountInfoService
{
    AccountInfo getById(Integer id);
    AccountInfo insertInfo(AccountInfo accountInfo);
    void updateInfo(AccountInfo accountInfo);
}
