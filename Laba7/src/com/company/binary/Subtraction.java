package com.company.Binary;

import com.company.IExpression;
import com.company.Tools.CacheCalculation;

public class Subtraction extends BinaryExpression implements IExpression {

    public Subtraction(Object left, Object right) {
        super(left, right);

        this.cache = new CacheCalculation(() -> {
            return this.getLeft().calculate() - this.getRight().calculate();
        });
    }
}
