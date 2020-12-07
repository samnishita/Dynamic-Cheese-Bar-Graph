/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamiccheeseapp;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author samnishita
 */


//ONLY RUNS WITH JDK 1.8 (SOURCE/BINARY & PLATFORM AT 1.8)
//DOES NOT WORK WITH JAVA 14
public class DynamicApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
       
            Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/cheeseFXML3.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("The Rise and Fall of Cheese");
            stage.setResizable(false);
            stage.show();
        

    }

    public static void main(String[] args) {
        launch(args);
    }

}
