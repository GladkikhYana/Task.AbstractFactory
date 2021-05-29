package Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

abstract public class AbstractProductArrow {
    Color color;
    double width;
    double startX;
    public void setStartX(double startX) {
        this.startX = startX;
    }
    public void setStartY(double startY) { this.startY = startY; }
    public void setEndX(double endX) { this.endX = endX;}
    public void setEndY(double endY) { this.endY = endY;}
    double startY;
    double endX;
    double endY;
    public abstract void draw(GraphicsContext gc);
}
