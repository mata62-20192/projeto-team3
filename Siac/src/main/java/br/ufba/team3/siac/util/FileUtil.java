package br.ufba.team3.siac.util;

import br.ufba.team3.siac.Main;
import br.ufba.team3.siac.model.Curso;
import br.ufba.team3.siac.model.Imprimir;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

    public static void exportar(String initialFileName, Window window, Label label, ListView<String> listView, Imprimir imprimir) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt")
                , new FileChooser.ExtensionFilter("HTML Files", "*.html")
        );
        fileChooser.setInitialFileName(initialFileName);
        File file = fileChooser.showSaveDialog(window);
        if (file != null) {
            FileUtil.salvarArquivo(file, imprimir);
            label.setText("O arquivo foi salvo com sucesso");
            listView.getStyleClass().remove("error");
        }
    }

    private static void salvarArquivo(File arquivo, Imprimir imprimir) {
        try {
            String conteudo;
            FileWriter leitorDeArquivo;
            if (arquivo.getAbsolutePath().contains(".html")) {
                conteudo = imprimir.imprimirHTML();
            } else {
                conteudo = imprimir.imprimirTXT();
            }
            leitorDeArquivo = new FileWriter(arquivo);
            leitorDeArquivo.write(conteudo);
            leitorDeArquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
