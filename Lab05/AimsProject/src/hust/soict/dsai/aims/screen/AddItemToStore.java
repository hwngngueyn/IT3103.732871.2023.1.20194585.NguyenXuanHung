package hust.soict.dsai.aims.screen;

import java.util.InputMismatchException;


import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
// parent dialog
public class AddItemToStore{
	// 3 field that always have in the dialog
	Label title = new Label("Title: "); // title
	TextField ttitle = new TextField();
	Label category = new Label("Category: "); // category
	TextField tcate = new TextField();
	Label cost = new Label("Cost: "); // cost
	TextField tcost = new TextField();
	// method to create initial dialog
	protected Dialog createDialog() {
		Dialog<Object> dialog = new Dialog<>(); // new dialog
		dialog.setTitle("Update store: Add item"); // set title
		dialog.setHeaderText("Input information to add to dialog"); // set header text
		dialog.setResizable(true); // set resizable to true
		return dialog; // return dialog
	}
	// method to create initial grid (so that we add elements later)
	protected GridPane setgrid() {
		GridPane grid = new GridPane(); // new grid
		grid.setAlignment(Pos.CENTER); // center alignment
		// set both Hgap and Vgap to 10
		grid.setHgap(10);
		grid.setVgap(10);
		// set padding
		grid.setPadding(new Insets(20, 35, 20, 35));
		// add title and category first, cost will be the last thing to add
		addToGrid(grid, title, ttitle);
		addToGrid(grid, category, tcate);
		// return
		return grid;
		}
	// method to add a pair of label and textfield to the grid
	protected void addToGrid(GridPane grid, Label l, TextField tf) {
		// get the current row
		int i = grid.getRowCount();
		grid.add(l, 1, ++i); // add label to the next row
		grid.add(tf, 2, i); // add textfield to the same row with table
	}
	// method to add positive integer format to the text field
	public static void digitsTxtFld(TextField field) {
	    field.setTextFormatter(new TextFormatter<Integer>(change -> {
	        String newText = change.getControlNewText(); // get the text
	        if (newText.matches("^\\d*$")) { // if the input is positive integer
	            return change; // then let it be
	        }
	        else { // throw new exception
	        	throw new InputMismatchException("ERROR: Input is not valid");
	        }
	    }));
	}
	// method to add positive float format to the text field
	public static void floatTxtFld(TextField field) {
	    field.setTextFormatter(new TextFormatter<Integer>(change -> {
	        String newText = change.getControlNewText(); // get the text
	        if (newText.matches("[0-9]*\\.?,?[0-9]+")) { // if the input is positive integer
	            return change; // then let it be
	        }
	        else { // throw new exception
	        	throw new InputMismatchException("ERROR: Input is not valid");
	        }
	    }));
	}
}
