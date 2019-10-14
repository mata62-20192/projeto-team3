package br.ufba.team3.siac;

import br.ufba.team3.siac.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class LeDados {
    public void Leitura(Universidade universidade) throws FileNotFoundException {
        File file = new File("dados.txt");
        Scanner input = new Scanner(file);
        int numCursos = input.nextInt();
        for (int i = 0; i < numCursos; i++) {
            // Le nome
            input.skip("\n");
            String nome = input.nextLine();
            String codigo = input.nextLine();
            int numDisciplinas = input.nextInt();

            Curso curso = new Curso(codigo, nome);
            universidade.addCurso(curso);

            for (int j = 0; j < numDisciplinas; j++) {
                // ADMF52 1 OB 34 20102
                input.skip("\n");
                String nomeDisc = input.nextLine();
                String codigoDisc = input.next();
                int semestre = input.nextInt();
                String natureza = input.next();
                int ch = input.nextInt();
                String curriculo = input.next();

                Disciplina disciplina = universidade.findDisciplina(codigoDisc);
                if (disciplina == null) {
                    disciplina = new Disciplina(codigoDisc, nomeDisc, ch);
                    universidade.addDisciplina(disciplina);
                }
                DisciplinaCurso disciplinaCurso = new DisciplinaCurso(disciplina, semestre, new HashSet<Disciplina>(), Natureza.fromString(natureza));
                curso.addDisciplinaCurso(disciplinaCurso);
            }
        }
        input.close();
    }

}
