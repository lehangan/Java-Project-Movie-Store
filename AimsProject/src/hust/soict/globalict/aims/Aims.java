package AimsProject.src.hust.soict.globalict.aims;

import java.util.Scanner;

import AimsProject.src.hust.soict.globalict.aims.cart.Cart;
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
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
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
    }

    public static void filterCartOptions() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media by ID");
        System.out.println("2. Filter media by title");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 1-2");
    }

    public static void sortCartOptions() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Sort media by title");
        System.out.println("2. Sort media by cost");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 1-2");
    }
    public static void main(String[] args) {
        int input;
        showMenu();
        Scanner keyboard = new Scanner(System.in);
        input = keyboard.nextInt();
        if( input == 1 ) {
            storeMenu();
            String title = keyboard.next();
            
        }
    }
}
