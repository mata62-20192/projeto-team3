package br.ufba.team3.siac.database;

import br.ufba.team3.siac.model.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;

public class UniversidadeService {
    private final Universidade universidade = new Universidade();

    public void Leitura() throws IOException {
        FileInputStream fis;
        BufferedReader reader;
        fis = new FileInputStream("src/main/java/br/ufba/team3/siac/database/dados.txt");
        reader = new BufferedReader(new InputStreamReader(fis, StandardCharsets.UTF_8));

        int numCursos = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numCursos; i++) {
            // Le nome
            String nome = reader.readLine();
            String codigo = reader.readLine();
            int numDisciplinas = Integer.parseInt(reader.readLine());

            Curso curso = new Curso(codigo, nome);
            universidade.addCurso(curso);

            for (int j = 0; j < numDisciplinas; j++) {
                // ADMF52 1 OB 34 20102
                String nomeDisc = reader.readLine();
                String dadosDisciplina = reader.readLine();
                String[] disciplinaPalavras = dadosDisciplina.split(" ");
                String codigoDisc = disciplinaPalavras[0];
                int semestre = Integer.parseInt(disciplinaPalavras[1]);
                String natureza = disciplinaPalavras[2];
                int ch = Integer.parseInt(disciplinaPalavras[3]);
                String curriculo = disciplinaPalavras[4];

                Disciplina disciplina = this.universidade.findDisciplina(codigoDisc);
                if (disciplina == null) {
                    disciplina = new Disciplina(codigoDisc, nomeDisc, ch);
                    this.universidade.addDisciplina(disciplina);
                }
                DisciplinaCurso disciplinaCurso = new DisciplinaCurso(disciplina, semestre, new HashSet<>(), Natureza.fromString(natureza));
                curso.addDisciplinaCurso(disciplinaCurso);
            }
        }
        reader.close();
        fis.close();
    }

    public Universidade getUniversidade() {
        return universidade;
    }
}
