package homework.panels;

import homework.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 4, 100, 1));
        linesLabel = new JLabel("Line probability:");
        Double probabilities[] = {1.0, 0.75, 0.5, 0.25};
        linesCombo = new JComboBox(probabilities);
        createButton = new JButton("Create new game");
        add(dotsLabel);
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton);
        createButton.addActionListener(this::createNewGame);
    }
    private void createNewGame(ActionEvent e){
        frame.canvas.createBoard();
        frame.canvas.emptyVertices();
        frame.canvas.emptyLines();
    }
}
