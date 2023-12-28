package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Optional;

import javax.naming.LimitExceededException;
import javax.swing.*;
import javafx.application.Application;
import javafx.application.Platform;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import hust.soict.dsai.aims.screen.CartScreen;
import hust.soict.dsai.aims.screen.CartScreenController;
// StoreScreen with Swing
public class StoreScreen extends JFrame {
	// Store and Cart for display and add to cart
	private Store store;
	private Cart cart;
	// North component
	JPanel createNorth() {
		JPanel north = new JPanel(); // is a panel
		// with box layout, component will be list from top to bottom
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		// this component will have two part: Menu bar and header
		north.add(createMenuBar()); // create a menu bar then add it to the component
		north.add(createHeader()); // create a header then add it to the component
		return north;
	}
	// the menu bar
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Option"); // have a menu with 3 option

		// option Update Store, which have 3 small options
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addBook = new JMenuItem("Add Book"); // add book
		JMenuItem addCD = new JMenuItem("Add CD");  // add CD
		JMenuItem addDVD = new JMenuItem("Add DVD"); // add DVD
		// add listener to them
		addBook.addActionListener(new UpdateListener());
		addCD.addActionListener(new UpdateListener());
		addDVD.addActionListener(new UpdateListener());
		// add them to the option
		smUpdateStore.add(addBook);
		smUpdateStore.add(addCD);
		smUpdateStore.add(addDVD);
		menu.add(smUpdateStore); // add option to the menu
		smUpdateStore.addActionListener(null);
		// option View Store
		menu.add(new JMenuItem("View store"));
		// and option View Cart
		menu.add(new JMenuItem("View cart"));

		// now put all component of menu into the menu bar
		JMenuBar menuBar = new JMenuBar(); // create new menubar
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT)); // set layout to flow layout
		menuBar.add(menu); // add menu to menu bar
		// then return the component
		return menuBar;
	}
	// event handler when type of update is chosen
	private class UpdateListener implements ActionListener{
		// attribute to pass to UpdateStore
		int type = 0;
		// Override
		public void actionPerformed(ActionEvent e) {
			dispose(); // close the StoreScreen
			// we use platform to get multithread
			Platform.setImplicitExit(false); // set ImplicitExit to false
			// get the type based on which item is chosen
			switch(e.getActionCommand()) {
			case "Add Book": type = 1; break;
			case "Add CD": type = 2; break;
			case "Add DVD": type = 3; break;
			}
			// create new UpdateStore object
			UpdateStore a = new UpdateStore();
			// create a runnable object to use in platform
			Runnable x = new Runnable() {
				@Override
				public void run() {
					a.setType(type); // set type of update
					a.start(new Stage()); // run the dialog
					try {
						store.addMedia(a.getM());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} // add the media got from dialog to the store
					new StoreScreen(store, cart); // and update the store
					}
				};
			try { // if there is no thread
				Platform.startup(x); // run in new thread
			} catch (Exception e1) { // if not
				Platform.runLater(x); // pause the current and run a new thread
			}

		}
	}



	// the header
	JPanel createHeader() {
		JPanel header = new JPanel(); // is a panel with 2 components
		// with box layout to have some components laid from left to right
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

		// first the title on the left
		JLabel title = new JLabel("AIMS"); // create panel
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50)); // set font and size to it
		title.setForeground(Color.CYAN); // set color to it
		// then the button View cart
		JButton cart1 = new JButton("View cart"); // create button
		ViewCartListener view = new ViewCartListener(cart);

		// set size to it, so that when we stretch the screen, button's size will not change
		cart1.setPreferredSize(new Dimension(100, 50)); // first set a normal size
		cart1.setMaximumSize(new Dimension(100, 50)); // then set maximum size equal to it

		// now add components to the panel
		header.add(Box.createRigidArea(new Dimension(10, 10))); // first create an invisible object to create left margin
		header.add(title); // then title
		header.add(Box.createHorizontalGlue()); // then create a space between 2 compnonents
		header.add(cart1); // then  the button
		cart1.addActionListener(view);
		header.add(Box.createRigidArea(new Dimension(10, 10))); // finally create another invisible object to create right margin

		// return the component
		return header;
	}
	// Center component
	JPanel createCenter() {
		JPanel center = new JPanel(); // is a panel with cells
		// get the list of item to show
		ObservableList<Media> mediaInStore = store.getItemInStore();
		center.setLayout(new GridLayout((mediaInStore.size()/3), 3, 2, 2)); // ordered in grid layout
		for (int i = 0; i < mediaInStore.size(); i++) {
			// create a cell in MediaStore class
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell); // then add the cell to the components
		}

		// return the components
		return center;

	}
	// this class will create a specific component we want
	public class MediaStore extends JPanel{
		private Media media; // media object to get info
		// constructor of this component
		public MediaStore(Media m) {
			this.media = m; // set attribute for use
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // set layout of this component to box layout
			// this components has 3 or 4 components
			// first the title
			JLabel title = new JLabel(m.getTitle()); // is a label
			title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20)); // with font PLAIN and size 20
			title.setAlignmentX(CENTER_ALIGNMENT); // at the center
			// second is cost
			JLabel cost = new JLabel("" + m.getCost() + " $"); // is a label
			cost.setAlignmentX(CENTER_ALIGNMENT); // at the center
			// lastly we have an Add to cart button, and a Play button for playable media
			JPanel container = new JPanel(); // first create a container
			container.setLayout(new FlowLayout(FlowLayout.CENTER)); // set its layout to flow layout with each row at the center

			// create the Add to cart button
			AddListener addmedia = new AddListener(m); // create event handler for Add to cart
			JButton addbtn = new JButton("Add to cart"); // create new button
			container.add(addbtn); // add button to container
			addbtn.addActionListener(addmedia); // add event handler to it
			if (m instanceof Playable) { // if media is playable, create the Play button
				PlayListener play = new PlayListener(m); // create event handler for Play
				JButton btnPlay = new JButton("Play"); // create new button
				container.add(btnPlay); // add button to container
				btnPlay.addActionListener(play); // add event handler to it
			}
			// now put all components into the cell
			this.add(Box.createVerticalGlue()); // create a space at the top to create top margin
			this.add(title); // add title
			this.add(cost); // add cost
			this.add(Box.createVerticalGlue()); // then create a space between 2 compnonents
			this.add(container); // and add the container of button(s)

			this.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // set border's color to black

		}
	}
	// event handler for Play button, implements ActionListener
	private class PlayListener implements ActionListener{
		private Media m; // we need media m in here to get the info for play
		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand(); // parse the action button
			if (button.equals("Play")) { // if that button is Play
				JDialog d = new JDialog(); // create a Dialog
				d.setLayout(new FlowLayout(200, 10, 10)); // set layout to flow layout
				d.setTitle("Play"); // set title to Play
				// we get two types of media that can be played

				if (m instanceof DigitalVideoDisc) { // first is DVD
					DigitalVideoDisc m1 = (DigitalVideoDisc)m; // downcasting it first
					// then create a text area including the string from play method of DVDs
					JTextArea playing = null;
					try {
						playing = new JTextArea(m1.play());
					} catch (PlayerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					d.add(playing); // then add it to the dialog
				}
				else { // second is CD
					CompactDisc m1 = (CompactDisc)m; // downcasting it first
					// then create a text area including the string from play method of DVDs
					JTextArea playing = null;
					try {
						playing = new JTextArea(m1.play());
					} catch (PlayerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					d.add(playing);

				}
	            // setsize of dialog
	            d.setSize(200, 200);
	            // set visibility of dialog
	            d.setVisible(true);
			}
		}
		// constructor for this handler
		public PlayListener(Media m) {
			this.m = m;
		}

	}
	// event handler for Add to cart button, implements ActionListener
	private class AddListener implements ActionListener{
		private Media m; // we need media m in here to add it to cart
		@Override
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand(); // parse the action button
			if (button.equals("Add to cart")) {  // if that button is Add to cart
				JDialog d = new JDialog(); // create a Dialog
				d.setLayout(new FlowLayout(200, 10, 10)); // set layout to flow layout
				d.setTitle("Notification"); // set title to Notification
				try {
					if (cart.getItemsOrdered().size() <= 20) { // if successfully add
						JLabel success = new JLabel("Them thanh cong");	// create success label

						d.add(success); // and add it to dialog
					}
					else { // if not
						JLabel failure = new JLabel("Them that bai"); // create failure label
						d.add(failure); // and add it to dialog
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            // setsize of dialog
	            d.setSize(100, 100);
	            // set visibility of dialog
	            d.setVisible(true);
			}


		}
		// constructor for this handler
		public AddListener(Media m) {
			this.m = m;
		}
	}
	// now we add all the components to the store screen
	public StoreScreen(Store store, Cart cart) {
		// set the store and cart we use
		this.store = store;
		this.cart = cart;
		Container cp = getContentPane(); // create a container
		cp.setLayout(new BorderLayout()); // set layout to border layout

		cp.add(createNorth(), BorderLayout.NORTH); // add North component to the north
		cp.add(createCenter(), BorderLayout.CENTER); // add Center component to the Center

		setVisible(true); // set visibility of screen
		setTitle("Hoàng Văn Kiên's Store"); // set title
		setSize(1024, 768); // set size

	}
	private class ViewCartListener implements ActionListener{
		private Cart cart;
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			if (button.equals("View cart")) {
				new CartScreen(this.cart);
			}
		}
		public ViewCartListener(Cart cart) {
			this.cart = cart;
		}
	}

}
