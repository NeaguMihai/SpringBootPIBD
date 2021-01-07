package com.neagumihai.proiectpibddata.decorators;

public class DoublePackage <S, T>{

    private T obj1;

    private S obj2;

    public DoublePackage(T obj1, S obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public DoublePackage() {
    }

    public T getObj1() {
        return obj1;
    }

    public void setObj1(T obj1) {
        this.obj1 = obj1;
    }

    public S getObj2() {
        return obj2;
    }

    public void setObj2(S obj2) {
        this.obj2 = obj2;
    }
}
