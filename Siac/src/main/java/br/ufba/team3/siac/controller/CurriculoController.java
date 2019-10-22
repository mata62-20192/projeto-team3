package br.ufba.team3.siac.controller;

import br.ufba.team3.siac.Main;
import br.ufba.team3.siac.model.Curso;
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

public class CurriculoController implements Initializable {
    @FXML
    private ListView<String> cursos;

    @FXML
    private Button imprimir;

    @FXML
    private Label successoErro;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Curso> cursos = Main.getUniversidade().getCursos();
        for (Curso curso : cursos) {
            this.cursos.getItems().add(curso.getCodigo() + " - " + curso.getNome());
        }
    }

    @FXML
    public void imprimir(ActionEvent event) {
        this.successoErro.setText("");
        this.cursos.getStyleClass().remove("error");
        if (this.cursos.getSelectionModel().getSelectedItem() == null) {
            this.successoErro.setText("É preciso escolher um curso válido");
            this.cursos.getStyleClass().addAll("error");
        } else {
            String codigo = this.cursos.getSelectionModel().getSelectedItem().split(" - ")[0];
            Imprimir curriculo = Main.getUniversidade().findCurso(codigo).getCurriculo();

            FileUtil.exportar("Curriculo", imprimir.getScene().getWindow(), this.successoErro, this.cursos, curriculo);
        }
    }

}
