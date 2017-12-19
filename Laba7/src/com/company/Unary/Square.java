package com.company.Unary;

import com.company.IExpression;
import com.company.Tools.CacheCalculation;

public class Square extends UnaryExpression implements IExpression {

    public Square(Object value) {
        super(value);

        CacheCalculation cacheValue = new CacheCalculation(() -> Math.pow(this.value.calculate(), 2.0));
    }

}
