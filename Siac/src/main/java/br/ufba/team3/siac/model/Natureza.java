package br.ufba.team3.siac.model;

public enum Natureza {
    OBRIGATORIO("OB"),
    OPTATIVO("OP");

    private final String texto;

    Natureza(String texto) {
        this.texto = texto;
    }

    public static Natureza fromString(String text) {
        for (Natureza b : Natureza.values()) {
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
