package com.company.Interfaces;

public interface WinnerChecker {
    void setGameTable(GameTable gameTable);

    WinnerResult isWinnerFound(CellValue cellValue);
}
