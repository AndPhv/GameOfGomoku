package com.company.Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.company.DataStructures.*;
import com.company.Implementation.*;
import com.company.Interfaces.*;

public class GUIGomoku extends JFrame {
    private static final long serialVersionUID = 1714372457079337160L;
    private final JLabel cells[][];
    private final GameTable gameTable;
    private final HumanTurn humanTurn;
    private final ComputerTurn computerTurn;
    private final WinnerChecker winnerChecker;
    private boolean isHumanFirstTurn;

    public GUIGomoku() throws HeadlessException {
        super("Gomoku");
        gameTable = new DefaultGameTable();
        humanTurn = new DefaultHumanTurn();
        computerTurn = new DefaultComputerTurn();
        winnerChecker = new DefaultWinnerChecker();
        initGameComponents();
        cells = new JLabel[gameTable.getSize()][gameTable.getSize()];
        isHumanFirstTurn = true;
        createGameUITable();
    }

    protected void initGameComponents(){
        humanTurn.setGameTable(gameTable);
        computerTurn.setGameTable(gameTable);
        winnerChecker.setGameTable(gameTable);
    }

    protected void drawCellValue(Cell cell) {
        CellValue cellValue = gameTable.getValue(cell.getRowIndex(), cell.getColIndex());
        cells[cell.getRowIndex()][cell.getColIndex()].setText(cellValue.getValue());
        if(cellValue == CellValue.COMPUTER) {
            cells[cell.getRowIndex()][cell.getColIndex()].setForeground(Color.RED);
        } else  {
            cells[cell.getRowIndex()][cell.getColIndex()].setForeground(Color.BLUE);
        }
    }

    protected void markWinnerCells(DataSet<Cell> winnerCells) {
        for (int i = 0; i < winnerCells.size(); i++) {
            Cell cell = winnerCells.get(i);
            cells[cell.getRowIndex()][cell.getColIndex()].setForeground(Color.CYAN);
            cells[cell.getRowIndex()][cell.getColIndex()].setFont(new Font(Font.SERIF, Font.BOLD, 35));
        }
    }
}
