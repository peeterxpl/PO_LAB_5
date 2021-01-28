package exceptionsTest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class Controller {

    double a, b, c;
    
    @FXML
    private TextField polea, poleb, polec;

    @FXML
    private Button licz;

    @FXML
    private Label wynik;

    @FXML
    public void liczenie(ActionEvent event) {
        try {
            a = Double.parseDouble(polea.getText());
            b = Double.parseDouble(poleb.getText());
            c = Double.parseDouble(polec.getText());
            double delta = (b*b) - (4*a*c);
            if (delta < 0) {
                throw new DeltaMniejZero();
            }
            wynik.setText("Delta = "+ delta);
        } catch (DeltaMniejZero deltamniejszaodzero) {
            Alert zero = new Alert(Alert.AlertType.ERROR);
            zero.setTitle("Coś poszło nie tak!");
            zero.setHeaderText("Delta mniejsza od zero");
            zero.setContentText("Wprowadź inne wartości!");
            zero.showAndWait();

        } catch (Exception e) {
            wynik.setText("Wartości nie są liczbami!");
        }
    }



}
