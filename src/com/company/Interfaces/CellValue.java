package com.company.Interfaces;

public enum CellValue {
    EMPTY(' '),
    HUMAN('X'),
    COMPUTER('O');

    private char value;

    private CellValue(char value) {
        this.value = value;
    }

    public String getValue() {
        return String.valueOf(this.value);
    }
}
