package AimsProject.src.hust.soict.globalict.aims;

import java.util.Scanner;

import AimsProject.src.hust.soict.globalict.aims.cart.Cart;
import AimsProject.src.hust.soict.globalict.aims.media.Book;
import AimsProject.src.hust.soict.globalict.aims.media.CompactDisc;
import AimsProject.src.hust.soict.globalict.aims.media.DigitalVideoDisc;
import AimsProject.src.hust.soict.globalict.aims.media.Media;
import AimsProject.src.hust.soict.globalict.aims.media.Playable;
import AimsProject.src.hust.soict.globalict.aims.store.Store;

public class Aims {
    public static Cart cart = new Cart();
    public static Store store = new Store();

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
        Scanner keyboard = new Scanner(System.in);
        int input = keyboard.nextInt();
        if (input == 1) {
            storeMenu();
        } else if (input == 2) {
            updateStoreOptions();
        } else if (input == 3) {
            cartMenu();
        } else if (input == 0) {
            System.out.println("Exit");
        } else {
            System.out.println("Please choose a number: 0-1-2-3");
            showMenu();
        }
        keyboard.close();
    }

    public static void updateStoreOptions() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        Book book1 = new Book("The Father", "Drama", 97);
        CompactDisc cd1 = new CompactDisc("La La Land ", "Romance, Musical", 19.66f);

        System.out.println("UPDATE STORE MENU OPTIONS:");
        System.out.println("-----------------------------------");
        System.out.println("1.Add a Media");
        System.out.println("2.Remove a Media");
        System.out.println("0.Back");
        System.out.println("------------------------------------");
        System.out.println("Please choose number: 0-1-2");
        Scanner keyboard = new Scanner(System.in);
        int input = keyboard.nextInt();
        if (input == 1) {
            store.addMedia(dvd1);
            store.addMedia(dvd2);
            store.addMedia(cd1);
            store.addMedia(book1);
            updateStoreOptions();
        } else if (input == 2) {
            store.removeMedia(cd1);
            updateStoreOptions();
        } else if (input == 0) {
            System.out.println("Back");
            showMenu();
        } else {
            System.out.println("Please choose a number: 0-1-2");
            updateStoreOptions();
        }
        keyboard.close();
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
        Scanner keyboard = new Scanner(System.in);
        int input = keyboard.nextInt();
        if (input == 1) {
            System.out.println("Enter the title of the media");
            String title = keyboard.next();
            Media m = store.search(title);
            if (m != null) {
                System.out.println("Information: " + m.toString());
                mediaDetailsMenu(m);
            } else {
                System.out.println("Media not found");
            }
        } else if (input == 2) {
            System.out.println("Enter the title of the media");
            String title = keyboard.next();
            Media m = store.search(title);
            if (m != null) {
                System.out.println("Information: " + m.toString());
                cart.addMedia(m);
                System.out.println("item added successfully");
                System.out.println("number of Medias in  current card: " + cart.nbItem());
            } else {
                System.out.println("Media not found");
            }
        } else if (input == 3) {
            System.out.println("Enter the title of the media");
            String title = keyboard.next();
            Media m = store.search(title);
            store.play(m);
        } else if (input == 4) {
            cart.print();
        } else if (input == 0) {
            System.out.println("Back");
            showMenu();
        } else {
            System.out.println("Please choose a number: 0-1-2-3-4");
            storeMenu();
        }
        keyboard.close();
    }

    public static void mediaDetailsMenu(Media m) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        Scanner keyboard = new Scanner(System.in);
        int input = keyboard.nextInt();
        if (input == 1) {
            cart.addMedia(m);
            storeMenu();
        } else if (input == 2) {
            store.play(m);
            mediaDetailsMenu(m);
        } else if (input == 0) {
            System.out.println("Back");
            storeMenu();
        } else {
            System.out.println("Please choose a number: 0-1-2");
            mediaDetailsMenu(m);
        }
        keyboard.close();
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
        Scanner keyboard = new Scanner(System.in);
        int input = keyboard.nextInt();
        if (input == 1) {
            filterCartOptions();
        } else if (input == 2) {
            sortCartOptions();
        } else if (input == 3) {
            DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
            cart.removeMedia(dvd1);
            cartMenu();
        } else if (input == 4) {
            playMediaMenuCart();
            System.out.println("End play media");
            cartMenu();
        } else if (input == 5) {
            cart.placeOrder();
            System.out.println("Place odered successfully");
        } else if (input == 0) {
            System.out.println("Exit");
        } else {
            System.out.println("Please choose a number: 0-1-2-3");
            showMenu();
        }
        keyboard.close();
    }

    public static void playMediaMenuCart() {
        System.out.println("PLAY MEDIA MENU CART");
        System.out.println("Options: ");
        System.out.println("---------------------------------");
        System.out.println("1. Search media by title");
        System.out.println("2. Search media by id");
        System.out.println("0. Back");
        System.out.println("---------------------------------");
        Scanner keyboard = new Scanner(System.in);
        int input = keyboard.nextInt();
        if (input == 1) {
            String title = keyboard.next();
            Media m = cart.search(title);
            if (m != null && m instanceof Playable) {
                Playable playable = (Playable) m;
                playable.play();
            } else {
                System.out.println("Media not found or not playable.");
            }
            playMediaMenuCart();
        } else if (input == 2) {
            int id = keyboard.nextInt();
            Media m = cart.search(id);
            if (m != null && m instanceof Playable) {
                Playable playable = (Playable) m;
                playable.play();
            } else {
                System.out.println("Media not found or not playable.");
            }
            playMediaMenuCart();
        } else if (input == 0) {
            System.out.println("Exit");
        } else {
            System.out.println("Please choose a number: 0-1-2");
            playMediaMenuCart();
        }
        keyboard.close();
    }

    public static void filterCartOptions() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media by ID");
        System.out.println("2. Filter media by title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        Scanner keyboard = new Scanner(System.in);
        int input = keyboard.nextInt();
        if (input == 1) {
            System.out.println("Enter id:");
            int id = keyboard.nextInt();
            Media m = cart.search(id);
            if (m != null)
                System.out.println("Found: " + m.toString());
            else
                System.out.println("Media not found");
        } else if (input == 2) {
            System.out.println("Enter title:");
            String title = keyboard.next();
            Media m = cart.search(title);
            if (m != null)
                System.out.println("Found: " + m.toString());
            else
                System.out.println("Media not found");
        } else if (input == 0) {
            System.out.println("Back");
            cartMenu();
        } else {
            System.out.println("Please choose a number: 0-1-2");
            filterCartOptions();
        }
        keyboard.close();
    }

    public static void sortCartOptions() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Sort media by title");
        System.out.println("2. Sort media by cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 1-2");
        Scanner keyboard = new Scanner(System.in);
        int input = keyboard.nextInt();
        if (input == 1) {
            cart.sortByTitleCost();
            System.out.println("Sorted  by title successfully");
        } else if (input == 2) {
            cart.sortByCostTitle();
            System.out.println("Sorted  by cost successfully");
        } else if (input == 0) {
            System.out.println("Back");
            cartMenu();
        } else {
            System.out.println("Please choose a number: 0-1-2");
            sortCartOptions();
        }
        keyboard.close();
    }

    public static void main(String[] args) {
        DigitalVideoDisc media1 = new DigitalVideoDisc("Avatar", "Science Fiction", "James Cameron", 192, 12.44f);
		DigitalVideoDisc media2 = new DigitalVideoDisc("Avatar: Way of the Water", "Science Fiction", "James Cameron", 27.98f);
		DigitalVideoDisc media3= new DigitalVideoDisc("Top Gun: Maverick", "Action", 22.25f);
        CompactDisc media4 = new CompactDisc("Uncharted", "Adventure", 25.85f);
		CompactDisc media5 = new CompactDisc("Judas and the Black Messiah", "Crime", 45.98f);
		Book media6 = new Book("CODA", "Comedy", 38.25f);
	    Book media7 = new Book("Cruella", "Crime", 35.55f);
		Book media8 = new Book("Parasite", "Thriller", 19.42f);
        store.addMedia(media1);
        store.addMedia(media2);
        store.addMedia(media3);
        store.addMedia(media4);
        store.addMedia(media5);
        store.addMedia(media6);
        store.addMedia(media7);
        store.addMedia(media8);
        //System.out.println(store.search("Avatar"));
        showMenu();
    }
}
