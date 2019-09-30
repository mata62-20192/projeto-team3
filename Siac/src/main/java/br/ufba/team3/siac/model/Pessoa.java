package br.ufba.team3.siac.model;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "pessoa")
@Table(name = "pessoa")
public class Pessoa  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cpf;
    private Date nascimento;
    private String matricula;
    private String senha;
    private String email;

    public Pessoa(){
        this.id = null;
    }

    public Pessoa(String nome, String cpf, Date nascimento, String matricula, String senha, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.matricula = matricula;
        this.senha = senha;
        this.email = email;
        this.id = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
