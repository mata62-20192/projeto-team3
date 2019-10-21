package br.ufba.team3.siac.model;

public enum Conceito {
    APROVADO("A"),
    REPROVADOPORNOTA("RPN"),
    REPROVADOPORFALTA("RPF"),
    DISPENSA("D"),
    TRANCAMENTO("T");

    private final String texto;

    Conceito(String texto) {
        this.texto = texto;
    }

    public static Conceito fromString(String text) {
        for (Conceito b : Conceito.values()) {
            if (b.texto.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

    public String getTexto() {
        return this.texto;
    }
}
