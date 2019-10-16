package br.ufba.team3.siac;


import br.ufba.team3.siac.model.Universidade;
import br.ufba.team3.siac.database.UniversidadeService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(Paths.get("./src/main/resources/view/home.fxml").toUri().toURL());
        Parent root = loader.load();
        primaryStage.setTitle("New Siac");
        primaryStage.setMaximized(true);
        primaryStage.setScene(new Scene(root, 500, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        try{
            UniversidadeService universidadeService = new UniversidadeService();
            universidadeService.Leitura();
            System.out.println(universidadeService.getAllCursos());
        } catch (Exception e) {
            e.printStackTrace();
        }
        launch(args);
    }
}
