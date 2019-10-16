package br.ufba.team3.siac.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private Button addAluno;

    @FXML
    private Button historicoAluno;

    @FXML
    private Button impressaoCurriculo;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void adcionarAluno(ActionEvent event) {
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(Paths.get("./src/main/resources/view/addAluno.fxml").toUri().toURL());
            Parent root = loader.load();
//            AddAlunoController addAlunoController= loader.getController();
//        val resumeController: ResumeController = loader.getController()
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
