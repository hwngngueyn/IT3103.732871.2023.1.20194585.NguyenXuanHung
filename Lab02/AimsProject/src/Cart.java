import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// \NguyenXuanHung

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

	// Phương thức xóa đĩa DVD khỏi cart
	public void removeDigitalVideoDisc(DigitalVideoDisc disc)  {
		if( qtyOrdered < 0) {
			System.out.println("The cart is empty");
		}else {
			list_items.remove(disc);
			qtyOrdered--;
			totalCost -= disc.getCost();
			System.out.println("The disc has been removed");
		}
	}

	// Phương thức tính tổng tiền phải trả
	float totalCost = 0;
	public float totalCost() {
		return totalCost;
	}

}
