package AimsProject.src.hust.soict.globalict.aims.store;

import AimsProject.src.hust.soict.globalict.aims.media.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args){
    Store store = new Store();

    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King" , "Animation" , "Roger Allers",87, 19.95f);
    store.addDVD(dvd1);
    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars" , "Science Fiction" , "George Lucas",87, 24.95f);
    store.addDVD(dvd2);

    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin" , "Animation", 18.995f);
    store.addDVD(dvd3);

    store.removeDVD(dvd1);
    System.out.println(store.getQtyStore());
    }
    
}
