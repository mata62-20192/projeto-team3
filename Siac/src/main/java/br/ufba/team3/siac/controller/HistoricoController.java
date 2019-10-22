package br.ufba.team3.siac.controller;

import br.ufba.team3.siac.Main;
import br.ufba.team3.siac.model.Aluno;
import br.ufba.team3.siac.model.Imprimir;
import br.ufba.team3.siac.util.FileUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HistoricoController implements Initializable {
    @FXML
    private ListView<String> alunos;

    @FXML
    private Button imprimir;

    @FXML
    private Label successoErro;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Aluno> alunos = Main.getUniversidade().getAlunos();
        for (Aluno aluno : alunos) {
            this.alunos.getItems().add(aluno.getMatricula() + " - " + aluno.getNome());
        }
    }


    @FXML
    public void imprimir(ActionEvent event) {
        this.successoErro.setText("");
        this.alunos.getStyleClass().remove("error");
        if (this.alunos.getSelectionModel().getSelectedItem() == null) {
            this.successoErro.setText("É preciso escolher um curso válido");
            this.alunos.getStyleClass().addAll("error");
        } else {
            String codigo = this.alunos.getSelectionModel().getSelectedItem().split(" - ")[0];
            Imprimir curriculo = Main.getUniversidade().findAluno(codigo).getHistorico();

            FileUtil.exportar("Historico", imprimir.getScene().getWindow(), this.successoErro, this.alunos, curriculo);
        }
    }

}
