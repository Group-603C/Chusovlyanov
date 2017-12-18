package com.company.Binary;

import com.company.IExpression;
import com.company.Tools.CacheCalculation;

public class Rest extends BinaryExpression implements IExpression {
    public Rest(Object left, Object right) {

        super(left,right);

        this.cache = new CacheCalculation(() -> {
            double a= this.getLeft().calculate();
            double b= this.getRight().calculate();
            if (b!=0){
                if(a<0&&b>0) {
                    double partialPrivate = Math.floor(a / b);
                    return a - (partialPrivate * b);
                }
                if(a<0&&b<0){
                    double partialPrivate = Math.round(a /b);
                    return a - (partialPrivate * b);
                }
                return a%b;
            }
            return Double.NaN;
        });
    }
}
