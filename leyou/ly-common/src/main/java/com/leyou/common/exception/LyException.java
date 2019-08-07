package com.leyou.common.exception;

import com.leyou.common.enums.ExceptionEunm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 自定义异常类
 * @author coderHuang
 * @date 2019/8/6 13:20
 * @github https://github.com/CodeHuang
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LyException extends RuntimeException {
    private ExceptionEunm exceptionEunm;
}
