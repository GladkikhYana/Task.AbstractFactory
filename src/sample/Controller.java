package sample;

import Model.*;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

    public class Controller implements Initializable {

        public ChoiceBox <String> arrows;
        public Canvas can;
        private AbstractProductArrow currentarrow;
        @Override
        public void initialize(URL location, ResourceBundle resources) {
            arrows.getItems().addAll("Зависимость", "Ассоциация", "Обобщение");
            arrows.setValue("Зависимость");
            currentarrow=new FactoryDependence().CreateArrow(can);
        }
        public void handle(MouseEvent mouseEvent) {
            String current=arrows.getValue();
            if(current.equals("Зависимость")) currentarrow=new FactoryDependence().CreateArrow(can);
            if(current.equals("Ассоциация")) currentarrow=new FactoryAssociation().CreateArrow(can);
            if(current.equals("Обобщение")) currentarrow=new FactoryGeneralization().CreateArrow(can);
        }
        public void onBegin(MouseEvent mouseEvent) {
            currentarrow.setStartX(mouseEvent.getX());
            currentarrow.setStartY(mouseEvent.getY());
            System.out.println("Начало");

        }
        public void onEnd(MouseEvent dragEvent) {
            currentarrow.setEndX(dragEvent.getX());
            currentarrow.setEndY(dragEvent.getY());
            currentarrow.draw(can.getGraphicsContext2D());
            System.out.println("Закончили");
        }

        public void onRun1(MouseEvent dragEvent) {
            currentarrow.setEndX(dragEvent.getX());
            currentarrow.setEndY(dragEvent.getY());
           // can.getGraphicsContext2D().clearRect(1,1,200,200);
            System.out.println("Движение");
        }
    }


