package br.ufba.team3.siac.model;

import javax.persistence.Entity;
import java.sql.Date;

@Entity
public class Aluno extends Pessoa {

    public Aluno(String nome, String cpf, Date nascimento, String matricula, String senha, String email) {
        super(nome, cpf, nascimento, matricula, senha, email);
    }
}
