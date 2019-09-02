package universidade;

import java.util.ArrayList;

public class Departamento {
    private long id;
    private String nome;
    private ArrayList<Professor> professors = new ArrayList<Professor>();

    public Departamento(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public void criarProfessor(String nome, String cpf, String email, String id){
        this.professors.add(new Professor(nome, cpf, email,id));
    }
}
