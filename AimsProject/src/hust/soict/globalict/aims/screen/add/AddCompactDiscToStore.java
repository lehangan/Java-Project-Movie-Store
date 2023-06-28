package AimsProject.src.hust.soict.globalict.aims.screen.add;

import AimsProject.src.hust.soict.globalict.aims.media.CompactDisc;
import AimsProject.src.hust.soict.globalict.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class AddCompactDiscToStore {
    private Store store;

    public void setStore(Store store) {
        this.store = store;
    }

    @FXML
    private TextField fieldArtist;

    @FXML
    private TextField fieldCategory;

    @FXML
    private TextField fieldTitle;

    @FXML
    private Spinner<Double> spinnerCost;

    @FXML
    void addCD(ActionEvent event) {
        CompactDisc newCD = new CompactDisc(
                fieldTitle.getText(),
                fieldCategory.getText(),
                spinnerCost.getValue().floatValue());

        store.addMedia(newCD);
    }
}
