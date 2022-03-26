package com.company.Interfaces;

public interface GameTable {
    CellValue getValue(int var1, int var2);

    void setValue(int var1, int var2, CellValue var3);

    void reInit();

    int getSize();

    boolean isCellFree(int var1, int var2);

    boolean emptyCellExists();
}
