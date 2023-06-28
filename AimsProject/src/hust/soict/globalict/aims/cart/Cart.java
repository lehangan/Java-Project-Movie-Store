package AimsProject.src.hust.soict.globalict.aims.cart;

import AimsProject.src.hust.soict.globalict.aims.exception.PlayerException;
import AimsProject.src.hust.soict.globalict.aims.media.Media;
import AimsProject.src.hust.soict.globalict.aims.media.MediaComparatorByCostTitle;
import AimsProject.src.hust.soict.globalict.aims.media.MediaComparatorByTitleCost;
import AimsProject.src.hust.soict.globalict.aims.media.Playable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;
import java.util.Comparator;

import javax.naming.LimitExceededException;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private float totalCost = 0f;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();

    public ObservableList<Media> getItemsOrdered() {
        return this.itemsOrdered;
    }

    public boolean isFulled() {
        if (itemsOrdered.size() == MAX_NUMBERS_ORDERED)
            return true;
        else
            return false;
    }

    public void addMedia(Media[] medias) throws LimitExceededException {
        if (isFulled())
            throw new LimitExceededException("ERROR: The number of media has reached its limit");
        for (Media i : medias) {
            itemsOrdered.add(i);
            if (isFulled()) {
                throw new LimitExceededException("ERROR: The number of media has reached its limit");
            }
        }
    }

    public void addMedia(Media media1, Media media2) throws LimitExceededException {
        if (!isFulled()) {
            itemsOrdered.add(media1);
            if (!isFulled()) {
                itemsOrdered.add(media2);
            } else
                throw new LimitExceededException("ERROR: The number of media has reached its limit");
        } else {
            throw new LimitExceededException("ERROR: The number of media has reached its limit");
        }
    }

    public void addMedia(Media media) throws LimitExceededException {
        if (!isFulled()) {
            itemsOrdered.add(media);
        } else {
            throw new LimitExceededException("ERROR: The number of media has reached its limit");

        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("The media has been removed");
        } else
            System.out.println("Not have this media");
    }

    public float getTotalCost() {
        for (Media i : itemsOrdered) {
            totalCost += i.getCost();
        }
        return totalCost;
    }

    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (Media i : itemsOrdered) {
            System.out.println(i.getId() + 1 + ".Media - " + itemsOrdered.toString());
        }
        System.out.println("Total cost: " + getTotalCost());
        System.out.println("***************************************************");
    }

    public Media search(int id) {
        for (Media i : itemsOrdered) {
            if (i.getId() == id) {
                System.out.println("Found: " + i.toString());
                return i;
            }
        }
        System.out.println("Media not found");
        return null;
    }

    public Media search(String title) {
        for (Media i : itemsOrdered) {
            if (i.getTitle().equals(title)) {
                System.out.println("Found: " + i.toString());
                return i;
            }
        }
        System.out.println("Media not found.");
        return null;
    }

    public void placeOrder() {
        System.out.println("PLACE ORDER");
        System.out.println("-----------------------------------");
        itemsOrdered.clear();
        System.out.println("Thank you for your purchase!");
    }

    public int nbItem() {
        return itemsOrdered.size();
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
