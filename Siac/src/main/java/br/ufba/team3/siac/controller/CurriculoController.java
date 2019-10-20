package br.ufba.team3.siac.controller;

import br.ufba.team3.siac.Main;
import br.ufba.team3.siac.model.Curso;
import br.ufba.team3.siac.model.Disciplina;
import br.ufba.team3.siac.model.DisciplinaCurso;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.text.MessageFormat;
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
            SaveFile(file);
        }
    }

    private void SaveFile(File file){
        try {
            String conteudo = "";
            FileWriter fileWriter = null;
            String codigo = this.minhaListViewCursos.getSelectionModel().getSelectedItem().split(" - ")[0];
            Curso cursoSelecionado = Main.findCurso(codigo);
            if(file.getAbsolutePath().contains(".html")){
                conteudo = transformeStringHTML(cursoSelecionado);
            }else{
                conteudo = transformeStringTXT(cursoSelecionado);
            }
            fileWriter = new FileWriter(file);
            fileWriter.write(conteudo);
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private String transformeStringTXT(Curso curso) {
        return "";
    }

    private String transformeStringHTML(Curso curso) {
        String htmlString = "";
        try{
            File templateHTML = new File("./src/main/resources/utils/template.html");
            htmlString = FileUtils.readFileToString(templateHTML, "UTF-8");
            String titulo = curso.getNome();
            String dados = "";
            String preRequisitos = "--";
            for (DisciplinaCurso disciplinaCurso: curso.getDisciplinasCurso()) {
                dados += "<tr>"+
                        "<td>" + (disciplinaCurso.getSemestre() != 0 ? disciplinaCurso.getSemestre() : " ") + "</td>" +
                        "<td>" + disciplinaCurso.getNatureza().getTexto() + "</td>" +
                        "<td>" + disciplinaCurso.getDisciplina().getCodigoDisciplina() + "</td>" +
                        "<td>" + disciplinaCurso.getDisciplina().getNomeDisciplina() + "</td>";
                if(disciplinaCurso.getPreRequisitos().size() != 0){
                    preRequisitos = "";
                }
                for (Disciplina disciplina: disciplinaCurso.getPreRequisitos()) {
                    preRequisitos += disciplina.getCodigoDisciplina() + " ";
                }
                dados += "<td>"+ preRequisitos+"</td>";
                dados+="</tr>";
            }
            htmlString = htmlString.replace("$titulo", titulo);
            htmlString = htmlString.replace("$dados", dados);
        }catch (Exception e){
            System.out.println(e);
        }
        return htmlString;
    }


}
