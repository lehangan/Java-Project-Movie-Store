package AimsProject.src.hust.soict.globalict.aims.store;

import AimsProject.src.hust.soict.globalict.aims.media.DigitalVideoDisc;

public class Store {
    public static final int MAX_NUMBERS_STORE = 1000001;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_STORE];
    private int qtyStore = 0;

    public int getQtyStore(){
        return this.qtyStore;
    }

    public void addDVD(DigitalVideoDisc disc) {
        if (qtyStore == MAX_NUMBERS_STORE)
            System.out.println("The Store is almost full");
        itemsInStore[qtyStore] = disc;
        qtyStore++;
        System.out.println("The disc has been added to store");
    }

    public void removeDVD(DigitalVideoDisc disc){
        int index = -1;
        for (int i = 0; i < qtyStore; i++)
            if (itemsInStore[i] == disc)
                index = i;
        if (index == -1) {
            System.out.println("Can't find the disc in the store");
        } else {
            qtyStore--;
            for (int i = index; i < qtyStore; i++) {
                itemsInStore[i] = itemsInStore[i + 1];
            }
        }
        System.out.println("The disc has been removed in store");
    }

}
