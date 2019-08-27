package com.leyou.item.pojo;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Table(name = "tb_spu")
@Data
public class Spu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long brandId;
    private Long cid1;// 1级类目
    private Long cid2;// 2级类目
    private Long cid3;// 3级类目
    private String title;// 标题
    private String subTitle;// 子标题
    private Boolean saleable;// 是否上架
    private Boolean valid;// 是否有效，逻辑删除用
    private Date createTime;// 创建时间
    private Date lastUpdateTime;


    //spu所属的分类名称
    @Transient
    private String cname;

    //spu所属品牌名
    @Transient
    private String bname;

    //spu详情
    @Transient
    private SpuDetail spuDetail;
}