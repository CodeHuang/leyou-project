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
    ;
    private int code;
    private String msg;
}
