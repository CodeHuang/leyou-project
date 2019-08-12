package com.leyou.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.enums.ExceptionEunm;
import com.leyou.common.exception.LyException;
import com.leyou.common.vo.PageResult;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author coderHuang
 * @date 2019/8/12 11:40
 * @github https://github.com/CodeHuang
 */
@Service
public class BrandService {
    @Autowired
    private BrandMapper brandMapper;

    public PageResult<Brand> queryBrandByPage(Integer page, Integer rows, String sortBy, Boolean desc, String key) {
        //分页
        PageHelper.startPage(page, rows);
        //过滤
        Example example = new Example(Brand.class);
        if (StringUtils.isNotBlank(key)) {
            //过滤条件
            example.createCriteria().orLike("name", "%" + key + "%")
                    .orEqualTo("letter", key.toUpperCase());
        }
        //排序
        if(StringUtils.isNotBlank(sortBy)){
            String sortByClause = sortBy + (desc ? " DESC" : " ASC");
            example.setOrderByClause(sortByClause);
        }
        //查询
        List<Brand> brands = brandMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(brands)){
            throw new LyException(ExceptionEunm.BRAND_NOT_FOUND);
        }
        PageInfo<Brand> brandPageInfo = new PageInfo<>(brands);
        return new PageResult(brandPageInfo.getTotal(),brands);
    }
    @Transactional
    public void saveBrand(Brand brand, List<Long> cids) {
        //新增品牌
        brand.setId(null);
        int count = brandMapper.insert(brand);
        if(count!=1){
            throw new LyException(ExceptionEunm.ADD_BRAND_ERROR);
        }

        //新增中间表
        for (Long cid : cids){
            count = brandMapper.insertCategoryBrand(cid, brand.getId());
            if(count!=1){
                throw new LyException(ExceptionEunm.CATEGORY_NOTE_SAVE_ERROR);
            }
        }
    }
}
