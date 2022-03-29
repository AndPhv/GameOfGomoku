package com.company.DataStructures;

import java.util.Arrays;

public abstract class DataStructure<T> {
    protected final DataSet<T> dataSet;

    public DataStructure(DataSet<T> dataSet) {
        super();
        this.dataSet = dataSet;
    }

    public void add(T element) {
        dataSet.add(element);
    }

    protected abstract int getCurrentIndex();

    public T get() {
        if (isEmpty()) {
            throw createEmptyExceptionInstance();
        } else {
            return dataSet.remove(getCurrentIndex());
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw createEmptyExceptionInstance();
        } else {
            return dataSet.get(getCurrentIndex());
        }
    }

    protected abstract RuntimeException createEmptyExceptionInstance();

    public int size() {
        return dataSet.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    protected T[] toArray() {
        return dataSet.toArray();
    }
}
