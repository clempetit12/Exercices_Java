package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame= new JFrame("SlindingPuzzle");
        jFrame.setSize(500,500);
        jFrame.add(new SlidingPuzzle().getPanel());
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}