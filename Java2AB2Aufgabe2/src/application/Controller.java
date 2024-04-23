/**
 * Sample Skeleton for 'CardBorderPane.fxml' Controller Class
 */

package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

/**
 * 
 * Controller zuständig für die CardBorderPane.fxml
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class Controller {
   
      
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="button1"
    private Button button1; // Value injected by FXMLLoader

    @FXML // fx:id="button2"
    private Button button2; // Value injected by FXMLLoader

    @FXML // fx:id="button3"
    private Button button3; // Value injected by FXMLLoader

    @FXML // fx:id="stackPane"
    private StackPane stackPane; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert button1 != null : "fx:id=\"button1\" was not injected: check your FXML file 'CardBorderPane.fxml'.";
        assert button2 != null : "fx:id=\"button2\" was not injected: check your FXML file 'CardBorderPane.fxml'.";
        assert button3 != null : "fx:id=\"button3\" was not injected: check your FXML file 'CardBorderPane.fxml'.";
        assert stackPane != null : "fx:id=\"stackPane\" was not injected: check your FXML file 'CardBorderPane.fxml'.";
        button1.setOnAction(new ContentChangeEventHandler(stackPane,"Knopf 1"));
        button2.setOnAction(new ContentChangeEventHandler(stackPane,"Knopf 2"));
        button3.setOnAction(new ContentChangeEventHandler(stackPane,"Knopf 3"));
        button1.fire();
    }

}