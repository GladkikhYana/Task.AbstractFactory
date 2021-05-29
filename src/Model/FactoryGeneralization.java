package Model;

import javafx.scene.canvas.Canvas;

public class FactoryGeneralization implements AbstractFactoryArrow {
    @Override
    public AbstractProductArrow CreateArrow(Canvas canvas) {
        System.out.println("Обобщение");
        return new ArrowGeneralization(0, 0, 0, 0);
    }
}
