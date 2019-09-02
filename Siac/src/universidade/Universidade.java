package universidade;

import java.util.ArrayList;

public class Universidade {
    protected ArrayList<Departamento> departamentos = new ArrayList<Departamento>();

    public Universidade() {
    }

    public void criarDepartamento(long id, String nome){
        this.departamentos.add(new Departamento(id, nome));
    }

    public ArrayList<Departamento> getDepartamentos() {
        return departamentos;
    }

}
