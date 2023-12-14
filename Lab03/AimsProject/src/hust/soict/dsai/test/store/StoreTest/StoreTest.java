package hust.soict.dsai.test.store.StoreTest;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
	public static void main(String[] args) {
		// Create a new store
		Store store = new Store();
						
		// Create new DVD objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
					"Animation", "Roger Allers", 87, 19.95f);
		store.addDVD(dvd1);
		store.addDVD(dvd1,dvd1);
		
						
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
						"Science Fiction", "George Lucas", 84, 24.95f);
		store.addDVD(dvd2);
					
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
						"Animation", 18.99f);
		store.addDVD(dvd3);
			System.out.println(dvd3.getId());
				
		
	}
}
