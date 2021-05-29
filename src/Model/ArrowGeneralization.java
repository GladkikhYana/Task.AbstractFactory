package Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ArrowGeneralization extends AbstractProductArrow{
    double arrowHeadSize;// размер кончика стрелки

    @Override
    public void draw(GraphicsContext gc) {
        drawArrowstart(gc);//начало стрелки
        drawLine(gc);//линия
        drawArrowend(gc);//коней стрелки
    }

    public ArrowGeneralization(double x, double y, double w, double h) {
        this.color = Color.BLACK;
        arrowHeadSize = 0.09 * Math.sqrt((startX - endX) * (startX - endX) + (startX - endX) * (startX - endX));
        if (arrowHeadSize < 2)
            arrowHeadSize = 5;
        if (arrowHeadSize > 2)
            arrowHeadSize = 15;
    }

    public String toString() {
        return "Обобщение";
    }

    public void drawArrowstart(GraphicsContext gc) {
        gc.setFill(color);
        gc.strokeOval(startX - width, startY - width, 2 * width, 2 * width);
    }

    public void drawLine(GraphicsContext gc) {
        gc.setStroke(color);
        gc.setLineWidth(width);
        gc.moveTo(startX, startY);
        gc.lineTo(endX, endY);
        gc.stroke();// соединить точки
    }

    public void drawArrowend(GraphicsContext gc) {
        gc.moveTo(endX, endY);
        double angle = Math.atan2((endY - startY), (endX - startX)) - Math.PI / 2.0;
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);
        //point1
        double x1 = (-1.0 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * arrowHeadSize + endX;
        double y1 = (-1.0 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * arrowHeadSize + endY;
        //point2
        double x2 = (1.0 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * arrowHeadSize + endX;
        double y2 = (1.0 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * arrowHeadSize + endY;
        gc.lineTo(x1, y1);
        gc.moveTo(x2, y2);
        gc.lineTo(endX, endY);
        gc.moveTo(x2, y2);
        gc.lineTo(x1, y1);
        gc.stroke();



        gc.moveTo(startX, startY);
        double angle1 = Math.atan2((startY - endY), (startX - endX)) - Math.PI / 2.0;
        double sin1 = Math.sin(angle1);
        double cos1 = Math.cos(angle1);
        //point1
        double x11 = (- 1.0 / 2.0 * cos1 + Math.sqrt(3) / 2 * sin1) * arrowHeadSize + startX;
        double y11 = (- 1.0 / 2.0 * sin1 - Math.sqrt(3) / 2 * cos1) * arrowHeadSize + startY;
        //point2
        double x22 = (1.0 / 2.0 * cos1 + Math.sqrt(3) / 2 * sin1) * arrowHeadSize + startX;
        double y22 = (1.0 / 2.0 * sin1 - Math.sqrt(3) / 2 * cos1) * arrowHeadSize + startY;
        gc.lineTo(x11, y11);
        gc.moveTo(x22, y22);
        gc.lineTo(startX, startY);
        gc.moveTo(x22, y22);
        gc.lineTo(x11, y11);
        gc.stroke();



    }

}
