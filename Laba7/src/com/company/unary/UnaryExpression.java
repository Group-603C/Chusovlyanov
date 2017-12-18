package com.company.Unary;

import com.company.IExpression;
import com.company.Tools.CacheCalculation;
import com.company.Tools.CacheValue;

public class UnaryExpression implements IExpression {

    protected IExpression value;
    protected CacheCalculation cache;

    protected UnaryExpression(Object value) {
        this.value = new CacheValue(value);
        this.cache = null;
    }

    @Override
    public double calculate()
    {
        if (null == cache){
            return Double.NaN;
        }

        return cache.calculate();
    }
}
