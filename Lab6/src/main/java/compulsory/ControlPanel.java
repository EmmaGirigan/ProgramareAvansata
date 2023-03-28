package compulsory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        setLayout(new GridLayout(1, 4));
        add(loadBtn);
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);
        loadBtn.addActionListener(this::loadGame);
        saveBtn.addActionListener(this::saveGame);
        resetBtn.addActionListener(this::resetGame);
        exitBtn.addActionListener(this::exitGame);
    }
    private void loadGame(ActionEvent e){
        try {
            frame.canvas.image = ImageIO.read(new File("C:\\Users\\emmag\\source\\repos\\ProgramareAvansata\\Lab6\\src\\main\\resources\\canvas.png"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        frame.canvas.repaint();
    }
    private void saveGame(ActionEvent e){
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("C:\\Users\\emmag\\source\\repos\\ProgramareAvansata\\Lab6\\src\\main\\resources\\canvas.png"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    private void resetGame(ActionEvent e){
        frame.canvas.removeAll();
        frame.canvas.repaint();
        frame.canvas.createOffscreenImage();
        frame.canvas.initPanel();
    }
    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

}
