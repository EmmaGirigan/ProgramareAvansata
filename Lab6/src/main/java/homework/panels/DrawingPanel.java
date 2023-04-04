package homework.panels;

import homework.MainFrame;
import homework.shapes.Line;
import homework.shapes.Vertex;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    final static int w = 6, h = 6;
    private int numVertices;
    private double edgeProbability;
    private int[] x, y;
    final private List<Vertex> vertices = new ArrayList<>();
    final private List<Line> lines = new ArrayList<>();
    BufferedImage image;
    Graphics2D graphics;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        initPanel();
        createBoard();
    }
    protected void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
    }
    protected void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
    }
    final void createBoard() {
        numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        edgeProbability = (Double) frame.configPanel.linesCombo.getSelectedItem();
        createOffscreenImage();
        emptyVertices();
        createVertices();
        drawVertices();
        createLines();
        repaint();
    }
    private void createVertices() {
        int x0 = W / 2; int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        x = new int[numVertices];
        y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
            Vertex vertex = new Vertex(x[i], y[i], i);
            vertices.add(vertex);
        }
    }
    private void createLines(){
        double maxLines = edgeProbability*((numVertices*(numVertices-1))/2.0);
        int lineCount = 0;
        for (Vertex vertex : vertices) {
            for (int j = vertex.getI() + 1; j < numVertices; j++) {
                if(lineCount < maxLines){
                    graphics.setColor(Color.BLACK);
                    graphics.drawLine(x[vertex.getI()], y[vertex.getI()], x[j], y[j]);
                    lines.add(new Line(vertex, new Vertex(x[j], y[j])));
                    lineCount++;
                }
                else break;
            }
        }
    }
    public void emptyLines(){
        lines.clear();
    }
    public void emptyVertices(){ vertices.clear(); }
    private void drawVertices(){
        for(int i = 0; i < numVertices; i++){
            graphics.drawOval(x[i], y[i], w, h);
            graphics.setColor(Color.BLACK);
            graphics.fillOval(x[i], y[i], w, h);
        }
    }
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
//        for (Vertex vertex:
//             vertices) {
//            graphics.drawOval(vertex.getX(), vertex.getY(), w, h);
//            graphics.setColor(Color.BLACK);
//            graphics.fillOval(vertex.getX(), vertex.getY(), w, h);
//        }
//
//        for (Line line:
//            lines){
//            graphics.setColor(Color.BLACK);
//            graphics.drawLine(line.getV1().getX(), line.getV1().getY(), line.getV2().getX(), line.getV2().getY());
//        }
    }

}
