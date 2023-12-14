package hust.soict.dsai.aims.store;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
	// Thuoc tinh chua so luong dia trong store
	private int numOfCurrentMedia = 0 ;
	// Thuoc tinh mang chua tat ca cac gia tri trong mang
	ArrayList<Media> itemsInStore = new ArrayList<Media>();

	// Phuong thuc them media vao cua hang
	public void addMedia(Media media1, Media... medias) {
		itemsInStore.add(media1);
		numOfCurrentMedia++;
		for(Media disc: medias) {
			itemsInStore.add(disc);
			numOfCurrentMedia++;
		}
	}
	public void addDVD(Media[] medias) {
		for(Media media : medias) {
			itemsInStore.add(media);
			numOfCurrentMedia++;
		}
	}

	// Phuong thuc xoa ca dia khoi cua hang
	public void removeMedia(Media media1, Media... medias) {
		itemsInStore.remove(media1);
		numOfCurrentMedia--;
		for(Media media : medias) {
			itemsInStore.remove(media);
			numOfCurrentMedia--;
		}
	}
	public void removeDVD(Media[] medias) {
		for(Media media : medias) {
			itemsInStore.remove(media);
			numOfCurrentMedia--;
		}
	}
	// Phuong thuc getter và setter của numOfCurrentMedia
	public int getnumOfCurrentMedia() {
		return numOfCurrentMedia;
	}
	public void setnumOfCurrentMedia(int numOfCurrentMedia) {
		this.numOfCurrentMedia = numOfCurrentMedia;
	}

}
