

public class Aims {
	public static void main(String[] args) {

		// Create a new cart
		Cart anOrder = new Cart();

		// Create new DVD objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		//anOrder.addDigitalVideoDisc(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 84, 24.95f);
		//anOrder.addDigitalVideoDisc(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		//anOrder.addDigitalVideoDisc(dvd3);

		DigitalVideoDisc[] dvdList = new DigitalVideoDisc[3];
		dvdList[0] = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		dvdList[1] = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 84, 24.95f);
		dvdList[2] = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);

		anOrder.addDigitalVideoDisc(dvdList);
		// Print total cost of the items in the cart
		System.out.println("Total Cost is: ");
		System.out.println(anOrder.totalCost());

		// Remove DVD
		anOrder.removeDigitalVideoDisc(dvd1);

		// Print total cost of the items in the cart
		System.out.println("Total Cost is: ");
		System.out.println(anOrder.totalCost());


	}
}
