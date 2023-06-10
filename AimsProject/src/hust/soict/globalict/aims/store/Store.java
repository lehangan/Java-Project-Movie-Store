package AimsProject.src.hust.soict.globalict.aims.store;

import java.util.ArrayList;
import java.util.List;

import AimsProject.src.hust.soict.globalict.aims.media.Media;

public class Store {
    private List<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("The media has been added");
    }
	
	public void removeMedia(Media media) {
         if(itemsInStore.remove(media)) {
            System.out.println("The media has been removed");
        } else System.out.println("Not have this media in store");
    }
	
}
