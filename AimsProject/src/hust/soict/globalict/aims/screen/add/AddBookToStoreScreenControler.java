package AimsProject.src.hust.soict.globalict.aims.screen.add;

import AimsProject.src.hust.soict.globalict.aims.media.Book;
import AimsProject.src.hust.soict.globalict.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
public class AddBookToStoreScreenControler {

    private Store store;
	
    public void setStore(Store store) {
		this.store = store;
	}
    @FXML
    private TextField fieldAuthors;

    @FXML
    private TextField fieldCategory;

    @FXML
    private TextField fieldTitle;

    @FXML
    private Spinner<Double> spinnerCost;

    @FXML
    void addBook(ActionEvent event) {
        Book newBook = new Book(
    		fieldTitle.getText(),	
    		fieldCategory.getText(),		
    		spinnerCost.getValue().floatValue()
		);
        store.addMedia(newBook);
        Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Added book");
		alert.setHeaderText(null);
		alert.setContentText("The book " + fieldTitle.getText() + " was added!");
		alert.showAndWait();
		
		
		fieldTitle.clear();	
		fieldCategory.clear();		
		fieldAuthors.clear(); 
		spinnerCost.getValueFactory().setValue(0.0);
    }
    @FXML
    void initialize() {	
    	
    }
}
