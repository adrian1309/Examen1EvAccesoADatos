package main;

import fx.controllers.FXMLQuery1Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

@Getter
public class Main1 extends Application implements Initializable {
    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource("/fxml/FXMLQuery1.fxml"));
            AnchorPane root = loaderMenu.load();

            Scene scene = new Scene(root);
            primaryStage.setTitle("Query1");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            query1Controller = loaderMenu.getController();
            //query1Controller.loadListStudents();
            primaryStage.show();
        }catch (Exception ex){
            Logger.getLogger(Main1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    private AnchorPane query1;
    private FXMLQuery1Controller query1Controller;

    /*public void preloadQuery1() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/FXMLQuery1.fxml"));
            query1 = loaderMenu.load();
            query1Controller = loaderMenu.getController();
            query1Controller.loadListStudents();
            query1Controller.setPrincipal(this);
        } catch (IOException ex) {
            Logger.getLogger(Main1.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     */

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //preloadQuery1();
    }
}
