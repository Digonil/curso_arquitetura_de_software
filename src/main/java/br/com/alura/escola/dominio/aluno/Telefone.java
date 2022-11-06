package br.com.alura.escola.dominio.aluno;

public class Telefone {

    private String ddd;
    private String numero;

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Telefone(String ddd, String numero) {

        if (ddd.length() != 2) {
            throw new IllegalArgumentException("Telefone inválido");
        } else if (numero.length() != 8 || numero.length() != 9) {
            throw new IllegalArgumentException("Telefone inválido");
        } else {
            this.ddd = ddd;
            this.numero = numero;
        }

    }
}
