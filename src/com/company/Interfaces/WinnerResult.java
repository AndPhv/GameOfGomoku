package com.company.Interfaces;

import com.company.DataStructures.DataSet;

public interface WinnerResult {
    boolean winnerExists();

    DataSet<Cell> getWinnerCells();
}
