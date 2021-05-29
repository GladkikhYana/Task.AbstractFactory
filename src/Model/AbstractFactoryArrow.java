package Model;


import javafx.collections.ObservableList;
import javafx.scene.canvas.Canvas;

public interface AbstractFactoryArrow {
    AbstractProductArrow CreateArrow(Canvas canvas);
}
