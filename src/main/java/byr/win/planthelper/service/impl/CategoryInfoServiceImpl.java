package byr.win.planthelper.service.impl;

import byr.win.planthelper.dao.CategoryInfoMapper;
import byr.win.planthelper.domain.CategoryInfo;
import byr.win.planthelper.service.CategoryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryInfoServiceImpl implements CategoryInfoService
{
    @Autowired
    CategoryInfoMapper categoryInfoMapper;

    @Override
    public CategoryInfo getById(Integer id)
    {
        ArrayList<CategoryInfo> res = categoryInfoMapper.selectByPrimaryKey(id);
        if(res.size() == 0)
            return null;
        else
            return res.get(0);
    }

    @Override
    public ArrayList<CategoryInfo> getAll()
    {
        ArrayList<CategoryInfo> res = categoryInfoMapper.selectAll();
        if(res.size() == 0)
            return null;
        else
            return res;
    }

    @Override
    public ArrayList<CategoryInfo> getByGender(Boolean gender)
    {
        ArrayList<CategoryInfo> res;
        if(gender)
            res = categoryInfoMapper.selectForM();
        else
            res = categoryInfoMapper.selectForF();
        if(res.size() == 0)
            return null;
        else
            return res;
    }

    @Override
    public ArrayList<CategoryInfo> getByDiffy(Integer diffy)
    {
        ArrayList<CategoryInfo> res = categoryInfoMapper.selectByDiffy(diffy);
        if(res.size() == 0)
            return null;
        else
            return res;
    }

    @Override
    public ArrayList<CategoryInfo> getByName(String categoryName)
    {
        ArrayList<CategoryInfo> res = categoryInfoMapper.selectByName(categoryName);
        if(res.size() == 0)
            return null;
        else
            return res;
    }

    @Override
    public ArrayList<CategoryInfo> getBySeason(Integer season)
    {
        ArrayList<CategoryInfo> res = categoryInfoMapper.selectBySeason(season);
        if(res.size() == 0)
            return null;
        else
            return res;
    }
}
