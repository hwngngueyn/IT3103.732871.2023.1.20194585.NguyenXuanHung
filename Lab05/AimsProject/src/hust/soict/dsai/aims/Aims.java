package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;
import java.util.*;

import javax.naming.LimitExceededException;



public class Aims {

	// Phương thức hiện thị Menu chính
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	// IF chose option “View store” will display all the items in the store
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
				/// The option “See a media’s details”
				public static void mediaDetailsMenu() {
					System.out.println("Options: ");
					System.out.println("--------------------------------");
					System.out.println("1. Add to cart");
					System.out.println("2. Play");
					System.out.println("0. Back");
					System.out.println("--------------------------------");
					System.out.println("Please choose a number: 0-1-2");
					}

	// IF chose option “Update store”
	// IF chose option “See current cart”
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}

		// Create new cart
		 static Cart anOrder = new Cart();
	     // Create new store
	     static Store myStore = new Store();

	public static void main(String[] args) {

		// Create new media
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers",
          87, 18.85f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("See You Again", "Music", "Wiz Khalifa",
          90, 21.12f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("A", "Animation", "20205081",
          123, 100.99f);
        Book book1 = new Book("ABC", "Story", 100f, "Hoang Van Kien");
        CompactDisc cd1 = new CompactDisc("ABCD");
        // add them to Store
        try {
			myStore.addMedia(cd1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			myStore.addMedia(dvd1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			myStore.addMedia(dvd2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			myStore.addMedia(dvd3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			myStore.addMedia(book1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // and show menu
       new StoreScreen(myStore, anOrder);
    	}
}
