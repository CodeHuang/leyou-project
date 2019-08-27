package com.leyou.item.service;

import com.leyou.common.enums.ExceptionEunm;
import com.leyou.common.exception.LyException;
import com.leyou.item.mapper.SpecGroupMapper;
import com.leyou.item.mapper.SpecParamMapper;
import com.leyou.item.pojo.SpecParam;
import com.leyou.item.pojo.Specification;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    private SpecParamMapper specParamMapper;

    public Specification queryGroupByCid(Long cid) {
        Specification specification = groupMapper.selectByPrimaryKey(cid);
        if(specification==null){
            throw new LyException(ExceptionEunm.SPEC_GROUP_NOT_FOND);
        }
        return specification;
    }

    public List<SpecParam> querySpecParams(Long gid, Long cid, Boolean searching, Boolean generic) {
        SpecParam specParam = new SpecParam();
        specParam.setGroupId(gid);
        specParam.setCid(cid);
        specParam.setSearching(searching);
        specParam.setGeneric(generic);
        List<SpecParam> specParamList = specParamMapper.select(specParam);
        if (CollectionUtils.isEmpty(specParamList)) {
            throw new LyException(ExceptionEunm.SPEC_GROUP_NOT_FOND);
        }
        return specParamList;
    }
}
