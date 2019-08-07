package com.leyou.common.advice;

import com.leyou.common.enums.ExceptionEunm;
import com.leyou.common.exception.LyException;
import com.leyou.common.vo.ExceptionResule;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {
    /**
     * @return 返回异常信息
     * @author coderHuang
     * @date 2019/8/7 10:25
     * @github https://github.com/CodeHuang
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResule> handleException(LyException e){
        ExceptionEunm exceptionEunm = e.getExceptionEunm();
        return ResponseEntity.status(exceptionEunm.getCode()).body(new ExceptionResule(e.getExceptionEunm()));
    }
}
