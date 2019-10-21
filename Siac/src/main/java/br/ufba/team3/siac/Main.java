package br.ufba.team3.siac;


import br.ufba.team3.siac.database.AlunoService;
import br.ufba.team3.siac.database.UniversidadeService;
import br.ufba.team3.siac.model.Aluno;
import br.ufba.team3.siac.model.Curso;
import br.ufba.team3.siac.model.Universidade;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.nio.file.Paths;
import java.util.List;

public class Main extends Application {

    private final static UniversidadeService universidadeService = new UniversidadeService();

    public static void main(String[] args) {
        try {
            universidadeService.Leitura();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            AlunoService alunoService = new AlunoService();
            alunoService.criarAlunos();
        }
        launch(args);
    }

    public static Universidade getUniversidade() {
        return universidadeService.getUniversidade();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Paths.get("./src/main/resources/view/main.fxml").toUri().toURL());
        Parent root = loader.load();
        primaryStage.setTitle("New Siac");
        primaryStage.setMaximized(true);
        primaryStage.setMinWidth(1000);
        primaryStage.setMinHeight(800);
        primaryStage.setScene(new Scene(root, 500, 600));
        primaryStage.show();
    }
}
