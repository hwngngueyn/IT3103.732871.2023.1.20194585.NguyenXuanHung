

public class DigitalVideoDisc {
	private String title ; // Thuộc tính tiêu đề
	private String category; // Thuộc tính thể loại
	private String director ; // Thuộc tính đạo diễn
	private int length ; // Thuộc tính độ dài DVD
	private float cost ; // Thuộc tính giá tiền DVD

	// Phương thức khởi tạo theo title
	public DigitalVideoDisc(String title) {
		this.title = title;
	}

	// Phương thức khởi tạo theo category, title and cost
	public DigitalVideoDisc(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	// Phương thức khởi tạo theo director, category, title and cost
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}

	// Phương thức khởi tạo theo all attributes: title, category, director, length and cost
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}

	// Phương thức gettter và setter của title
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	// Phương thức gettter và setter của category
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	// Phương thức gettter và setter của director
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	// Phương thức gettter và setter của length
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	// Phương thức gettter và setter của cost
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}



}
