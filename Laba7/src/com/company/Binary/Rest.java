package com.company.Binary;

import com.company.IExpression;
import com.company.Tools.CacheCalculation;

public class Rest extends BinaryExpression implements IExpression {
    public Rest(Object left, Object right) {

        super(left,right);

        this.cache = new CacheCalculation(() -> {
            double divider= this.getLeft().calculate();
            double dividend= this.getRight().calculate();
            if (dividend!=0){
                if(divider<0 && dividend>0) {
                    double rounding = Math.floor(divider / dividend);
                    return divider - (rounding * dividend);
                }
                if(divider<0 && dividend<0){
                    double rounding = Math.round(a /dividend);
                    return divider - (rounding * dividend);
                }
                return divider % dividend;
            }
            return Double.NaN;
        });
    }
}
