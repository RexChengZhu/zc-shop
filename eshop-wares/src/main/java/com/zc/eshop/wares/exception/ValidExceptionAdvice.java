package com.zc.eshop.wares.exception;

import com.zc.eshop.common.exception.BizCodeException;
import com.zc.eshop.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice(basePackages = "com.zc.eshop.wares.controller")
public class ValidExceptionAdvice {

    /**
     * 校验参数验证异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e){

        log.error("数据校验出错{},异常类型{}",e.getMessage(),e.getClass());
        Map<String, String> collect =
                e.getBindingResult().getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, DefaultMessageSourceResolvable::getDefaultMessage));
        return R.error(BizCodeException.VALID_EXCEPTION,collect);
    }


    /**
     * 包裹全部异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public R handleException(Exception e){


        return R.error(BizCodeException.VALID_EXCEPTION,e.getMessage());
    }

}
