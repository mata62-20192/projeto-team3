package br.ufba.team3.siac.controller;

import br.ufba.team3.siac.Main;
import br.ufba.team3.siac.model.Curso;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
            this.selecionadorDeArquivo();
        }
    }

    private void selecionadorDeArquivo() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt")
                , new FileChooser.ExtensionFilter("HTML Files", "*.html")
        );
        fileChooser.setInitialFileName("Curriculo");
        File file = fileChooser.showSaveDialog(imprimir.getScene().getWindow());
        if (file != null) {
            SalvarArquivo(file);
            this.successoErro.setText("O arquivo foi salvo com sucesso");
            this.cursos.getStyleClass().remove("error");
        }
    }

    private void SalvarArquivo(File arquivo) {
        try {
            String conteudo;
            FileWriter leitorDeArquivo;
            String codigo = this.cursos.getSelectionModel().getSelectedItem().split(" - ")[0];
            Curso cursoSelecionado = Main.getUniversidade().findCurso(codigo);
            if (arquivo.getAbsolutePath().contains(".html")) {
                conteudo = cursoSelecionado.getCurriculo().imprimirHTML();
            } else {
                conteudo = cursoSelecionado.getCurriculo().imprimirTXT();
            }
            leitorDeArquivo = new FileWriter(arquivo);
            leitorDeArquivo.write(conteudo);
            leitorDeArquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
