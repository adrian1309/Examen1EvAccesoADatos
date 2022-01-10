package main;

import fx.controllers.FXMLQuery1Controller;
import fx.controllers.FXMLQuery4Controller;
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
public class Main4 extends Application implements Initializable {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loaderMenu = new FXMLLoader(
                getClass().getResource("/fxml/FXMLQuery4.fxml"));
        AnchorPane root = loaderMenu.load();



        Scene scene = new Scene(root);
        primaryStage.setTitle("Query4");
        primaryStage.setScene(scene);
        primaryStage.show();
        //para no poder maximizar pantalla y
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }

    private AnchorPane query4;
    private FXMLQuery4Controller query4Controller;

    public void preloadQuery4() {
        try {
            FXMLLoader loaderMenu = new FXMLLoader(
                    getClass().getResource(
                            "/fxml/FXMLQuery4.fxml"));
            query4 = loaderMenu.load();
            query4Controller = loaderMenu.getController();
            query4Controller.setPrincipal(this);
        } catch (IOException ex) {
            Logger.getLogger(Main4.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        preloadQuery4();
    }
}
