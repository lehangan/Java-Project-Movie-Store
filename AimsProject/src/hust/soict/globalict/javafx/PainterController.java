package AimsProject.src.hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;

public class PainterController {	
    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton eraserRadio;

    @FXML
    private ToggleGroup pen;

    @FXML
    private RadioButton penRadio;
    
    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	if (penRadio.isSelected()) {
	    	Circle newCircle = new Circle(event.getX(), event.getY(), 4);
	    	
	    	drawingAreaPane.getChildren().add(newCircle);
    	} else if (eraserRadio.isSelected()) {
            for (int i = drawingAreaPane.getChildren().size() - 1; i >= 0; i--) {
            	Node child = drawingAreaPane.getChildren().get(i);
                if (child instanceof Circle) {
                    Circle circle = (Circle) child;
                    double circleX = circle.getCenterX();
                    double circleY = circle.getCenterY();

                    if (Math.abs(circle.getCenterX() - event.getX()) <= 8 && 
                    		Math.abs(circle.getCenterY() - event.getY()) <= 8) {
                    	drawingAreaPane.getChildren().remove(i);
                    }
                }
            }
    	}
    }

}