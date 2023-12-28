


package hust.soict.dsai.test.cart;
import java.util.ArrayList;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
	public static void main(String[] args) {
		// Create a new cart
		Cart cart = new Cart();

		// Create new Media objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
			"Animation", "Roger Allers", 87, 19.95f);
		cart.addMedia(dvd1);
		System.out.println(dvd1.getId());

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
						"Science Fiction", "George Lucas", 84, 24.95f);
		cart.addMedia(dvd2);
		System.out.println(dvd2.getId());

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
						"Animation", 18.99f);
		cart.addMedia(dvd3);
		System.out.println(dvd3.getId());


		// Test the print method
		cart.print();
		// Test the search methods
		cart.searchByID();
		cart.isMatchByTitle("Aladin");
		cart.isMatchByTitle("Aladina");

	}



}
