package application;

import exception.InvalidSourceException;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * Erstellt eine CardBorderPane mithilfe von Stackpanes, Buttons und Lazy
 * Instantiation von Labels. Mithilfe der Buttons kann zwischen den Labels der
 * Stackpane gewechsel werden.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class CardBorderPane extends BorderPane
{

   /**
    * 
    * Erstellt ein das CardBorderPane mit drei Buttons und eigenen Handlern
    * 
    * @throws InvalidSourceException
    *
    */
   public CardBorderPane() throws InvalidSourceException
   {
      VBox vbox = new VBox();
      StackPane stackPane = new StackPane();

      Button button = new Button("Button 1");
      button.setOnAction(new ContentChangeEventHandler(stackPane, "Knopf 1"));
      vbox.getChildren().add(button);
      button.fire(); // button1 wird gefeuert, damit das passende Label auf der Stackpane sichtbar ist.

      button = new Button("Button 2");
      button.setOnAction(new ContentChangeEventHandler(stackPane, "Knopf 2"));
      vbox.getChildren().add(button);

      button = new Button("Button 3");
      button.setOnAction(new ContentChangeEventHandler(stackPane, "Knopf 3"));
      vbox.getChildren().add(button);

      setLeft(vbox);
      setCenter(stackPane);
      
   }

}
