package br.ufba.team3.siac.util;

import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class FormUtil {

    public static void setError(TextField textField, Label label, String error){
        textField.getStyleClass().add("error");
        label.setText(label.getText() + error + "\n");
    }

    public static void setError(ListView listView, Label label, String error){
        listView.getStyleClass().add("error");
        label.setText(label.getText() + error + "\n");
    }
}
