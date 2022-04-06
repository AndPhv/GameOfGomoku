package com.company.Implementation;

import com.company.Interfaces.*;
import com.company.DataStructures.*;
import com.company.Implementation.*;

import java.util.Objects;

public class DefaultComputerTurn implements ComputerTurn {
    private GameTable gameTable;
    private int winCount = DefaultConstants.WIN_COUNT;

    @Override
    public void setGameTable(GameTable gameTable) {
        Objects.requireNonNull(gameTable, "Game table can't be null");
        if(gameTable.getSize() < winCount) {
            throw new IllegalArgumentException("Size of gameTable is small: size="+gameTable.getSize()+". Required >= "+winCount);
        }
        this.gameTable = gameTable;
    }

    @Override
    public Cell makeTurn() {
        CellValue[] figures = { CellValue.COMPUTER, CellValue.HUMAN };
        for (int i = winCount - 1; i > 0; i--) {
            for (CellValue cellValue : figures) {
                Cell cell = tryMakeTurn(cellValue, i);
                if (cell != null) {
                    return cell;
                }
            }
        }
        return makeRandomTurn();
    }

    @Override
    public Cell makeFirstTurn() {
        Cell cell = new Cell(gameTable.getSize() / 2, gameTable.getSize() / 2);
        gameTable.setValue(cell.getRowIndex(), cell.getColIndex(), CellValue.COMPUTER);
        return cell;
    }
}
