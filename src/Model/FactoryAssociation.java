package Model;

import javafx.scene.canvas.Canvas;

public class FactoryAssociation implements AbstractFactoryArrow {
    @Override
    public AbstractProductArrow CreateArrow(Canvas canvas) {
        System.out.println("Ассоциация");
        return new ArrowAssociation(0, 0, 0, 0);
    }
}
