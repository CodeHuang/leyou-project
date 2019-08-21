package com.leyou.item.mapper;

import com.leyou.item.pojo.Category;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


/**
 * 商品类别Mapper
 * @author coderHuang
 * @date 2019/8/8 11:38
 * @github https://github.com/CodeHuang
 */
public interface CategoryMapper extends Mapper<Category> {
    /**
     * 根据品牌id查询商品分类
     * @param bid
     * @return
     */
    @Select("SELECT * FROM tb_category WHERE id IN (SELECT category_id FROM tb_category_brand WHERE brand_id = #{bid})")
    List<Category> queryByBrandId(Long bid);
}
