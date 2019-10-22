package br.ufba.team3.siac.controller;

import br.ufba.team3.siac.Main;
import br.ufba.team3.siac.model.Aluno;
import br.ufba.team3.siac.model.Curso;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddAlunoController implements Initializable {

    @FXML
    private ListView<String> cursos;

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
            this.cursos.getItems().add(curso.getCodigo() + " - " + curso.getNome());
        }
    }

    public void AdicionarAlunoNovo(ActionEvent actionEvent) {
        this.limparCss();
        this.successoErro.setText("");
        if (!checagemDeErroDoForms()) {
            String codigo = this.cursos.getSelectionModel().getSelectedItem().split(" - ")[0];
            Curso cursoSelecionado = Main.getUniversidade().findCurso(codigo);
            String nome = this.nome.getText();
            String matricula = this.matricula.getText();
            String senha = this.senha.getText();
            Main.getUniversidade().addAluno(new Aluno(matricula, nome, senha, cursoSelecionado));
            this.limparDados();
            this.cursos.getSelectionModel().clearSelection();
            this.successoErro.setText("O aluno foi adicionado com sucesso");
        }
    }

    private void limparDados() {
        this.matricula.clear();
        this.senha.clear();
        this.nome.clear();
        this.cursos.getSelectionModel().clearSelection();
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
        this.cursos.getStyleClass().remove("error");
    }

    private boolean checagemDeErroDoForms() {
        boolean check = false;
        if (nome.getText().trim().isEmpty()) {
            this.nome.getStyleClass().add("error");
            this.successoErro.setText(this.successoErro.getText() + "Nome não preenchido\n");
            check = true;
        }
        if (senha.getText().trim().isEmpty()) {
            this.senha.getStyleClass().add("error");
            this.successoErro.setText(this.successoErro.getText() + "Senha não preenchida\n");
            check = true;
        }
        if (matricula.getText().trim().isEmpty()) {
            matricula.getStyleClass().add("error");
            this.successoErro.setText(this.successoErro.getText() + "Matricula não preenchida\n");
            check = true;
        }
        if (cursos.getSelectionModel().getSelectedItem() == null) {
            this.cursos.getStyleClass().add("error");
            this.successoErro.setText(this.successoErro.getText() + "Curso não selecionado\n");
            check = true;
        }
        if (Main.getUniversidade().findAluno(this.matricula.getText()) != null) {
            this.cursos.getStyleClass().add("error");
            this.successoErro.setText(this.successoErro.getText() + "Aluno já existe. Matricula repetida\n");
            check = true;
        }
        if(check){
            this.successoErro.setText("O aluno não foi adicionado com sucesso\n" + this.successoErro.getText());
        }
        return check;
    }

}
