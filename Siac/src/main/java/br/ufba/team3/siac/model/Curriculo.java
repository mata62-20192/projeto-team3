package br.ufba.team3.siac.model;

import org.apache.commons.io.FileUtils;

import java.io.File;

public final class Curriculo implements Imprimir {
    private Curso curso;

    public Curriculo(Curso curso) {
        this.curso = curso;
    }

    public String conteudoTXT() {
        StringBuilder dados = new StringBuilder("");
        StringBuilder preRequisitos = new StringBuilder("");
        dados.append(curso.getNome() + "\r\n");
        dados.append("Semestre|Natureza|Código|Nome da Disciplina|Pré-Requisitos\r\n");
        for (DisciplinaCurso disciplinaCurso : curso.getDisciplinasCurso()) {
            dados.append((disciplinaCurso.getSemestre() != 0 ? disciplinaCurso.getSemestre() : " ") + " " +
                    disciplinaCurso.getNatureza().getTexto() + " " +
                    disciplinaCurso.getDisciplina().getCodigoDisciplina() + " " +
                    disciplinaCurso.getDisciplina().getNomeDisciplina() + " ");
            if (disciplinaCurso.getPreRequisitos().size() != 0) {
                preRequisitos = new StringBuilder("");
            }
            for (Disciplina disciplina : disciplinaCurso.getPreRequisitos()) {
                preRequisitos.append(disciplina.getCodigoDisciplina() + " ");
            }
            dados.append(preRequisitos + " \r\n");
        }
        return dados.toString();
    }

    public String conteudoHTML() {
        String htmlString = "";
        try {
            File templateHTML = new File("./src/main/resources/utils/templateCurriculo.html");
            htmlString = FileUtils.readFileToString(templateHTML, "UTF-8");
            String titulo = curso.getNome();
            StringBuilder dados = new StringBuilder("");
            StringBuilder preRequisitos = new StringBuilder("--");
            for (DisciplinaCurso disciplinaCurso : curso.getDisciplinasCurso()) {
                dados.append("<tr>" +
                        "<td>" + (disciplinaCurso.getSemestre() != 0 ? disciplinaCurso.getSemestre() : " ") + "</td>" +
                        "<td>" + disciplinaCurso.getNatureza().getTexto() + "</td>" +
                        "<td>" + disciplinaCurso.getDisciplina().getCodigoDisciplina() + "</td>" +
                        "<td>" + disciplinaCurso.getDisciplina().getNomeDisciplina() + "</td>");
                if (disciplinaCurso.getPreRequisitos().size() != 0) {
                    preRequisitos = new StringBuilder("");
                }
                for (Disciplina disciplina : disciplinaCurso.getPreRequisitos()) {
                    preRequisitos.append(disciplina.getCodigoDisciplina() + " ");
                }
                dados.append("<td>" + preRequisitos.toString() + "</td></tr>");
            }
            htmlString = htmlString.replace("$titulo", titulo);
            htmlString = htmlString.replace("$dados", dados.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return htmlString;
    }
}
