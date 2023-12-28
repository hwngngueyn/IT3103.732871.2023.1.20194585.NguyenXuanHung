package hust.soict.dsai.aims.cart;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20 ; // Thuộc tính số lượng DVD max có thể order

	// Array list chứa các media
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

	public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public void setItemsOrdered(ArrayList<Media> itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}

	// Phương thức thêm Media vào trong cart
	public void addMedia(Media media_ordered) {
			if(itemsOrdered.size() > MAX_NUMBERS_ORDERED) {
				System.out.println("The cart is almost full");
			}else {
				itemsOrdered.add(media_ordered);
				totalCost += media_ordered.getCost();
				System.out.println("The media has been added");
			}
	}

	//Phuong thuc them 2 media tham so vào media
		public void addMedia(Media media_ordered1 ,Media media_ordered2) {
				if(itemsOrdered.size() + 2> MAX_NUMBERS_ORDERED) {
					System.out.println("The cart is almost full");
				}else {
					itemsOrdered.add(media_ordered1);
					totalCost += media_ordered1.getCost();
					System.out.println("The media has been added");
					itemsOrdered.add(media_ordered2);
					totalCost += media_ordered2.getCost();
					System.out.println("The media has been added");
				}
		}

	// Phương thức thêm media tham số là mảng
		public void addMedia(Media[] mediaList) {
			for(int i = 0 ; i< mediaList.length ; i++) {
				if(itemsOrdered.size() + mediaList.length > MAX_NUMBERS_ORDERED) {
					System.out.println("The cart is almost full");
					break;
				}else {
					itemsOrdered.add(mediaList[i]);
					totalCost += mediaList[i].getCost();
					System.out.println("The media has been added");
				}
			}
		}

	// A method addMedia tham so la so media bất kì
		public void addMedia(Media media, Media...medias) {
			addMedia(media);
			System.out.println("The media has been added");
			for(int i = 0 ; i < medias.length ; i++) {
				if( itemsOrdered.size() + medias.length > MAX_NUMBERS_ORDERED) {
					System.out.println("The cart is almost full");
					break;
				}else {
					itemsOrdered.add(medias[i]);
					totalCost += medias[i].getCost();
					System.out.println("The media has been added");
				}
			}
		}

	// Phuong thuc xoa media khoi cart
	public void removeMedia(Media media_ordered)  {
		if( itemsOrdered.size() <= 0) {
			System.out.println("The cart is empty");
		}else {
			itemsOrdered.remove(media_ordered);
			totalCost -= media_ordered.getCost();
			System.out.println("The media has been removed");
		}
	}

	// Phuong thuc tinh tong tien trong cart
	float totalCost = 0;
	public float totalCost() {
		return totalCost;
	}

	// Phuong thuc print
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for(int i = 0 ; i < itemsOrdered.size() ; i++) {
			if(itemsOrdered.get(i) == null) {
				itemsOrdered.remove(i);
			}else {
				System.out.println(itemsOrdered.get(i));
			}
		}
		System.out.println("Total cost: " + totalCost + "$");
		System.out.println("***************************************************");
	}

	//Phuong thuc tim kiem theo ID and display the search results
	public void searchByID() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID for search: ");
		int x = sc.nextInt();
		boolean check = false;

		for( int i = 0 ; i < itemsOrdered.size() ; i++) {
			if(itemsOrdered.get(i) == null) {
				itemsOrdered.remove(i);
			}else {
				if(itemsOrdered.get(i).getId() == x) {
					System.out.println(itemsOrdered.get(i));
					check = true;
					break;
				}
			}
		}
		if(check == false) {
			System.out.println("No match is found");
		}
	}

	// Phuong thuc tim kiem theo title
	public void isMatchByTitle(String title) {
		boolean check = false;

		for( int i = 0 ; i < itemsOrdered.size() ; i++) {
			if(itemsOrdered.get(i) == null) {
				itemsOrdered.remove(i);
			}else {
				if(title.equals(itemsOrdered.get(i).getTitle())) {
					System.out.println(itemsOrdered.get(i));
					check = true;
					break;
				}
			}
		}
		if(check == false) {
			System.out.println("No match is found");
		}
	}

	public void SortByTitle() {
    	Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }
    public void SortByCost() {
    	Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

	public ObservableList<Media> getItemOrdered(){
    	return (ObservableList<Media>) this.itemsOrdered;
    }

	public ObservableList<Media> Search (int id) {
    	ObservableList<Media> found = FXCollections.observableArrayList(); // list
    	for (Media i: itemsOrdered) { // we search through the cart
    		if (i.getId() == id) {
    			// if there is an item with that id, return that media
    			found.add(i);
    		}
    	}
    	// else return null
    	return found;
    }
    /* method to search item in the cart with title. Because there may be many items that contain the string,
     * we have to search through out the whole cart.
     */
    public ObservableList<Media> Search (String title) {
    	ObservableList<Media> found = FXCollections.observableArrayList(); // list
    	for (Media i: itemsOrdered) { // we search through the cart
    		String tmp = i.getTitle(); // a temporary string that equal to the title of considering items
    		if (tmp.contains(title)) {
    			// if that string contain the considering title, add it to the found list
    			found.add(i);
    		}
    		else continue;
    	}
    	// print the number of the matching items in the cart
    	return found;
    }

}
