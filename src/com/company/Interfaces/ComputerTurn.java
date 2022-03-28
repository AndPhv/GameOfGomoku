package com.company.Interfaces;

public interface ComputerTurn {
    void setGameTable(GameTable gameTable);

    Cell makeTurn();

    Cell makeFirstTurn();
}
