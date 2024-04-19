package application;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import exception.InvalidSourceException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * 
 * TODO Comment
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class MyApp extends Application
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
    * TODO Comment
    */
   @Override
   public void start(Stage primaryStage) throws Exception
   {
      try
      {
         if(primaryStage == null) 
         {
            throw new NullPointerException("MyApp.start(Stage PrimaryStage): Ungültige Null-Referenz zu PrimaryStage!");
         }

         BorderPane root = (BorderPane) FXMLLoader.load(MyApp.class.getResource("/CardBorderPane.fxml"));
         Scene scene = new Scene(root);
         scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
         primaryStage.setScene(scene);
         primaryStage.show();

      }

      catch (Exception e)
      {
         Alert alert =
               new Alert(AlertType.ERROR, "Unbekannter Fehler!", ButtonType.OK);
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