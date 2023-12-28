package hust.soict.dsai.aims.screen;



import java.awt.FlowLayout;

import javax.naming.LimitExceededException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.FloatBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Window;

// controller of cart screen
public class CartScreenController {
	private Cart cart;

	@FXML
    private Label TotalCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TextField tfFilter;
    @FXML
    private MenuBar Menu;
    @FXML
    private MenuItem addBook;

    @FXML
    private MenuItem addCD;

    @FXML
    private MenuItem addDVD;

    public CartScreenController(Cart cart) {
		this.cart = cart;
	}
    @FXML
    // method to play media when clicking Play button
    void btnPlaceOrderPressed(ActionEvent event) {
    	Dialog<String> d = new Dialog<String>(); // create a Dialog
		d.setTitle("Notìication"); // set title to Notìication
		d.setContentText("Your order has been placed!"); // set content to the notification
		// this block of codes make the dialog closable
        d.getDialogPane().getButtonTypes().add(ButtonType.CLOSE); // add a hidden close button to dialog
        Node closeButton = d.getDialogPane().lookupButton(ButtonType.CLOSE);  // modify it to the close button of the dialog
        closeButton.managedProperty().bind(closeButton.visibleProperty()); // bind the button to work on the dialog
        closeButton.setVisible(false); // set visible to false so that the two won't conflict
        d.showAndWait(); // show the dialog and wait for the close
    }
    @FXML
    // method to remove media when clicking Remove button
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem(); // get that item from table
    	try {
			cart.removeMedia(media);
		} catch (Exception e) {
			e.printStackTrace();
		} // delete it, the cart will automatically display the change because of the observasable list class
    	TotalCost.setText("" + this.cart.totalCost() + " $"); // update the total cost
    }
    @FXML
    // method to play media when clicking Play button
    void btnPlayPressed(ActionEvent event) {
    	Media m = tblMedia.getSelectionModel().getSelectedItem(); // get that item from table
    	Dialog<String> d = new Dialog<String>(); // create a Dialog
		d.setTitle("Play"); // set title to Play
		// we get two types of media that can be played
		if (m instanceof DigitalVideoDisc) { // first is DVD
			DigitalVideoDisc m1 = (DigitalVideoDisc)m; // downcasting it first
			try {
				d.setContentText(m1.play());
			} catch (PlayerException e) {
				e.printStackTrace();
			} // set content of dialog to the lay information
		}
		else if (m instanceof CompactDisc) { // first is DVD
			CompactDisc m1 = (CompactDisc)m; // downcasting it first
			try {
				d.setContentText(m1.play());
			} catch (Exception e) {
				e.printStackTrace();
			} // set content of dialog to the lay information
		}
		// this block of codes make the dialog closable
        d.getDialogPane().getButtonTypes().add(ButtonType.CLOSE); // add a hidden close button to dialog
        Node closeButton = d.getDialogPane().lookupButton(ButtonType.CLOSE);  // modify it to the close button of the dialog
        closeButton.managedProperty().bind(closeButton.visibleProperty()); // bind the button to work on the dialog
        closeButton.setVisible(false); // set visible to false so that the two won't conflict
        d.showAndWait(); // show the dialog and wait for the close
    }

    @FXML
    // method to perform any post-processing on the content of the JFrame after it is loaded from FXML and before it is shown
    public void initialize() {
    	/* set the columns’ cellValueFactory using the class PropertyValueFactory<S, T>,
    	 a callback that will take in a String <property> and look for the method get<property>() in the Source S class,
    	 then return value to TableCell if that method exist
    	 */
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    	colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
    	// set the cart’s list of items to the items of the TableView, we change it to FilterList to prepare
    	// for any user input on filter text field
    	FilteredList<Media> filteredData = new FilteredList<>(cart.getItemOrdered(), s -> true);
    	tblMedia.setItems(filteredData);
    	// set initialize value for total cost


    	// set buttons' visible to false first
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);

    	// add change listener for table media
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>()
    	{
    		// change value to show up the two buttons when needed, we need newly chosen media
    		public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
    			if(newValue != null) { // if a media has been chosen
    				updateButtonBar(newValue); // update state of buttons

    			}
    		}
    		// method to update state of buttons
			private void updateButtonBar(Media media) {
				btnRemove.setVisible(true); // always set remove visible
				if (media instanceof Playable) { // if media is playable
					btnPlay.setVisible(true); // set play visible
				}
				else btnPlay.setVisible(false); // else let it unchanged

			}

    	});
    	// method to set filter that is re-applied every time the user makes a change in the filter text field
    	tfFilter.textProperty().addListener(new ChangeListener<String>() {
    		public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

    				showFilterMedia(newValue);
		}
    		// method to show filter result
			private void showFilterMedia(String newValue) {
				// if user's new value is not insert or is empty, return the original list
				if (newValue == null || newValue.length() ==0) {
					filteredData.setPredicate(s -> true);
				}
				else {
					// if By ID is chosen, return new list filtered by ID
					if (radioBtnFilterId.isSelected()) {
						filteredData.setPredicate(s -> cart.Search(Integer.parseInt(newValue)).contains(s));
					}
					// if By Title is chosen, return new list filtered by title
					else {
						filteredData.setPredicate(s -> cart.Search(newValue).contains(s));
					}
				}

			}
    	});
    	TotalCost.setText("" + this.cart.totalCost() + " $"); // set initialized value of totalcost

    }
}
