package com.company;

import com.company.Interfaces.GUIGomoku;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        GUIGomoku w = new GUIGomoku();
        w.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        w.setResizable(false);
        w.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        w.setLocation(dim.width / 2 - w.getSize().width / 2, dim.height / 2 - w.getSize().height / 2);
        w.setVisible(true);
    }
}
