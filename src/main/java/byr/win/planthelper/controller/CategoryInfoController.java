package byr.win.planthelper.controller;

import byr.win.planthelper.domain.CategoryInfo;
import byr.win.planthelper.service.CategoryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/category")
public class CategoryInfoController
{
    @Autowired
    private CategoryInfoService categoryInfoService;

    @RequestMapping("/getCategory")
    public CategoryInfo getCategory(Integer categoryId)
    {
        return categoryInfoService.getById(categoryId);
    }

    @RequestMapping("/getAllCategories")
    public ArrayList<CategoryInfo> getAllCategories()
    {
        return categoryInfoService.getAll();
    }

    @RequestMapping("/getByGender")
    public ArrayList<CategoryInfo> getByGender(Boolean gender)
    {
        return categoryInfoService.getByGender(gender);
    }

    @RequestMapping("/getByDiffy")
    public ArrayList<CategoryInfo> getByDiffy(Integer diffy)
    {
        return categoryInfoService.getByDiffy(diffy);
    }

    @RequestMapping("/getByName")
    public ArrayList<CategoryInfo> getByName(String categoryName)
    {
        return categoryInfoService.getByName(categoryName);
    }

    @RequestMapping("/getBySeason")
    public ArrayList<CategoryInfo> getBySeason(Integer season)
    {
        return categoryInfoService.getBySeason(season);
    }
}
