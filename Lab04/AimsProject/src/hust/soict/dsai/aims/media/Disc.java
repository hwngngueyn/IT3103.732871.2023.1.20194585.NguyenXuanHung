package hust.soict.dsai.aims.media;

public class Disc extends Media{

	private String director ; // Thuộc tính đạo diễn
	private int length ; // Thuộc tính độ dài CD

	// Defalut constructor of the Disc
	public Disc() {
		// TODO Auto-generated constructor stub
	}

	// Constructor of the Disc
	public Disc(int id, String title, String category, float cost ,String director, int length) {
		super(id , title , category ,cost );
		this.director = director;
		this.length = length;
	}
	// Constructor of the Disc by title
	public Disc(String title) {
		super(title);
	}
	// Constructor theo category, title and cost
	public Disc(String title, String category, float cost) {
		super(title, category , cost);
	}
	// Constructor theo director, category, title and cost
		public Disc(String title, String category, String director, float cost) {
			super(title, category , cost);
			this.director = director;
		}
	// Constructor theo all attributes: title, category, director, length and cost
		public Disc(String title, String category, String director, int length, float cost) {
			super(title, category ,cost);
			this.director = director;
			this.length = length;
		}

	// Getter và Setter of the Disc
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}

	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
}
