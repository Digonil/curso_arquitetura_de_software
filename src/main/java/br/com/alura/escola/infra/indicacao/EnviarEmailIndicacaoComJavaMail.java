package br.com.alura.escola.infra.indicacao;

import br.com.alura.escola.aplicacao.aluno.indicacao.EnviarEmailIndicacao;
import br.com.alura.escola.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {

    @Override
    public void enviarPara(Aluno indicado) {
        //Lógica de envio de email com a lib Java Mail

    }
}
