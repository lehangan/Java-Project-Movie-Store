package AimsProject.src.hust.soict.globalict.aims.screen;

import java.io.IOException;

import AimsProject.src.hust.soict.globalict.aims.cart.Cart;
import AimsProject.src.hust.soict.globalict.aims.media.Book;
import AimsProject.src.hust.soict.globalict.aims.media.CompactDisc;
import AimsProject.src.hust.soict.globalict.aims.media.DigitalVideoDisc;
import AimsProject.src.hust.soict.globalict.aims.store.Store;

import java.io.IOException;

import javax.naming.LimitExceededException;
import javax.swing.JFrame;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.*;

public class CartScreen extends JFrame {
	private Cart cart;

	public CartScreen (Cart cart) {
		super();

        this.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        // we set up a JFXPanel in our JFrame.
        this.add(fxPanel);
        this.setTitle("Cart");
        this.setVisible(true);

        Platform.runLater( new Runnable() {
            @Override
            public void run(){
                try{
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        });
	}

	public static void main(String[] args) throws LimitExceededException{
        Cart cart = new Cart();
        DigitalVideoDisc media1 = new DigitalVideoDisc("Avatar", "Science Fiction", "James Cameron", 192, 12.44f);
		DigitalVideoDisc media2 = new DigitalVideoDisc("Avatar: Way of the Water", "Science Fiction", "James Cameron", 27.98f);
		DigitalVideoDisc media3= new DigitalVideoDisc("Top Gun: Maverick", "Action", 22.25f);
        CompactDisc media4 = new CompactDisc("Uncharted", "Adventure", 25.85f);
		CompactDisc media5 = new CompactDisc("Judas and the Black Messiah", "Crime", 45.98f);
		Book media6 = new Book("CODA", "Comedy", 38.25f);
	    Book media7 = new Book("Cruella", "Crime", 35.55f);
		Book media8 = new Book("Parasite", "Thriller", 19.42f);
        cart.addMedia(media1);
		cart.addMedia(media2);
		cart.addMedia(media3);
		cart.addMedia(media4);
		cart.addMedia(media5);
		cart.addMedia(media6);
		cart.addMedia(media7);
		cart.addMedia(media8);
		new CartScreen(cart);
	}

}