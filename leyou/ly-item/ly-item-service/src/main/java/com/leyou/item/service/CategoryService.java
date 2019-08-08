package com.leyou.item.service;

import com.leyou.common.enums.ExceptionEunm;
import com.leyou.common.exception.LyException;
import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author coderHuang
 * @date 2019/8/8 11:41
 * @github https://github.com/CodeHuang
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> queryCategoryListByPid(Long pid) {
        //查询条件，Mapper会把对象中的非空条件作为查询条件
        Category category = new Category();
        category.setParentId(pid);
        List<Category> categoryList = categoryMapper.select(category);
        //判断查询结果
        if(CollectionUtils.isEmpty(categoryList)){
            throw new LyException(ExceptionEunm.CATEGORY_NOTE_FOND);
        }
        return categoryList;
    }
}
