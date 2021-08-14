package com.zc.eshop.common.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.OptionalInt;

public class ListValueConstraintValidator  implements ConstraintValidator<ListValue,Integer> {

    private int[] arr;
    @Override
    public void initialize(ListValue constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);;
        arr = constraintAnnotation.values();
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        OptionalInt any = Arrays.stream(arr).filter(item -> item == integer).findAny();
        return any.isPresent();
    }
}
