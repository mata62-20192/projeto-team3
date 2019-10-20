package br.ufba.team3.siac;


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

    static UniversidadeService universidadeService = new UniversidadeService();

    public static void main(String[] args) {
        try {
            universidadeService.Leitura();
        } catch (Exception e) {
            e.printStackTrace();
        }
        launch(args);
    }

    public static List<Curso> getAllCursos() {
        return universidadeService.getAllCursos();
    }

    public static Curso findCurso(String codigo){
        return universidadeService.findCurso(codigo);
    }

    public static Aluno findAluno(String matricula){
        return universidadeService.findAluno(matricula);
    }

    public static void addAluno(String nome, String matricula, String senha, Curso curso){
        universidadeService.addAluno(nome, matricula, senha, curso);
    }

    public static Universidade getUniversidade(){
        return universidadeService.getUniversidade();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Paths.get("./src/main/resources/view/main.fxml").toUri().toURL());
        Parent root = loader.load();
        primaryStage.setTitle("New Siac");
        primaryStage.setMaximized(true);
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(600);
        primaryStage.setScene(new Scene(root, 500, 600));
        primaryStage.show();
    }
}
