package application;

import java.io.IOException;

import exception.InvalidSourceException;
import exception.LoggerFX;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * 
 * Klasse zur Darstellung eines Card Layouts.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class MainSceneBuilder extends Application
{

   /**
    * 
    * Startet die JavaFX-Runtime.
    *
    * @param args Keine Verwendung.
    */
   public static void main(String[] args)
   {
      launch(args);
   }

   /**
    * Wird durch JavaFX-Runtime nach dem Aufruf der init-Methode aufgerufen.
    * Initialisert die primaryStage mithilfe des FXMLLoaders mit der CardBorderPane.fxml
    */
   @Override
   public void start(Stage primaryStage) throws InvalidSourceException
   {
      try
      {
         if(primaryStage == null) 
         {
            throw new InvalidSourceException("MainSceneBuilder.start(Stage primaryStage): Ungültige Null-Referenz zu PrimaryStage!");
         }

         BorderPane root = (BorderPane) FXMLLoader.load(MainSceneBuilder.class.getResource("/CardBorderPane.fxml"));
         Scene scene = new Scene(root);
         scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
         primaryStage.setScene(scene);
         primaryStage.show();

      }
      catch (InvalidSourceException | IOException e)
      {
         Alert alert =
               new Alert(AlertType.ERROR, "Unbekannter Fehler \nSenden Sie den Log an den Entwickler!", ButtonType.OK);
         alert.setResizable(true);
         alert.showAndWait();
         LoggerFX.log(e, getClass().getSimpleName());
      }
   }
}