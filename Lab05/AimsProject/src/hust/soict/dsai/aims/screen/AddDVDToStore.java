package hust.soict.dsai.aims.screen;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Optional;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;
//child dialog
public class AddDVDToStore extends AddItemToStore {
	// new field exclusive to DVD type
	Label directory = new Label("Directory: "); // directory
	TextField tdirectory = new TextField();
	Label length = new Label("Length: ");  // length
	TextField tlength = new TextField();
	// dialog create by this class
	Dialog d;
	// construtor to get everything we need
	public AddDVDToStore() {
		createDVD();
	}
	// method to create an add-cd dialog
	public Dialog createDVD() {
		d = createDialog(); // call the createDialog() method of the parent class
		d.setResult(DigitalVideoDisc.class); // set result type of the dialog to DVD
		GridPane grid = setgrid();// create grid
		addToGrid(grid, directory, tdirectory); // add directory field to it
		addToGrid(grid, length, tlength);  // add length field to it
		digitsTxtFld(tlength);
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
		dialog.setResultConverter(new Callback<ButtonType, DigitalVideoDisc>() {
			@Override
			public DigitalVideoDisc call(ButtonType b) {

				if (b == buttonTypeOk) {//so that when we click the button
				//  we get the media
					return new DigitalVideoDisc(ttitle.getText(), tcate.getText(), tdirectory.getText(),
							Integer.parseInt(tlength.getText()), Float.parseFloat(tcost.getText()));
				}

				return null;
			}
		});
	}

}
