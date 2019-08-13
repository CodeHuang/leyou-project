package com.leyou.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 异常提示信息枚举
 * @author coderHuang
 * @date 2019/8/7 10:25
 * @github https://github.com/CodeHuang
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEunm {
    PRICE_CANNOT_BE_NULL(400,"价格不能为空"),
    CATEGORY_NOTE_FOND(404,"商品分类没查到"),
    BRAND_NOT_FOUND(400,"品牌不存在，或者输入有误，请尝试重新输入"),
    ADD_BRAND_ERROR(500,"新增品牌失败"),
    CATEGORY_NOTE_SAVE_ERROR(500,"新增品牌分类中间表失败"),
    UPLOAD_FILE_ERROR(500,"上传文件失败"),
    ;
    private int code;
    private String msg;

}
