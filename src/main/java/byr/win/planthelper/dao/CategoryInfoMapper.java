package byr.win.planthelper.dao;

import byr.win.planthelper.domain.CategoryInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface CategoryInfoMapper {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(CategoryInfo record);

    int insertSelective(CategoryInfo record);

    ArrayList<CategoryInfo> selectByPrimaryKey(Integer categoryId);

    ArrayList<CategoryInfo> selectAll();

    ArrayList<CategoryInfo> selectForM();

    ArrayList<CategoryInfo> selectForF();

    ArrayList<CategoryInfo> selectByDiffy(Integer diffy);

    ArrayList<CategoryInfo> selectByName(String categoryName);

    ArrayList<CategoryInfo> selectBySeason(Integer season);

    int updateByPrimaryKeySelective(CategoryInfo record);

    int updateByPrimaryKey(CategoryInfo record);
}