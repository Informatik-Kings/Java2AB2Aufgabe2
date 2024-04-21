/**
 * Sample Skeleton for 'CardBorderPane.fxml' Controller Class
 */

package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.StackPane;

/**
 * 
 * Controller zuständig für die CardBorderPane.fxml
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class Controller {
   
   /**
    * Innere Klasse als EventHandler für die Knöpfe.
    *
    * Verwaltet die StackPane.
    *
    * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
    */
   public class Listener implements EventHandler<ActionEvent> {

      private StackPane pane;
      private Label label;
      private String text;

      /**
       * 
       * Konstruktor für den EventHandler.
       *
       * @param stackPane Auf welcher Stackpane die Elemente gekoppelt werden sollen.
       * @param text Text, welcher auf der Schicht angezeigt werden soll.
       */
      public Listener(StackPane stackPane, String text)
      {
         pane=stackPane;
         this.text = text;

      }

      /**
       * Eventhandler, welcher die Labels der Stackpane erzeugt und behandelt.
       */
      @Override
      public void handle(ActionEvent arg0)
      {
         try {
            if(!pane.getChildren().isEmpty())
               pane.getChildren().getLast().setVisible(false);

            if(pane.getChildren().contains(label))
            {
               pane.getChildren().remove(label);
            }
            else
            {
               label = new Label(text);
               label.setMinSize(200, 100);   
            }

            pane.getChildren().addLast(label);

            pane.getChildren().getLast().setVisible(true);



         }catch(Exception e)
         {
            Alert alert =
                  new Alert(AlertType.ERROR, "Fehler nach dem Drücken des Buttons", ButtonType.OK);
            alert.setResizable(true);
            alert.showAndWait();
         }

      }



   }
   
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
        Listener listener1 = new Listener(stackPane,"Knopf 1");
        button1.setOnAction(listener1);
        Listener listener2 = new Listener(stackPane,"Knopf 2");
        button2.setOnAction(listener2);
        Listener listener3 = new Listener(stackPane,"Knopf 3");
        button3.setOnAction(listener3);
        button1.fire();
    }

}