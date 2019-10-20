package br.ufba.team3.siac.controller;

import br.ufba.team3.siac.Main;
import br.ufba.team3.siac.model.Curso;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CurriculoController implements Initializable {
    @FXML
    private ListView<String> minhaListViewCursos;

    @FXML
    private Button imprimir;

    @FXML
    private Label successError;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Curso> cursos = Main.getAllCursos();
        for (Curso curso : cursos) {
            minhaListViewCursos.getItems().add(curso.getCodigo() + " - " + curso.getNome());
        }
    }

    @FXML
    void imprimir(ActionEvent event) throws MalformedURLException {
        FileChooser fileChooser = new FileChooser();


        //Set extension filter
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt")
                ,new FileChooser.ExtensionFilter("HTML Files", "*.html")
        );
        fileChooser.setInitialFileName("Curriculo");

        //Show save file dialog
        File file = fileChooser.showSaveDialog(imprimir.getScene().getWindow());

        if(file != null){
            System.out.println(file);
            SaveFile(file);
        }
    }

    private void SaveFile(File file){
        try {
            String conteudo = "";
            FileWriter fileWriter = null;
            if(file.getAbsolutePath().contains(".txt")){
                conteudo = transformeStringHTML();
            }else{
                conteudo = transformeStringTXT();
            }
            fileWriter = new FileWriter(file);
            fileWriter.write(conteudo);
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private String transformeStringTXT() {
        return "";
    }

    private String transformeStringHTML() {
        return "";
    }


}
