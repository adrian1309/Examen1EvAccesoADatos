package main;

import fx.controllers.FXMLQuery1Controller;
import fx.controllers.FXMLQuery6Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

@Getter
public class Main6 extends Application implements Initializable {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loaderMenu = new FXMLLoader(
                getClass().getResource("/fxml/FXMLQuery6.fxml"));
        AnchorPane root = loaderMenu.load();



        Scene scene = new Scene(root);
        primaryStage.setTitle("Query6");
        primaryStage.setScene(scene);
        primaryStage.show();
        //para no poder maximizar pantalla y
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }

    private AnchorPane query6;
    private FXMLQuery6Controller query6Controller;

    public void preloadQuery6() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/FXMLQuery6.fxml"));
            query6 = loaderMenu.load();
            query6Controller = loaderMenu.getController();
            query6Controller.setPrincipal(this);
        } catch (IOException ex) {
            Logger.getLogger(Main6.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        preloadQuery6();
    }
}
