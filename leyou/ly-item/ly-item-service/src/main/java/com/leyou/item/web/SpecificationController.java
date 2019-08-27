package com.leyou.item.web;

import com.leyou.item.pojo.SpecParam;
import com.leyou.item.pojo.Specification;
import com.leyou.item.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author coderHuang
 * @date 2019/8/22 15:52
 * @github https://github.com/CodeHuang
 */
@RequestMapping("spec")
@RestController
public class SpecificationController {
    @Autowired
    private SpecificationService specificationService;

    /**
     * 根据分类id查询规格组
     * @param cid
     * @return
     */
    @GetMapping("{cid}")
    @ResponseBody
    public ResponseEntity<String> queryGroupByCid(@PathVariable("cid") Long cid){
        Specification spec =specificationService.queryGroupByCid(cid);
        if (spec == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(spec.getSpecifications());
    }

    /**
     * 查询商品规格参数
     *
     * @param gid       规格组ID
     * @param cid       商品分类ID
     * @param searching 是否是搜索字段
     * @param generic   是否是通用字段
     * @return
     */
    @GetMapping("params")
    public ResponseEntity<List<SpecParam>> querySpecParams(
            @RequestParam(value = "gid", required = false) Long gid,
            @RequestParam(value = "cid", required = false) Long cid,
            @RequestParam(value = "searching", required = false) Boolean searching,
            @RequestParam(value = "generic", required = false) Boolean generic
    ) {
        return ResponseEntity.ok(specificationService.querySpecParams(gid, cid, searching, generic));
    }
}
