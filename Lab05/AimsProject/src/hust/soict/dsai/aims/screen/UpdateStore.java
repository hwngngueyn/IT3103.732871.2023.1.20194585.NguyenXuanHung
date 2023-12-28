package hust.soict.dsai.aims.screen;


import java.util.Optional;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import javafx.application.Application;
import javafx.scene.control.Dialog;
import javafx.stage.Stage;
// Update Store to run the 3 dialogs
public class UpdateStore extends Application{
	// attribute to decide which one will be chosen to do
	public int type;
	// media to get the result
	private Media m;
	// setter to set the type
	public void setType(int type) {
		this.type = type;
	}
	// start method to run
	@Override
	public void start(Stage arg0){
		// show dialog depended by type
		switch (type) {
			case 1: { // type 1: Book
				AddBookToStore a = new AddBookToStore(); // create new book dialog
				Optional<Book> result = a.d.showAndWait(); // get result from it
				if (result.isPresent()) { // if result is exist
					// try-catch to get error
					try {
						this.m = (Media) result.get(); // upcast the result to media
					} catch (Exception e) { // if error is occur
						System.out.println("Huy qua trinh nhap"); // print error
					}

				}
				break;
			}
			case 2: { // type 2: CD
			AddCDToStore a = new AddCDToStore(); // create new CD dialog
			Optional<CompactDisc> result = a.d.showAndWait(); // get result from it
			if (result.isPresent()) {// if result is exist
				// try-catch to get error
				try {
					this.m = (Media) result.get();// upcast the result to media

				} catch (Exception e) { // if error is occur
					System.out.println("Huy qua trinh nhap"); // print error
				}

			}
			break;
			}
			case 3: { // type 2: DVD
				AddDVDToStore a = new AddDVDToStore(); // create new DVD dialog
				Optional<DigitalVideoDisc> result = a.d.showAndWait(); // get result from it
				if (result.isPresent()) {// if result is exist
					// try-catch to get error
					try {
						this.m = (Media) result.get(); // upcast the result to media
						System.out.println(m.toString());
					} catch (Exception e) { // if error is occur
						System.out.println("Huy qua trinh nhap"); // print error
					}

				}
				break;
				}
		}
	}

	public Media getM() {
		return m;
	}

}
