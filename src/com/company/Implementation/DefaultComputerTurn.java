package com.company.Implementation;

import com.company.Interfaces.*;
import com.company.DataStructures.*;
import com.company.Implementation.*;

import java.util.Objects;
import java.util.Random;

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

    protected Cell makeRandomTurn() {
        DataSet<Cell> emptyCells = getAllEmptyCells();
        if (emptyCells.size() > 0) {
            Cell randomCell = emptyCells.get(new Random().nextInt(emptyCells.size()));
            gameTable.setValue(randomCell.getRowIndex(), randomCell.getColIndex(), CellValue.COMPUTER);
            return randomCell;
        } else {
            throw new ComputerCantMakeTurnException("All cells are filled! Have you checked draw state before call of computer turn?");
        }
    }

    protected DataSet<Cell> getAllEmptyCells(){
        DataSet<Cell> emptyCells = new DynaArray<>();
        for (int i = 0; i < gameTable.getSize(); i++) {
            for (int j = 0; j < gameTable.getSize(); j++) {
                if (gameTable.isCellFree(i, j)) {
                    emptyCells.add(new Cell(i, j));
                }
            }
        }
        return emptyCells;
    }
}
