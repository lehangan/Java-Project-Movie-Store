package AimsProject.src.hust.soict.globalict.aims.store;

import java.util.ArrayList;
import java.util.List;

import AimsProject.src.hust.soict.globalict.aims.exception.PlayerException;
import AimsProject.src.hust.soict.globalict.aims.media.Media;
import AimsProject.src.hust.soict.globalict.aims.media.Playable;

public class Store {
    private List<Media> itemsInStore = new ArrayList<Media>();
	
    public List<Media> getItemsInStore(){
        return this.itemsInStore;
    }
	public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("The media has been added");
    }
	
	public void removeMedia(Media media) {
         if(itemsInStore.remove(media)) {
            System.out.println("The media has been removed");
        } else System.out.println("Not have this media in store");
    }

    public Media search(int id) {
        for (Media i : itemsInStore) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    public Media search(String title) {
        for (Media i : itemsInStore) {
            if (i.getTitle().equals(title)) {
                return i;
            }
        }
        return null;
    }

     public void play(Media m) throws PlayerException{
        if (m != null && m instanceof Playable) {
                Playable playable = (Playable) m;
                playable.play();
            } else {
                System.out.println("Media can be played.");
            }
    }
	
}
