
package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>(); // ArrayList chứa tập các authors

	// Constructor default
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int id , String title , String category , float cost ,List<String> authors) {
		super(id , title , category , cost);
		this.authors = authors;
	}

	public Book(String title) {
		super(title);
	}


	public Book(String title, String category, float cost, String author) {
		super(title, category, cost);
		this.authors = authors ;
	}

	// Getter and Setter of Authors
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	// Method addAuthor
	public void addAuthor(String authorName){
		if(authors.contains(authorName)) {
			System.out.println("Author already exist");
		}else {
			authors.add(authorName);
		}
	}

	// Method removeAuthor
	public void removeAuthor(String authorName){
		if(!authors.contains(authorName)) {
			System.out.println("Author does not exist");
		}else {
			authors.remove(authorName);
		}
	}


}
