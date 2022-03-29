package com.company.DataStructures;

import java.util.Arrays;

public class DynaArray<T> {
    private T[] array;

    public DynaArray() {
        super();
        array = (T[]) new Object[10];
    }

    public DynaArray(T[] array) {
        super();
        this.array = array;
        this.size = array.length;
    }
}
