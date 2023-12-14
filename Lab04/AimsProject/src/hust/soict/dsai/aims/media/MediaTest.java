package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MediaTest {

	public static void main(String[] args) {
		
		List<Media> mediae = new ArrayList<Media>();
		
		// create some media here
		CompactDisc cd = new CompactDisc("Mono");
		DigitalVideoDisc dvd = new DigitalVideoDisc("Anime");
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Animea");
		Book book = new Book("New Book");
		// add media 
		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book);
		
		// Test collections sort
		 Collections.sort(mediae, Media.COMPARE_BY_TITLE_COST);
		 //Collections.sort(mediae, Media.COMPARE_BY_COST_TITLE);
		
		for( Media m: mediae) {
			System.out.println(m.toString());
		}
		
		
		
	}

}
