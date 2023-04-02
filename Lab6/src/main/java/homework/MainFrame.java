package homework;

import homework.panels.ConfigPanel;
import homework.panels.ControlPanel;
import homework.panels.DrawingPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    public ConfigPanel configPanel;
    protected ControlPanel controlPanel;
    public DrawingPanel canvas;

    public MainFrame() {
        super("Positional Game");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        canvas = new DrawingPanel(this);

        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        add(configPanel, BorderLayout.NORTH);

        pack();
    }
}

