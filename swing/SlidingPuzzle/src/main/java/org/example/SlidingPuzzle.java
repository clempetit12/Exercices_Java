package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.StandardException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class SlidingPuzzle {

    private JPanel panel;
    private Point emptySlot;

    private GridBagLayout layout;

    private GridBagConstraints constraints;

    private String[] buttonsLables = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", ""};

    private JButton[] buttons;

    public SlidingPuzzle() {

        panel = new JPanel();
        layout = new GridBagLayout();
        panel.setLayout(layout);
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;

        createPuzzles();

    }

    private void createPuzzles() {
        buttons = new JButton[buttonsLables.length];
        List<String> butonnsLableShuffle = Arrays.asList(buttonsLables);
        Collections.shuffle(butonnsLableShuffle);
        for (int i = 0; i < buttonsLables.length; i++) {
            buttons[i] = new JButton(buttonsLables[i]);
            buttons[i].setFont(new Font("Arial", Font.BOLD, 15));
            constraints.gridx = i % 4;
            constraints.gridy = i / 4;
            panel.add(buttons[i], constraints);
            buttons[i].addActionListener(e -> move(e));


        }


    }

    private void move(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        Point clickedButtonPostion = getButtonPosition(clickedButton);
        Point emptySlot = getEmptySlotPosition();
        System.out.println(clickedButtonPostion);
        System.out.println("emptySlot" + emptySlot);

        if (isAdjacent(clickedButtonPostion, emptySlot)) {
            constraints.gridx = emptySlot.x;
            constraints.gridy = emptySlot.y;
            emptySlot = clickedButtonPostion;
            System.out.println(emptySlot);
            layout.setConstraints(clickedButton, constraints);

            panel.revalidate();
            System.out.println("Moved button to: (" + constraints.gridx + ", " + constraints.gridy + ")");
        }


    }

    private Point getButtonPosition(JButton button) {
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i] == button) {
                int x = layout.getConstraints(button).gridx;
                int y = layout.getConstraints(button).gridy;
                return new Point(x, y);
            }
        }
        return null;
    }

    private Point getEmptySlotPosition() {
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].getText().isEmpty()) {
                int x = layout.getConstraints(buttons[i]).gridx;
                int y = layout.getConstraints(buttons[i]).gridy;
                return new Point(x, y);
            }
        }
        return null;


    }

    private boolean isAdjacent(Point pos1, Point pos2) {
        int distanceX = Math.abs(Math.abs(pos1.x) - Math.abs(pos2.x));
        int distanceY = Math.abs(Math.abs(pos1.y) - Math.abs(pos2.y));
        if (distanceY == 1 || distanceX == 1) {
            return true;
        } else {
            return false;
        }

    }


    private void updateUI() {
        panel.revalidate();
        panel.repaint();
    }


}
