package br.ufba.team3.siac;

import br.ufba.team3.siac.model.*;

public class Main {
    public static void main(String[] args) {
        Universidade universidade = new Universidade("Universidade Federal da Bahia", "UFBA");
        Curso cienciaDaComputacao = new Curso("Ciencia da Computacao", Turno.MATUTINO, 8.0F, 12.0F, "2012.2", " ", " ");
        Curso sistemaDaInformacao = new Curso("Sistema de Informacao", Turno.MATUTINO, 8.0F, 12.0F, "2012.2", " ", " ");
        Curso licenciatura = new Curso("Licenciatura", Turno.MATUTINO, 8.0F, 12.0F, "2012.2", " ", " ");
        universidade.setCurso(cienciaDaComputacao);
        universidade.setCurso(sistemaDaInformacao);
        universidade.setCurso(licenciatura);
        Disciplina engenhariaDeSoft1 = new Disciplina("Engenharia de Software II (MATA63)", 34.0F, 34.0F, 0F);
        universidade.setDisciplinas(engenhariaDeSoft1);
        cienciaDaComputacao.setDisciplina(new CursoDisciplina(engenhariaDeSoft1, 6));
        sistemaDaInformacao.setDisciplina(new CursoDisciplina(engenhariaDeSoft1, 5));
        licenciatura.setDisciplina(new CursoDisciplina(engenhariaDeSoft1));
        System.out.println(cienciaDaComputacao);
        System.out.println(sistemaDaInformacao);
        System.out.println(licenciatura);
    }
}
