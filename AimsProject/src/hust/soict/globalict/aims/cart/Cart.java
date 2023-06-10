package AimsProject.src.hust.soict.globalict.aims.cart;

import AimsProject.src.hust.soict.globalict.aims.media.Media;

import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private float totalCost = 0f;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media> ();

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
        System.out.println("The disc has been added");
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

    // public void print() {
    //     System.out.println("***********************CART***********************");
    //     System.out.println("Ordered Items:");
    //     for (int i = 0; i < qtyOrdered; i++) {
    //         System.out.println(i + 1 + ".DVD - " + itemsOrdered[i].toString());
    //         // System.out.println( i+1 + ".DVD - " + itemsOrdered[i].getTitle() + " - " +
    //         // itemsOrdered[i].getCategory() + " - " +itemsOrdered[i].getDirector()+" - "
    //         // +itemsOrdered[i].getLength()+":" + itemsOrdered[i].getCost()+"$");
    //     }
    //     System.out.println("Total cost: " + getTotalCost());
    //     System.out.println("***************************************************");
    // }

    // public void search(int id){
    //     int index = -1;
    //     for( int i = 0 ;i<qtyOrdered ; i++)
    //         if( itemsOrdered[i].getId() == id){
    //             index = i;
    //         }
    //     if(index == -1){
    //         System.out.println("Can't find the disc have " + id +" id");
    //     }
    //     else{
    //         System.out.println(itemsOrdered[index].toString());
    //     }
    // }

    // public void search(String title){
    //     int index = -1;
    //     for( int i = 0 ;i<qtyOrdered ; i++)
    //         if( itemsOrdered[i].isMatch(title)){
    //             index = i;
    //         }
    //     if(index == -1){
    //         System.out.println("Can't find the disc have " + title +" title");
    //     }
    //     else{
    //         System.out.println(itemsOrdered[index].toString());
    //     }
    // }



}
