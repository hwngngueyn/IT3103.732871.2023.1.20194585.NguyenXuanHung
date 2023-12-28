package hust.soict.dsai.javafx;


import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class PainterController {
	   @FXML
	   private Pane drawingAreaPane; // drawing pane
	   @FXML
	   private ToggleGroup Tools; // group for 2 button

	    @FXML
	   private RadioButton Erasers; // button eraser
	    @FXML
	   private RadioButton Pen; // button pen
		   
	   private int color = 0; // variable for toggling pen and eraser, 1 for pen and -1 for eraser
	   @FXML
	   // event handlers for clicking Clear button
	   void clearButtonPressed(ActionEvent event) { 
		   drawingAreaPane.getChildren().clear(); // simply clear all children of pane
	    }
	   // event handlers for choosing Eraser
       public void getEraser (ActionEvent event) {
               if (Erasers.isSelected() == true) { // if eraser is selected
                   this.color = -1; // set color to -1
               }
               
           }
       // event handlers for choosing Pen
       public void getColor (ActionEvent event) {
           if (Pen.isSelected() == true) { // if pen is selected
               this.color = 1; // set color to 1
           }
          
       }
    // event handlers for dragging mouse at the pane
	   @FXML
	   void AreaMouseDragged(MouseEvent event) {
		   if (this.color == 1) { // if color is 1
	    	Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK); // then create a dot in the position of mouse 
	    	drawingAreaPane.getChildren().add(newCircle); // and add it as we "draw" them
		   }
		   else if (this.color == -1){ // if color is -1
			   Circle eraser = new Circle(event.getX(), event.getY(), 87, Color.WHITE);// then create a circle in the position of mouse 
		    	drawingAreaPane.getChildren().add(eraser); // and add it as we "erase" them
		   }
	    }
	  
	   
}