package br.com.alura.escola.dominio.aluno;

public class CPF {

    private String numero;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public CPF(String numero) {
        if(numero != null){
            System.out.println("CPF válido");
            this.numero = numero;
        } else {
            throw new IllegalArgumentException("CPF inválido!");
        }

    }
}
