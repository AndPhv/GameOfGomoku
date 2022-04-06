package com.company.Implementation;

import com.company.DataStructures.*;
import com.company.Implementation.*;
import com.company.Interfaces.*;

import java.util.Objects;

public class DefaultWinnerChecker implements WinnerChecker {

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
    public WinnerResult isWinnerFound(CellValue cellValue) {
        Objects.requireNonNull(cellValue, "cellValue can't be null");
        DataSet<Cell> result = isWinnerByRow(cellValue);
        if (result != null) {
            return new DefaultWinnerResult(result);
        }
        result = isWinnerByCol(cellValue);
        if (result != null) {
            return new DefaultWinnerResult(result);
        }
        result = isWinnerByMainDiagonal(cellValue);
        if (result != null) {
            return new DefaultWinnerResult(result);
        }
        result = isWinnerByNotMainDiagonal(cellValue);
        if (result != null) {
            return new DefaultWinnerResult(result);
        }
        return new DefaultWinnerResult(null);
    }

}