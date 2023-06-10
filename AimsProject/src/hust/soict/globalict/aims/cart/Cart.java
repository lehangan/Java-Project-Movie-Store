package AimsProject.src.hust.soict.globalict.aims.cart;

import AimsProject.src.hust.soict.globalict.aims.media.Media;
import AimsProject.src.hust.soict.globalict.aims.media.MediaComparatorByCostTitle;
import AimsProject.src.hust.soict.globalict.aims.media.MediaComparatorByTitleCost;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private float totalCost = 0f;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media> ();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();

    public boolean isFulled() {
        if (itemsOrdered.size() == MAX_NUMBERS_ORDERED)
            return true;
        else
            return false;
    }

    public void addMedia(Media[] medias) {
        if (isFulled())
            System.out.println("The Cart is almost full");
        for (Media i:medias){
            itemsOrdered.add(i);
            if (isFulled()){
                System.out.println("The Cart almost full");
                break;
            }
        }
    }

    public void addMedia(Media media1, Media media2){
        if (isFulled())
            System.out.println("The Cart is almost full");
        itemsOrdered.add(media1);
        if (isFulled())
            System.out.println("The Cart is full, can't input media 2");
        itemsOrdered.add(media2);
        System.out.println("2 media have been added");
    }

    public void addMedia(Media media) {
        if (isFulled())
            System.out.println("The Cart is almost full");
        itemsOrdered.add(media);
        System.out.println("The media has been added");
    }

    public void removeMedia(Media media) {
         if(itemsOrdered.remove(media)) {
            System.out.println("The media has been removed");
        } else System.out.println("Not have this media");
    }

    public float getTotalCost() {
        for (Media i: itemsOrdered) {
            totalCost += i.getCost();
        }
        return totalCost;
    }

    public void sortByTitleCost(){
        Collections.sort( itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle(){
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }


    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (Media i:itemsOrdered) {
            System.out.println( i.getId() + 1 + ".Media - " + itemsOrdered.toString());
        }
        System.out.println("Total cost: " + getTotalCost());
        System.out.println("***************************************************");
    }

    public void search(int id){
        for( Media i : itemsOrdered ){
            if( i.getId() == id) {
                System.out.println( "Found: " + i.toString());
                return;
            }
        }
        System.out.println("Media not found");
    }

    public void search(String title) {
		int count = 0;
        for (Media i: itemsOrdered) {
        	if (i.isMatch(title)) {
        		System.out.println("Found: " + i.toString());
        		count += 1;
        	}
        }
        if (count == 0) {
        	System.out.println("Media not found.");    	
        }
	}

}
