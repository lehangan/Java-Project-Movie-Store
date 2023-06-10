package AimsProject.src.hust.soict.globalict.aims.store;

import java.util.ArrayList;
import java.util.List;

import AimsProject.src.hust.soict.globalict.aims.media.Media;

public class Store {
    private List<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		this.itemsInStore.add(media);
		System.out.println("Item added.");
	}
	
	public String removeMedia(Media media) {
		String warning = "";
		if (this.itemsInStore.remove(media)) {
			System.out.println("Item removed.");
		} else {
			warning = "Item doesn't exist.";
			System.out.println(warning);
		}
		return warning;
	}
	
	public void print() {
		System.out.print("[");
		int lastindex = this.itemsInStore.size() - 1;
        for (int i = 0; i <= lastindex; i++) {
            System.out.print(this.itemsInStore.get(i).getTitle() + (i == lastindex ? "" : ", "));
        }
        System.out.println("]");
	}
}
