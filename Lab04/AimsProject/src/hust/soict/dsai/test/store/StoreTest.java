package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
	public static void main(String[] args) {
		// Create a new store
		Store store = new Store();
						
		// Create new DVD objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
					"Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(dvd1);
		store.addMedia(dvd1,dvd1);
		
						
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
						"Science Fiction", "George Lucas", 84, 24.95f);
		store.addMedia(dvd2);
					
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
						"Animation", 18.99f);
		store.addMedia(dvd3);
		System.out.println(store.getnumOfCurrentMedia());
			
		// test removeDVD
		store.removeMedia(dvd1);
		System.out.println(store.getnumOfCurrentMedia());
		
	}
}
