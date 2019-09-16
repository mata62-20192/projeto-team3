package br.ufba.team3.siac.model;

import java.sql.Date;

public class Coordenador extends Pessoa{
    public Coordenador(String nome, String cpf, Date nascimento, String matricula, String senha, String email) {
        super(nome, cpf, nascimento, matricula, senha, email);
    }
}
