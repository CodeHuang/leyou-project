package com.leyou.common.vo;

import com.leyou.common.enums.ExceptionEunm;
import lombok.Data;

/**
 * @author coderHuang
 * @date 2019/8/7 10:44
 * @github https://github.com/CodeHuang
 */
@Data
public class ExceptionResule {
    private int status;
    private String message;
    private Long timestamp;

    public ExceptionResule(ExceptionEunm em) {
        this.status = em.getCode();
        this.message = em.getMsg();
        this.timestamp=System.currentTimeMillis();
    }
}
