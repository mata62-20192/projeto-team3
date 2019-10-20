package br.ufba.team3.siac.controller;

import br.ufba.team3.siac.Main;
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
    private Button adicionarAlunoNovo;

    @FXML
    private Button limparAdicaoAluno;

    @FXML
    private Label successError;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Curso> cursos = Main.getAllCursos();
        for (Curso curso : cursos) {
            minhaListViewCursos.getItems().add(curso.getCodigo() + " - " + curso.getNome());
        }
    }

    public void AdicionarAlunoNovo(ActionEvent actionEvent) {
        this.nome.getStyleClass().remove("error");
        this.senha.getStyleClass().remove("error");
        this.matricula.getStyleClass().remove("error");
        this.minhaListViewCursos.getStyleClass().remove("error");
        if(!checkErrosForms()){
            String codigo = this.minhaListViewCursos.getSelectionModel().getSelectedItem().split(" - ")[0];
            Curso cursoSelecionado = Main.findCurso(codigo);
            String nome = this.nome.getText();
            String matricula = this.matricula.getText();
            String senha = this.senha.getText();
            Main.addAluno(nome, matricula, senha, cursoSelecionado);
            this.limparDados();
            this.minhaListViewCursos.getSelectionModel().clearSelection();
            this.successError.setText("O aluno foi adicionado com sucesso");
            System.out.println(Main.getUniversidade().getAlunos());
        }
    }

    public void limparDados(){
        this.matricula.clear();
        this.senha.clear();
        this.nome.clear();
        this.minhaListViewCursos.getSelectionModel().clearSelection();
        this.nome.getStyleClass().remove("error");
        this.senha.getStyleClass().remove("error");
        this.matricula.getStyleClass().remove("error");
        this.minhaListViewCursos.getStyleClass().remove("error");
    }

    public void limparDadosCompleto(){
        this.limparDados();
        this.successError.setText("");
    }

    public boolean checkErrosForms(){
        boolean check = false;
        if (nome.getText().trim().isEmpty()) {
            this.successError.setText("O aluno não foi adicionado com sucesso");
            this.nome.getStyleClass().add("error");
            this.successError.setText(this.successError.getText() + "\nNome não preenchido");
            check = true;
        }
        if (senha.getText().trim().isEmpty()) {
            this.senha.getStyleClass().add("error");
            this.successError.setText(this.successError.getText() + "\nSenha não preenchida");
            check = true;
        }
        if (matricula.getText().trim().isEmpty()) {
            matricula.getStyleClass().add("error");
            this.successError.setText(this.successError.getText() + "\nMatricula não preenchida");
            check = true;
        }
        if(minhaListViewCursos.getSelectionModel().getSelectedItem() == null){
            this.minhaListViewCursos.getStyleClass().add("error");
            this.successError.setText(this.successError.getText() + "\nCurso não selecionado");
            check = true;
        }
        if(Main.findAluno(this.matricula.getText()) != null){
            this.minhaListViewCursos.getStyleClass().add("error");
            this.successError.setText(this.successError.getText() + "\nAluno já existe. Matricula repetida");
            check = true;
        }
        return check;
    }
}
