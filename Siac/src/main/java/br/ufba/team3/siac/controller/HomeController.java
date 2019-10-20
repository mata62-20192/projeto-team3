package br.ufba.team3.siac.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private Button addAluno;

    @FXML
    private Button historicoAluno;

    @FXML
    private Button impressaoCurriculo;

    @FXML
    private Pane secPane;

    @FXML
    private Button home;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.criarNovaCena("./src/main/resources/view/home.fxml", this.home);
    }

    public void adicionarAluno(ActionEvent event) {
        this.criarNovaCena("./src/main/resources/view/addAluno.fxml", this.addAluno);
    }

    public void impressaoCurriculo(ActionEvent event) {
        this.criarNovaCena("./src/main/resources/view/impressaoCurriculo.fxml", this.impressaoCurriculo);
    }

    public void loadFxml(ActionEvent event) throws IOException {

    }

    public void selectButton(Button button) {
        this.addAluno.getStyleClass().remove("selected");
        this.historicoAluno.getStyleClass().remove("selected");
        this.impressaoCurriculo.getStyleClass().remove("selected");
        this.home.getStyleClass().remove("selected");
        button.getStyleClass().add("selected");
    }

    public void historicoAluno(ActionEvent actionEvent) {
        this.criarNovaCena("./src/main/resources/view/historicoAluno.fxml", this.historicoAluno);
    }

    public void criarNovaCena(String caminho, Button button) {
        try {
            FXMLLoader loader = new FXMLLoader(Paths.get(caminho).toUri().toURL());
            Pane newPane = loader.load();
            List<Node> parentChildren = ((Pane) secPane.getParent()).getChildren();
            parentChildren.set(parentChildren.indexOf(secPane), newPane);
            secPane = newPane;
            this.selectButton(button);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void home(ActionEvent actionEvent) {
        this.criarNovaCena("./src/main/resources/view/home.fxml", this.home);
    }
}
