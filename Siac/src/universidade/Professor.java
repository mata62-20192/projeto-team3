package universidade;

import java.util.ArrayList;

public class Professor extends Pessoa {
    private String id;
    private ArrayList<Turma> turmas = new ArrayList<Turma>();

    public Professor(String nome, String cpf, String email, String id) {
        super(nome, cpf, email);
        this.id = id;
        this.turmas = turmas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(ArrayList<Turma> turmas) {
        this.turmas = turmas;
    }
}
