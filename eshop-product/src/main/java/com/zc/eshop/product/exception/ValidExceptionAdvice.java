package com.zc.eshop.product.exception;

import com.zc.eshop.common.exception.BizCodeException;
import com.zc.eshop.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * 异常校验器
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.zc.eshop.product.controller")
public class ValidExceptionAdvice {

    /**
     * 校验参数验证异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result handleValidException(MethodArgumentNotValidException e){

        log.error("数据校验出错{},异常类型{}",e.getMessage(),e.getClass());
        Map<String, String> collect =
                e.getBindingResult().getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, DefaultMessageSourceResolvable::getDefaultMessage));
        return Result.error(BizCodeException.VALID_EXCEPTION,collect);
    }


    /**
     * 包裹全部异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Result handleException(Exception e){


        return Result.error(BizCodeException.UNKNOW_EXCEPTION,e.getMessage());
    }

}
