package br.com.alura.escola.dominio.aluno;

public class Email {

    //Entidades possuem uma identidade única, enquanto VOs são considerados iguais, se todos os seus atributos tiverem valores iguais.
    //Se dois e-mails possuem o mesmo endereço, podemos considerá-los como o mesmo e-mail. Já duas pessoas com o nome, altura e idade não necessariamente são a mesma pessoa.
    private String endereco;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Email(String endereco) {
        validarEmail(endereco);
    }

    public void validarEmail(String endereco) {
        if (endereco != null) {
            this.endereco = endereco;
            System.out.println("Este email está correto");
        } else {
            throw new IllegalArgumentException("Email inválido!!!");
        }
    }

}


