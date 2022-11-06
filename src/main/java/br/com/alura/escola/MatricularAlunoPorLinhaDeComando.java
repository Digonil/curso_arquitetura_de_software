package br.com.alura.escola;

import br.com.alura.escola.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.aplicacao.aluno.matricular.MatricularAlunoDTO;
import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.Email;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunoEmMemoria;

public class MatricularAlunoPorLinhaDeComando {
    public static void main(String[] args) {
        String nome = "Fulano da Silva";
        CPF cpf = new CPF("123.456.789-96");
        Email email = new Email("fulano@email.com.br");

        MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunoEmMemoria());
        matricular.executa(new MatricularAlunoDTO(nome, cpf, email));
    }
}
