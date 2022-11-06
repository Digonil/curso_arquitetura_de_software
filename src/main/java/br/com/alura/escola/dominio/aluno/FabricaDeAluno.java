package br.com.alura.escola.dominio.aluno;

public class FabricaDeAluno {

    //Factory de alunos utilizando o design patern "Builder"(semelhante)
    private Aluno aluno;

    public FabricaDeAluno comNomeCPFEmail(String nome, String cpf, String email){
        this.aluno = new Aluno(new CPF(cpf), nome, new Email(email));
        return this;
    }

    public FabricaDeAluno comTelefone(String ddd, String numero){
        this.aluno.adicionarTelefone(ddd, numero);
        return this;
    }

    public Aluno criar(){
        return this.aluno;
    }

//    //Exemplo de método main chamando a construção de um aluno
//    public static void main(String[] args) {
//        FabricaDeAluno fabrica = new FabricaDeAluno();
//        fabrica.comNomeCPFEmail(" ", " "," " ).comTelefone(" ", " ").criar();
//    }
}
