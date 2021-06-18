package byr.win.planthelper.service;

import byr.win.planthelper.domain.CategoryInfo;

import java.util.ArrayList;

public interface CategoryInfoService
{
    CategoryInfo getById(Integer id);

    ArrayList<CategoryInfo> getAll();

    ArrayList<CategoryInfo> getByGender(Boolean gender);

    ArrayList<CategoryInfo> getByDiffy(Integer diffy);

    ArrayList<CategoryInfo> getByName(String categoryName);

    ArrayList<CategoryInfo> getBySeason(Integer season);
}
