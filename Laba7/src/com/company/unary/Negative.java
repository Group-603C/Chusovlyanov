package com.company.Unary;

import com.company.IExpression;
import com.company.Tools.CacheCalculation;

public class Negative extends UnaryExpression implements IExpression {

    public Negative(Object value) {
        super(value);

        CacheCalculation cacheValue = new CacheCalculation(() -> -this.value.calculate());
    }
}
