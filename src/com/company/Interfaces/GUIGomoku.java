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

    protected void createGameUITable() {
        setLayout(new GridLayout(gameTable.getSize(), gameTable.getSize()));
        for (int i = 0; i < gameTable.getSize(); i++) {
            for (int j = 0; j < gameTable.getSize(); j++) {
                final int row = i;
                final int col = j;
                cells[i][j] = new JLabel();
                cells[i][j].setPreferredSize(new Dimension(45, 45));
                cells[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                cells[i][j].setVerticalAlignment(SwingConstants.CENTER);
                cells[i][j].setFont(new Font(Font.SERIF, Font.PLAIN, 35));
                cells[i][j].setForeground(Color.BLACK);
                cells[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                add(cells[i][j]);
                cells[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        handleHumanTurn(row, col);
                    }
                });
            }
        }
    }

    protected void startNewGame() {
        isHumanFirstTurn = !isHumanFirstTurn;
        gameTable.reInit();
        for (int i = 0; i < gameTable.getSize(); i++) {
            for (int j = 0; j < gameTable.getSize(); j++) {
                cells[i][j].setText(gameTable.getValue(i, j).getValue());
                cells[i][j].setFont(new Font(Font.SERIF, Font.PLAIN, 35));
                cells[i][j].setForeground(Color.BLACK);
            }
        }
        if (!isHumanFirstTurn) {
            Cell compCell = computerTurn.makeFirstTurn();
            drawCellValue(compCell);
        }
    }

    protected void stopGame() {
        for (int i = 0; i < gameTable.getSize(); i++) {
            for (int j = 0; j < gameTable.getSize(); j++) {
                cells[i][j].removeMouseListener(cells[i][j].getMouseListeners()[0]);
            }
        }
    }
}
