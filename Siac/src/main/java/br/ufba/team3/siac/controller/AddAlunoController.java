package br.ufba.team3.siac.controller;

import br.ufba.team3.siac.Main;
import br.ufba.team3.siac.model.Aluno;
import br.ufba.team3.siac.model.Curso;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddAlunoController implements Initializable {

    @FXML
    private ListView<String> minhaListViewCursos;

    @FXML
    private TextField nome;


    @FXML
    private TextField senha;

    @FXML
    private TextField matricula;

    @FXML
    private Label successoErro;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Curso> cursos = Main.getUniversidade().getCursos();
        for (Curso curso : cursos) {
            minhaListViewCursos.getItems().add(curso.getCodigo() + " - " + curso.getNome());
        }
    }

    public void AdicionarAlunoNovo(ActionEvent actionEvent) {
        this.limparCss();
        this.successoErro.setText("");
        if (!checagemDeErroDoForms()) {
            String codigo = this.minhaListViewCursos.getSelectionModel().getSelectedItem().split(" - ")[0];
            Curso cursoSelecionado = Main.getUniversidade().findCurso(codigo);
            String nome = this.nome.getText();
            String matricula = this.matricula.getText();
            String senha = this.senha.getText();
            Main.getUniversidade().addAluno(new Aluno(matricula, nome, senha, cursoSelecionado));
            this.limparDados();
            this.minhaListViewCursos.getSelectionModel().clearSelection();
            this.successoErro.setText("O aluno foi adicionado com sucesso");
        }
    }

    private void limparDados() {
        this.matricula.clear();
        this.senha.clear();
        this.nome.clear();
        this.minhaListViewCursos.getSelectionModel().clearSelection();
        this.limparCss();
    }

    @FXML
    private void limparDadosCompleto() {
        this.limparDados();
        this.successoErro.setText("");
    }

    private void limparCss(){
        this.nome.getStyleClass().remove("error");
        this.senha.getStyleClass().remove("error");
        this.matricula.getStyleClass().remove("error");
        this.minhaListViewCursos.getStyleClass().remove("error");
    }

    private boolean checagemDeErroDoForms() {
        boolean checagem = false;
        if (this.nome.getText().trim().isEmpty()) {
            this.setErros(this.minhaListViewCursos, checagem, this.successoErro,"Nome não preenchido\n", this.nome);
        }
        if (this.senha.getText().trim().isEmpty()) {
            this.setErros(this.minhaListViewCursos, checagem, this.successoErro,"Senha não preenchida\n", this.senha);
        }
        if (this.matricula.getText().trim().isEmpty()) {
            this.setErros(this.minhaListViewCursos, checagem, this.successoErro,"Matricula não preenchida\n", this.matricula);
        }
        if (minhaListViewCursos.getSelectionModel().getSelectedItem() == null) {
            this.setErros(this.minhaListViewCursos, checagem, this.successoErro,"Curso não selecionado\n");
        }
        if (Main.getUniversidade().findAluno(this.matricula.getText()) != null) {
            this.setErros(this.minhaListViewCursos, checagem, this.successoErro,"Aluno já existe. Matricula repetida\n" );
        }
        if(checagem){
            this.successoErro.setText("O aluno não foi adicionado com sucesso\n" + this.successoErro.getText());
        }
        return checagem;
    }

    private void setErros(ListView listView, Boolean checagem, Label label, String texto){
        listView.getStyleClass().add("error");
        checagem = true;
        label.setText(label.getText() + texto);
    }

    private void setErros(ListView listView, Boolean checagem, Label label, String texto, TextField textField){
        this.setErros(listView, checagem, label, texto);
        textField.getStyleClass().add("error");
    }
}
