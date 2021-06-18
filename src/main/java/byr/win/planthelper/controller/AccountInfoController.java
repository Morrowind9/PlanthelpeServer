package byr.win.planthelper.controller;

import byr.win.planthelper.domain.AccountInfo;
import byr.win.planthelper.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/account")
public class AccountInfoController
{
    @Autowired
    private AccountInfoService accountInfoService;

    @RequestMapping("/login")
    public AccountInfo login(Integer userId, String userPsw)
    {
        AccountInfo res = accountInfoService.getById(userId);
        if(res == null)
            return null;
        else
        {
            //密码错误或已登录
            if(!userPsw.equals(res.getUserPsw()) || res.getLogin())
                return null;
            else{
                res.setLogin(true);
                accountInfoService.updateInfo(res);
                return res;
            }
        }
    }

    @RequestMapping("/register")
    public AccountInfo register(String userName, String userPsw, Integer diffy, Boolean gender, Integer locationId)
    {
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setUserName(userName);
        accountInfo.setUserPsw(userPsw);
        accountInfo.setHighestDiffy(diffy);
        accountInfo.setGender(gender);
        accountInfo.setLocationId(locationId);
        accountInfo.setLogin(false);
        return accountInfoService.insertInfo(accountInfo);
    }

    @RequestMapping ("/editInfo")
    public AccountInfo editInfo(@RequestParam(value = "userId") Integer userId, @RequestParam(value = "newDiffy", required = false) Integer newDiffy, @RequestParam(value = "newLocation", required = false) Integer newLocation)
    {
        AccountInfo res = accountInfoService.getById(userId);
        if(res == null)
            return null;
        if(newDiffy != null)
            res.setHighestDiffy(newDiffy);
        if(newLocation != null)
            res.setLocationId(newLocation);
        accountInfoService.updateInfo(res);
        return res;
    }

    @RequestMapping("/getInfo")
    public AccountInfo getInfo(Integer userId)
    {
        AccountInfo res = accountInfoService.getById(userId);
        res.setUserPsw(null);
        return res;
    }

    @RequestMapping("/logout")
    public void logout(Integer userId, String userPsw)
    {
        AccountInfo res = accountInfoService.getById(userId);
        if(res != null)
        {
            //密码正确且已登录
            if(userPsw.equals(res.getUserPsw()) && res.getLogin())
            {
                res.setLogin(false);
                accountInfoService.updateInfo(res);
            }
        }
    }
}
