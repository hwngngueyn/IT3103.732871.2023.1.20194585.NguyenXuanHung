package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

// Hoàng Văn Kiên  - 20205089
public class DigitalVideoDisc extends Disc implements Playable {

	private static int nbDigitalVideoDiscs = 0; // Class attribute biến static
	
	 //Constructor theo title
	public DigitalVideoDisc(String title) {
		super(title);
		// Mỗi lần gọi hàm contructor thì biến nbDigitalVideoDisc tăng lên 1;
		setId(nbDigitalVideoDiscs++);
	}
	
	// Constructor theo category, title and cost
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category , cost);
		// Mỗi lần gọi hàm contructor thì biến nbDigitalVideoDisc tăng lên 1;
		setId(nbDigitalVideoDiscs++);
	}
	
	// Constructor theo director, category, title and cost
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category ,director, cost);
		// Mỗi lần gọi hàm contructor thì biến nbDigitalVideoDisc tăng lên 1;
		setId(nbDigitalVideoDiscs++);
	}
	
	// Constructor theo all attributes: title, category, director, length and cost
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title,category,director,length,cost);
		// Mỗi lần gọi hàm contructor thì biến nbDigitalVideoDisc tăng lên 1;
		setId(nbDigitalVideoDiscs++);
	}
	

	@Override
	public String toString() {
		return (getId()+1) + ".DVD - [" + getTitle() + "] - [" + getCategory() + "] - [" + getDirector() + "] - ["
				+ getLength() + "] : [" + getCost() + "$]";
	}
	
//	// Method play()
//	@Override
//	public void play() {
//		System.out.println("Playing DVD: "+ this.getTitle());
//		System.out.println("DVD length: " + this.getLength());
//	}
	
	// play methods from Playable
    public String play() throws PlayerException{
    	if (this.getLength() > 0) {
    		return ("Playing DVD: " + this.getTitle() + "\nDVD length: " + this.getLength());
    	}
    	else throw new PlayerException("ERROR: The length of DVD is not positive!");
    }
	
}
