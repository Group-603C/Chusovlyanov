package com.company;

public interface IDeepCompare {

    <TObject> boolean deepEquals(TObject left, TObject right);
}
