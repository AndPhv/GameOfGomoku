package com.company.Interfaces;

public interface WinnerResult {
    boolean winnerExists();

    DataSet<Cell> getWinnerCells();
}
