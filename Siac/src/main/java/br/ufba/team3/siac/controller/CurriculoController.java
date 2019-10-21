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
    private ListView<String> minhaListViewCursos;

    @FXML
    private Button imprimir;

    @FXML
    private Label successError;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Curso> cursos = Main.getUniversidade().getCursos();
        for (Curso curso : cursos) {
            minhaListViewCursos.getItems().add(curso.getCodigo() + " - " + curso.getNome());
        }
    }

    @FXML
    public void imprimir(ActionEvent event) {
        this.successError.setText("");
        this.minhaListViewCursos.getStyleClass().remove("error");
        if (this.minhaListViewCursos.getSelectionModel().getSelectedItem() == null) {
            this.successError.setText("É preciso escolher um curso válido");
            this.minhaListViewCursos.getStyleClass().addAll("error");
        } else {
            this.FileChooser();
        }
    }

    private void FileChooser() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt")
                , new FileChooser.ExtensionFilter("HTML Files", "*.html")
        );
        fileChooser.setInitialFileName("Curriculo");
        File file = fileChooser.showSaveDialog(imprimir.getScene().getWindow());
        if (file != null) {
            SalvarArquivo(file);
            this.successError.setText("O arquivo foi salvo com sucesso");
            this.minhaListViewCursos.getStyleClass().remove("error");
        }
    }

    private void SalvarArquivo(File arquivo) {
        try {
            String conteudo;
            FileWriter leitorDeArquivo;
            String codigo = this.minhaListViewCursos.getSelectionModel().getSelectedItem().split(" - ")[0];
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
