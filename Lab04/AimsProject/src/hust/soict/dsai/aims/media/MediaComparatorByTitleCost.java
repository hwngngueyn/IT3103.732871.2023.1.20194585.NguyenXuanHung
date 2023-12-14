package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media>{

	public MediaComparatorByTitleCost() {
		// TODO Auto-generated constructor stub
	}

	// Sort list media by title ABC
		@Override
		public int compare(Media o1, Media o2) {
			if( o1.getTitle().equals(o2.getTitle()) ) {
				return (o1.getCost() >= o2.getCost()) ? 1 :-1 ;
			}else {
				return o1.getTitle().compareTo(o2.getTitle());
			}
		}

}
