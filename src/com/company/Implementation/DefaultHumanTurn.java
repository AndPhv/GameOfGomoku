package com.company.Implementation;

import com.company.Interfaces.Cell;
import com.company.Interfaces.CellValue;
import com.company.Interfaces.GameTable;
import com.company.Interfaces.HumanTurn;

public class DefaultHumanTurn implements HumanTurn {
    private GameTable gameTable;

    @Override
    public void setGameTable(GameTable gameTable) {
        if (gameTable == null)
            throw new NullPointerException("Game table can't be null");
        this.gameTable = gameTable;
    }

    @Override
    public Cell makeTurn(int row, int col) {
        gameTable.setValue(row, col, CellValue.HUMAN);
        return new Cell(row, col);
    }
}
