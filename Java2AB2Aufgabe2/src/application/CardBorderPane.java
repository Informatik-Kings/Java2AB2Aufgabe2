package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * Erstellt eine CardBorderPane mithilfe von Stackpanes, Buttons und Lazy Instantiation von Labels.
 * Mithilfe der Buttons kann zwischen den Labels der Stackpane gewechsel werden.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class CardBorderPane extends BorderPane
{

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
         if(stackPane == null) {
            throw new NullPointerException("Listener(StackPane stackPane, String text): Ungültige Null-Referenz zu stackPane!");
         }
         if(text == null) {
            throw new NullPointerException("Listener(StackPane stackPane, String text): Ungültige Null-Referenz zu text!");
         }    
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

   /**
    * 
    * Erstellt ein das CardBorderPane mit drei Buttons und eigenen Handlern
    *
    */
   public CardBorderPane()
   {
      VBox vbox = new VBox();
      StackPane stackPane = new StackPane();

      Button button = new Button("Button 1");
      button.setOnAction(new Listener(stackPane,"Knopf 1"));
      vbox.getChildren().add(button);
      button.fire(); //button1 wird gefeuert, damit das passende Label auf der Stackpane sichtbar ist.

      button = new Button("Button 2");
      button.setOnAction(new Listener(stackPane,"Knopf 2"));
      vbox.getChildren().add(button);

      button = new Button("Button 3");
      button.setOnAction(new Listener(stackPane,"Knopf 3"));
      vbox.getChildren().add(button);

      this.setLeft(vbox);
      this.setCenter(stackPane);

   }

}
