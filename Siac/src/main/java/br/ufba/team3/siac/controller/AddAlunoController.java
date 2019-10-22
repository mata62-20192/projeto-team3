package br.ufba.team3.siac.controller;

import br.ufba.team3.siac.Main;
import br.ufba.team3.siac.model.Aluno;
import br.ufba.team3.siac.model.Curso;
import br.ufba.team3.siac.util.FormUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
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
    private PasswordField senha;

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

    public void adicionarAlunoNovo(ActionEvent actionEvent) {
        this.limparCss();
        this.successoErro.setText("");
        if (ehFormValido()) {
            String codigo = this.cursos.getSelectionModel().getSelectedItem().split(" - ")[0];
            Curso cursoSelecionado = Main.getUniversidade().findCurso(codigo);
            String nome = this.nome.getText();
            String matricula = this.matricula.getText();
            String senha = this.senha.getText();
            Main.getUniversidade().addAluno(new Aluno(matricula, nome, senha, cursoSelecionado));
            this.limparDados();
            this.cursos.getSelectionModel().clearSelection();
            this.successoErro.setText("O aluno foi adicionado com sucesso");
        }else{
            this.successoErro.setText("O aluno não foi adicionado com sucesso\n" + this.successoErro.getText());
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

    private boolean ehFormValido() {
        boolean check = true;
        if (nome.getText().trim().isEmpty()) {
            FormUtil.setError(this.nome, this.successoErro, "Nome não preenchido");
            check = false;
        }
        if (senha.getText().trim().isEmpty()) {
            FormUtil.setError(this.senha, this.successoErro, "Senha não preenchida");
            check = false;
        }
        if (matricula.getText().trim().isEmpty()) {
            FormUtil.setError(this.matricula, this.successoErro, "Matricula não preenchida");
            check = false;
        }
        if (cursos.getSelectionModel().getSelectedItem() == null) {
            FormUtil.setError(this.cursos, this.successoErro, "Curso não selecionado");
            check = false;
        }
        if (Main.getUniversidade().findAluno(this.matricula.getText()) != null) {
            FormUtil.setError(this.cursos, this.successoErro, "Aluno já existe. Matricula repetida");
            check = false;
        }

        return check;
    }
}
