package br.ufba.team3.siac;

import br.ufba.team3.siac.model.*;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class LeDados {

    public void Leitura(Universidade universidade) throws IOException {
        FileInputStream fis = null;
        BufferedReader reader = null;
        fis = new FileInputStream("dados.txt");
        reader = new BufferedReader(new InputStreamReader(fis));

        int numCursos = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numCursos; i++) {
            // Le nome
            reader.skip(0);
            String nome = reader.readLine();
            String codigo = reader.readLine();
            int numDisciplinas = Integer.parseInt(reader.readLine());

            Curso curso = new Curso(codigo, nome);
            universidade.addCurso(curso);

            for (int j = 0; j < numDisciplinas; j++) {
                // ADMF52 1 OB 34 20102
                reader.skip(0);
                String nomeDisc = reader.readLine();
                String dadosDisciplina = reader.readLine();
                String disciplinaPalavras[] = dadosDisciplina.split(" ");
                String codigoDisc = disciplinaPalavras[0];
                int semestre = Integer.parseInt(disciplinaPalavras[1]);
                String natureza = disciplinaPalavras[2];
                int ch =  Integer.parseInt(disciplinaPalavras[3]);
                String curriculo = disciplinaPalavras[4];

                Disciplina disciplina = universidade.findDisciplina(codigoDisc);
                if (disciplina == null) {
                    disciplina = new Disciplina(codigoDisc, nomeDisc, ch);
                    universidade.addDisciplina(disciplina);
                }
                DisciplinaCurso disciplinaCurso = new DisciplinaCurso(disciplina, semestre, new HashSet<Disciplina>(), Natureza.fromString(natureza));
                curso.addDisciplinaCurso(disciplinaCurso);
            }
        }
        reader.close();
        fis.close();
    }
}
