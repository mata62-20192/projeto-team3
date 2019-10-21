package br.ufba.team3.siac.database;

import br.ufba.team3.siac.Main;
import br.ufba.team3.siac.model.Aluno;
import br.ufba.team3.siac.model.Conceito;
import br.ufba.team3.siac.model.DisciplinaCursada;
import br.ufba.team3.siac.model.DisciplinaCurso;

public class AlunoService {
    public void criarAlunos(){
        Aluno aluno1 = new Aluno("1", "Daiane Silva", "sdaasd",  Main.getUniversidade().findCurso("187140"));

        DisciplinaCurso disciplinaCurso = aluno1.getCurso().findDisciplinaCurso("ARQA14");
        DisciplinaCursada disciplinaCursada = new DisciplinaCursada(1, disciplinaCurso);
        disciplinaCursada.setConceito(Conceito.APROVADO);
        disciplinaCursada.setNota(10.0);

        aluno1.getHistorico().addDisciplinaCursada(disciplinaCursada);



        disciplinaCurso = aluno1.getCurso().findDisciplinaCurso("ARQA19");
        disciplinaCursada = new DisciplinaCursada(2, disciplinaCurso);
        disciplinaCursada.setConceito(Conceito.APROVADO);
        disciplinaCursada.setNota(10.0);

        aluno1.getHistorico().addDisciplinaCursada(disciplinaCursada);



        disciplinaCurso = aluno1.getCurso().findDisciplinaCurso("ARQA15");
        disciplinaCursada = new DisciplinaCursada(1, disciplinaCurso);
        disciplinaCursada.setConceito(Conceito.REPROVADOPORFALTA);

        aluno1.getHistorico().addDisciplinaCursada(disciplinaCursada);

        disciplinaCurso = aluno1.getCurso().findDisciplinaCurso("ARQA16");
        disciplinaCursada = new DisciplinaCursada(1, disciplinaCurso);
        disciplinaCursada.setConceito(Conceito.REPROVADOPORNOTA);
        disciplinaCursada.setNota(4.0);

        aluno1.getHistorico().addDisciplinaCursada(disciplinaCursada);

        disciplinaCurso = aluno1.getCurso().findDisciplinaCurso("ARQB27");
        disciplinaCursada = new DisciplinaCursada(1, disciplinaCurso);
        disciplinaCursada.setConceito(Conceito.APROVADO);
        disciplinaCursada.setNota(7.0);

        aluno1.getHistorico().addDisciplinaCursada(disciplinaCursada);

        Main.getUniversidade().addAluno(aluno1);
    }
}
