package com.company.Implementation;

import com.company.Interfaces.CellValue;

public class DefaultGameTable {
    private final CellValue[][] gameTable;

    public DefaultGameTable() {
        gameTable = new CellValue[DefaultConstants.SIZE][DefaultConstants.SIZE];
        reInit();
    }
}
