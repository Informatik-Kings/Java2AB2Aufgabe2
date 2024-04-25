package application;

import java.io.File;
import java.io.PrintStream;

import exception.*;
import javafx.application.Application;
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
public class MainPureJavaFX extends Application
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
    * Initialisert die primaryStage mit einer {@link CardBorderPane}
    */
   @Override
   public void start(Stage primaryStage) throws InvalidSourceException
   {
      try
      {
         //primaryStage = null; //Zu testzwecken
         if(primaryStage == null) 
         {
            throw new InvalidSourceException("MainPureJavaFX.start(Stage primaryStage): Ungültige Null-Referenz zu PrimaryStage!");
         }

         BorderPane root = new CardBorderPane();
         Scene scene = new Scene(root,600,300);
         primaryStage.setTitle("Card Layout");
         primaryStage.setScene(scene);
         primaryStage.show();

      }
      catch (InvalidSourceException e)
      {
         Alert alert =
               new Alert(AlertType.ERROR, "Unbekannter Fehler \nSenden Sie den Log an den Entwickler!", ButtonType.OK);
         alert.setResizable(true);
         alert.showAndWait();
         LoggerFX.log(e, getClass().getSimpleName());
      }
   }
}