package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;



public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20 ; // Thuộc tính số lượng DVD max có thể order

	// Array list chứa các media
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

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


}
