package com.company.Unary;

import com.company.IExpression;
import com.company.Tools.CacheCalculation;

public class Absolute extends UnaryExpression implements IExpression {

    public Absolute(Object value) {
        super(value);

        CacheCalculation cacheValue = new CacheCalculation(() -> Math.abs(this.value.calculate()));
    }
}

