package AimsProject.src.hust.soict.globalict.aims.screen.add;

import AimsProject.src.hust.soict.globalict.aims.media.DigitalVideoDisc;
import AimsProject.src.hust.soict.globalict.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class AddDigitalVideoDiscToStoreScreenController {
    private Store store;

    public void setStore(Store store) {
        this.store = store;
    }

    @FXML
    private TextField fieldCategory;

    @FXML
    private TextField fieldDirector;

    @FXML
    private TextField fieldTitle;

    @FXML
    private Label labelLength;

    @FXML
    private Slider sliderLength;

    @FXML
    private Spinner<Double> spinnerCost;

    @FXML
    void addDVD(ActionEvent event) {
        store.addMedia(new DigitalVideoDisc(
                fieldTitle.getText(),
                fieldCategory.getText(),
                fieldDirector.getText(),
                (int) sliderLength.getValue(),
                spinnerCost.getValue().floatValue()));
    }

}
