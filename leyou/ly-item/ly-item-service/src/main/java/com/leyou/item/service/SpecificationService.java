package com.leyou.item.service;

import com.leyou.common.enums.ExceptionEunm;
import com.leyou.common.exception.LyException;
import com.leyou.item.mapper.SpecGroupMapper;
import com.leyou.item.pojo.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author coderHuang
 * @date 2019/8/22 15:51
 * @github https://github.com/CodeHuang
 */
@Service
public class SpecificationService {
    @Autowired
    private SpecGroupMapper groupMapper;
    public List<Specification> queryGroupByCid(Long cid) {
        //查询条件
        Specification specification = new Specification();
        specification.setCategoryId(cid);
        List<Specification> list = groupMapper.select(specification);
        if(CollectionUtils.isEmpty(list)){
            throw new LyException(ExceptionEunm.SPEC_GROUP_NOT_FOND);
        }
        return list;
    }
}
