package Model;


import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;

public class FactoryDependence implements AbstractFactoryArrow {


    @Override
    public AbstractProductArrow CreateArrow(Canvas canvas) {
            System.out.println("Зависимость");
            return new ArrowDependence(300, 300, 300, 300);
    }
}
