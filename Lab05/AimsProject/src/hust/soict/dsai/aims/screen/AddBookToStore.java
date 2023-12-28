package hust.soict.dsai.aims.screen;


import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.Optional;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Media;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;
// child dialog
public class AddBookToStore extends AddItemToStore {
	// new field exclusive to Book type - author
	Label author = new Label("Author: ");
	TextField tauthor = new TextField();
	// dialog create by this class
	Dialog d;
	// construtor to get everything we need
	public AddBookToStore() {
		createBook();
	}
	// method to create an add-book dialog
	public Dialog createBook() {
		d = createDialog(); // call the createDialog() method of the parent class
		d.setResult(Book.class); // set result type of the dialog to Book
		GridPane grid = setgrid(); // create grid
		addToGrid(grid, author, tauthor); // add author field to it
		addToGrid(grid, this.cost, this.tcost); // add cost field to it
		floatTxtFld(tcost);
		d.getDialogPane().setContent(grid); // add the grid to the dialog
		setbutton(d); // add the button to the dialog
		return d; // return
	}
	// method to create button and handle event
	public void setbutton(Dialog dialog) {
		ButtonType buttonTypeOk = new ButtonType("Okay", ButtonData.OK_DONE); // create new ok button
		dialog.getDialogPane().getButtonTypes().add(buttonTypeOk ); // add it to the dialog
		// set result converter
		dialog.setResultConverter(new Callback<ButtonType, Book>() {
			@Override
			public Book call(ButtonType b) {

				if (b == buttonTypeOk) {//so that when we click the button
				//  we get the media
					return new Book(ttitle.getText(), tcate.getText(), Float.parseFloat(tcost.getText()), tauthor.getText());
				}
				return null;
			}
		});
	}

}
