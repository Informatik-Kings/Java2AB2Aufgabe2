package application;

import java.io.File;
import java.io.PrintStream;

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
   public void start(Stage primaryStage) throws Exception
   {
      try
      {
         if(primaryStage == null) 
         {
            throw new NullPointerException("MainPureJavaFX.start(Stage primaryStage): Ungültige Null-Referenz zu PrimaryStage!");
         }

         BorderPane root = new CardBorderPane();
         Scene scene = new Scene(root,600,300);
         primaryStage.setTitle("Card Layout");
         primaryStage.setScene(scene);
         primaryStage.show();

      }
      catch (Exception e)
      {
         Alert alert =
               new Alert(AlertType.ERROR, e.getMessage(), ButtonType.OK);
         alert.setResizable(true);
         alert.showAndWait();
         try 
         {
            String logFile = System.getProperty("user.home") +
                  File.separatorChar + getClass().getSimpleName() + ".log";
            e.printStackTrace(new PrintStream(logFile));
            alert.setAlertType(AlertType.INFORMATION);
            alert.setContentText("Log-Datei unter " + logFile + " erstellt!");
            alert.showAndWait();
         }
         catch(Exception e1)
         {
            alert.setContentText("Fehler beim Erstellen der Log-Datei!");
            alert.showAndWait();
         }
      }
   }
}