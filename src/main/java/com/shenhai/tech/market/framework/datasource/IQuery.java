package com.shenhai.tech.market.framework.datasource;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

public class IQuery<T> extends LambdaQueryWrapper<T> {

    public static <T> IQuery<T> of() {
        return new IQuery<>();
    }



    private boolean checkNullOrBlack(Object val) {
        return val == null || (val instanceof String && StringUtils.isBlank((String) val));
    }


    @Override
    public LambdaQueryWrapper<T> eq(SFunction<T, ?> column, Object val) {
        if (checkNullOrBlack(val)) {
            return this;
        }
        return super.eq(column, val);
    }

    @Override
    public LambdaQueryWrapper<T> like(SFunction<T, ?> column, Object val) {
        if (checkNullOrBlack(val)) {
            return this;
        }
        return super.like(column, val);
    }

    @Override
    public LambdaQueryWrapper<T> in(SFunction<T, ?> column, Object... values) {
        if (values == null) {
            return this;
        }
        return super.in(column, values);
    }

    @Override
    public LambdaQueryWrapper<T> in(SFunction<T, ?> column, Collection<?> coll) {
        if (CollectionUtils.isEmpty(coll)) {
            return this;
        }
        return super.in(column, coll);
    }

    @Override
    public LambdaQueryWrapper<T> gt(SFunction<T, ?> column, Object val) {
        if (checkNullOrBlack(val)) {
            return this;
        }
        return super.gt(column, val);
    }

    @Override
    public LambdaQueryWrapper<T> ge(SFunction<T, ?> column, Object val) {
        if (checkNullOrBlack(val)) {
            return this;
        }
        return super.ge(column, val);
    }

    @Override
    public LambdaQueryWrapper<T> lt(SFunction<T, ?> column, Object val) {
        if (checkNullOrBlack(val)) {
            return this;
        }
        return super.lt(column, val);
    }

    @Override
    public LambdaQueryWrapper<T> le(SFunction<T, ?> column, Object val) {
        if (checkNullOrBlack(val)) {
            return this;
        }
        return super.le(column, val);
    }
}
