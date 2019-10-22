package br.ufba.team3.siac.model;

import org.apache.commons.io.FileUtils;

import java.io.File;

public final class Curriculo {
    private Curso curso;

    public Curriculo(Curso curso) {
        this.curso = curso;
    }

    public String imprimirTXT() {
        String dados = "";
        String preRequisitos = "--";
        dados += curso.getNome() + "\r\n";
        dados += "Semestre|Natureza|Código|Nome da Disciplina|Pré-Requisitos\r\n";
        for (DisciplinaCurso disciplinaCurso : curso.getDisciplinasCurso()) {
            dados += (disciplinaCurso.getSemestre() != 0 ? disciplinaCurso.getSemestre() : " ") + " " +
                    disciplinaCurso.getNatureza().getTexto() + " " +
                    disciplinaCurso.getDisciplina().getCodigoDisciplina() + " " +
                    disciplinaCurso.getDisciplina().getNomeDisciplina() + " ";
            if (disciplinaCurso.getPreRequisitos().size() != 0) {
                preRequisitos = "";
            }
            for (Disciplina disciplina : disciplinaCurso.getPreRequisitos()) {
                preRequisitos += disciplina.getCodigoDisciplina() + " ";
            }
            dados += preRequisitos + " ";
            dados += "\r\n";
        }
        return dados;
    }

    public String imprimirHTML() {
        String htmlString = "";
        try {
            File templateHTML = new File("./src/main/resources/utils/templateCurriculo.html");
            htmlString = FileUtils.readFileToString(templateHTML, "UTF-8");
            String titulo = curso.getNome();
            String dados = "";
            String preRequisitos = "--";
            for (DisciplinaCurso disciplinaCurso : curso.getDisciplinasCurso()) {
                dados += "<tr>" +
                        "<td>" + (disciplinaCurso.getSemestre() != 0 ? disciplinaCurso.getSemestre() : " ") + "</td>" +
                        "<td>" + disciplinaCurso.getNatureza().getTexto() + "</td>" +
                        "<td>" + disciplinaCurso.getDisciplina().getCodigoDisciplina() + "</td>" +
                        "<td>" + disciplinaCurso.getDisciplina().getNomeDisciplina() + "</td>";
                if (disciplinaCurso.getPreRequisitos().size() != 0) {
                    preRequisitos = "";
                }
                for (Disciplina disciplina : disciplinaCurso.getPreRequisitos()) {
                    preRequisitos += disciplina.getCodigoDisciplina() + " ";
                }
                dados += "<td>" + preRequisitos + "</td>";
                dados += "</tr>";
            }
            htmlString = htmlString.replace("$titulo", titulo);
            htmlString = htmlString.replace("$dados", dados);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return htmlString;
    }
}
