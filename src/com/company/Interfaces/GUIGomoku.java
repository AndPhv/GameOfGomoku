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
}
