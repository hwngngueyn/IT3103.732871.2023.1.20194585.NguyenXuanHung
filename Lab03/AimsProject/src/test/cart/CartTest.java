


package hust.soict.dsai.test.cart;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class CartTest {
	public static void main(String[] args) {
		// Create a new cart
		Cart cart = new Cart();

		// Create new DVD objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
			"Animation", "Roger Allers", 87, 19.95f);
		cart.addDigitalVideoDisc(dvd1);
		System.out.println(dvd1.getId());

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
						"Science Fiction", "George Lucas", 84, 24.95f);
		cart.addDigitalVideoDisc(dvd2);
		System.out.println(dvd2.getId());

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
						"Animation", 18.99f);
		cart.addDigitalVideoDisc(dvd3);
		System.out.println(dvd3.getId());


		System.out.println(dvd1.toString());

		// Test the print method
		cart.print();
		// Test the search methods
		cart.searchByID();
		cart.isMatchByTitle("Aladin");
		cart.isMatchByTitle("Aladina");

	}



}
