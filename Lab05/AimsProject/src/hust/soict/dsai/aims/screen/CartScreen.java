package hust.soict.dsai.aims.screen;


import java.io.IOException;
import java.lang.ModuleLayer.Controller;

import javax.swing.JFrame;
import hust.soict.dsai.aims.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

// cart screen using combination of javafx and swing
public class CartScreen extends JFrame {
	// cart used
	private Cart cart;
	public CartScreen(Cart cart) {
		super(); // create JFrame first
		// set cart
		this.cart = cart;

		JFXPanel fxPanel = new JFXPanel(); // create JFXPanel object
		this.add(fxPanel); // add it to the frame

		this.setTitle("Hoang Van Kien's Cart"); // set title
		this.setVisible(true); // set visible
		// now create methods to run
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// using try_catch to get exception if happened
				try {
					// create resource loader form fxml file
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/cart.fxml"));
					// create controller
					CartScreenController controller = new CartScreenController(cart);
					// add controller to loader
					loader.setController(controller);
					// load resource to root
					Parent root = loader.load();
					// create a new Scene with the root Node and add the Scene to the JFXPanel
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});
	}
}
