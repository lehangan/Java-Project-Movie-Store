package AimsProject.src.hust.soict.globalict.aims.screen;

import AimsProject.src.hust.soict.globalict.aims.media.Media;
import AimsProject.src.hust.soict.globalict.aims.media.Playable;

import javax.naming.LimitExceededException;

import AimsProject.src.hust.soict.globalict.aims.cart.Cart;
import AimsProject.src.hust.soict.globalict.aims.exception.PlayerException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class CartScreenController {
    private Cart cart;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TextField tfFilter;

    @FXML
    private Label totalCost;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        int cost = 0;
        for (Media m : cart.getItemsOrdered()) {
            cost += m.getCost();
        }
        totalCost.setText(cost + "$");
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                        if (newValue != null) {
                            updateButtonBar(newValue);
                        }
                    }

                    void updateButtonBar(Media media) {
                        btnRemove.setVisible(true);
                        if (media instanceof Playable) {
                            btnPlay.setVisible(true);
                        } else {
                            btnPlay.setVisible(false);
                        }
                    }
                });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }

            void showFilteredMedia(String value) {
                boolean filterById = radioBtnFilterId.isSelected();
                boolean filterByTitle = radioBtnFilterTitle.isSelected();
                // Create a FilteredList based on the original media list
                FilteredList<Media> filteredList = new FilteredList<>(cart.getItemsOrdered());

                filteredList.setPredicate(media -> {
                    if (value.isEmpty()) {
                        return true;
                    } else if (filterById) {
                        // Filter by ID
                        return String.valueOf(media.getId()).contains(value);
                    } else if (filterByTitle) {
                        // Filter by title
                        return media.getTitle().contains(value);
                    }
                    return false;
                });
                tblMedia.setItems(filteredList);

            }
        });
        totalCost.setText(cart.getTotalCost() + " $");
        
    }

    public void changeTotalCost() {
        totalCost.setText(cart.getTotalCost() + " $");
    }

    @FXML
    void btnRemovePressed(ActionEvent e) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
        totalCost.setText(cart.getTotalCost() + " $");
        // Note that we don’t need to invoke an update for the TableView because the it
        // can already observe the
        // changes though the ObservableList and update its display
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        try {
            ((Playable) media).play();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Media Player");
            alert.setHeaderText("Media: " + media.getTitle());
            alert.setContentText("Playing...");
            alert.showAndWait();
        } catch (PlayerException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void btnPlaceOrder() {
        Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Placing order");
		alert.setHeaderText(cart.getTotalCost() + " $");
		alert.setContentText("Your total is " + cart.getTotalCost() + " $. Please pay in cash.");

		alert.showAndWait();
    }
}