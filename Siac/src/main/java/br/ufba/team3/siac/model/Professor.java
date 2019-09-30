package br.ufba.team3.siac.model;


import javax.persistence.Entity;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Professor extends Pessoa {
    private List turmas;

    public Professor(String nome, String cpf, Date nascimento, String matricula, String senha, String email) {
        super(nome, cpf, nascimento, matricula, senha, email);
        this.turmas = new ArrayList<Turma>();
    }

    public List getTurmas() {
        return turmas;
    }

    public void setTurmas(Turma turma) {
        this.turmas.add(turma);
    }
}
