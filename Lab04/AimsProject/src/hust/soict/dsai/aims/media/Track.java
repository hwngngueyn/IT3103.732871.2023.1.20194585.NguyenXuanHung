package hust.soict.dsai.aims.media;

public class Track implements Playable{

	private String title ;
	private int length ;

	public Track() {
		// TODO Auto-generated constructor stub
	}

	//Getter và setter của Track
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}

	// Method play()
	@Override
	public void play() {
		System.out.println("Playing DVD: "+ this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}

	// Ghi đè phương thức equals theo tittle và length
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Track) {
			Track track_another = (Track) obj;
			if(this.title.equals(track_another.title)
					&& this.length == track_another.length ) {
				return true;
			}
		}
		return false;
	}

}
