package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;



public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20 ; // Thuộc tính chỉ số DVD max có thể order
	private int qtyOrdered = 0 ; // Thuộc tính chỉ số DVD order trong cart

	// Mảng chứa các DVD được order
		private DigitalVideoDisc itemOrdered[] =
				new DigitalVideoDisc[MAX_NUMBERS_ORDERED] ;

	ArrayList<DigitalVideoDisc> list_items = new ArrayList<DigitalVideoDisc>(Arrays.asList(itemOrdered));


	// Phương thức getter , setter của qtyOrdered
	public int getQtyOrdered() {
		return qtyOrdered;
	}

	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}

	// Phương thước thêm đĩa DVD vào cart
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
			if(qtyOrdered > MAX_NUMBERS_ORDERED) {
				System.out.println("The cart is almost full");
			}else {
				list_items.add(disc);
				qtyOrdered++;
				totalCost += disc.getCost();
				System.out.println("The disc has been added");
			}
	}

	//Phương thước thêm đĩa DVD vào cart có hai tham số
		public void addDigitalVideoDisc(DigitalVideoDisc dvd1 ,DigitalVideoDisc dvd2) {
				if(qtyOrdered > MAX_NUMBERS_ORDERED) {
					System.out.println("The cart is almost full");
				}else {
					list_items.add(dvd1);
					qtyOrdered++;
					totalCost += dvd1.getCost();
					System.out.println("The disc has been added");
					list_items.add(dvd2);
					qtyOrdered++;
					totalCost += dvd2.getCost();
					System.out.println("The disc has been added");

				}
		}

	// Phương thước thêm đĩa DVD vào cart tham số đầu vào là mảng
		public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
			for(int i = 0 ; i< dvdList.length ; i++) {
				if(qtyOrdered + dvdList.length > MAX_NUMBERS_ORDERED) {
					System.out.println("The cart is almost full");
					break;
				}else {
					list_items.add(dvdList[i]);
					qtyOrdered++;
					totalCost += dvdList[i].getCost();
					System.out.println("The disc has been added");
				}
			}
		}

	// A method addDigitalVideoDisc which allows to pass an arbitrary number of arguments for dvd.
		public void addDigitalVideoDisc(DigitalVideoDisc dvd, DigitalVideoDisc...dvds) {
			addDigitalVideoDisc(dvd);
			System.out.println("The disc has been added");
			qtyOrdered++;
			for(int i = 0 ; i < dvds.length ; i++) {
				if(qtyOrdered + dvds.length > MAX_NUMBERS_ORDERED) {
					System.out.println("The cart is almost full");
					break;
				}else {
					list_items.add(dvds[i]);
					qtyOrdered++;
					totalCost += dvds[i].getCost();
					System.out.println("The disc has been added");
				}
			}
		}

	// Phương thức xóa đĩa DVD kh�?i cart
	public void removeDigitalVideoDisc(DigitalVideoDisc disc)  {
		if( qtyOrdered <= 0) {
			System.out.println("The cart is empty");
		}else {
			list_items.remove(disc);
			qtyOrdered--;
			totalCost -= disc.getCost();
			System.out.println("The disc has been removed");
		}
	}

	// Phương thức tính tổng ti�?n phải trả
	float totalCost = 0;
	public float totalCost() {
		return totalCost;
	}

	public void removeNull() {
		for(int i = 0 ; i < list_items.size() ; i++) {
			if(list_items.get(i) == null) {
				list_items.remove(i);
			}
		}
	}


	// Phương thức print - in ra màn hình theo yêu cầu
	public void print() {
		System.out.println("***********************CART***********************");

		for(int i = 0 ; i < list_items.size() ; i++) {
			if(list_items.get(i) == null) {
				list_items.remove(i);
			}else {
				System.out.println(list_items.get(i));
			}
		}

		System.out.println("Total cost: " + totalCost + "$");
		System.out.println("***************************************************");
	}

	//Phương thức tìm kiếm theo ID và display the search results
	public void searchByID() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID for search: ");
		int x = sc.nextInt();
		boolean check = false;

		for( int i = 0 ; i < list_items.size() ; i++) {
			if(list_items.get(i) == null) {
				list_items.remove(i);
			}else {
				if(list_items.get(i).getId() == x) {
					System.out.println(list_items.get(i));
					check = true;
					break;
				}
			}
		}
		if(check == false) {
			System.out.println("No match is found");
		}
	}

	// Phương thức tìm kiếm theo title
	public void isMatchByTitle(String title) {
		boolean check = false;

		for( int i = 0 ; i < list_items.size() ; i++) {
			if(list_items.get(i) == null) {
				list_items.remove(i);
			}else {
				if(title.equals(list_items.get(i).getTitle())) {
					System.out.println(list_items.get(i));
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
