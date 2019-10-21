package br.ufba.team3.siac.controller;

import br.ufba.team3.siac.Main;
import br.ufba.team3.siac.model.Aluno;
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

public class HistoricoController implements Initializable {
    @FXML
    private ListView<String> minhaListViewAlunos;

    @FXML
    private Button imprimir;

    @FXML
    private Label successError;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Aluno> alunos = Main.getUniversidade().getAlunos();
        for (Aluno aluno : alunos) {
            minhaListViewAlunos.getItems().add(aluno.getMatricula() + " - " + aluno.getNome());
        }
    }

    @FXML
    public void imprimir(ActionEvent event) {
        this.successError.setText("");
        this.minhaListViewAlunos.getStyleClass().remove("error");
        if (this.minhaListViewAlunos.getSelectionModel().getSelectedItem() == null) {
            this.successError.setText("É preciso escolher um curso válido");
            this.minhaListViewAlunos.getStyleClass().addAll("error");
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
        fileChooser.setInitialFileName("Historico");
        File file = fileChooser.showSaveDialog(imprimir.getScene().getWindow());
        if (file != null) {
            SalvarArquivo(file);
            this.successError.setText("O arquivo foi salvo com sucesso");
            this.minhaListViewAlunos.getStyleClass().remove("error");
        }
    }

    private void SalvarArquivo(File arquivo) {
        try {
            String conteudo;
            FileWriter leitorDeArquivo;
            String codigo = this.minhaListViewAlunos.getSelectionModel().getSelectedItem().split(" - ")[0];
            Aluno alunoSelecionado = Main.getUniversidade().findAluno(codigo);
            if (arquivo.getAbsolutePath().contains(".html")) {
                conteudo = alunoSelecionado.getHistorico().imprimirHTML(alunoSelecionado);
            } else {
                conteudo = alunoSelecionado.getHistorico().imprimirTXT(alunoSelecionado);
            }
            leitorDeArquivo = new FileWriter(arquivo);
            leitorDeArquivo.write(conteudo);
            leitorDeArquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
