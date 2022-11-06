package br.com.alura.aluno;

import br.com.alura.escola.dominio.aluno.Telefone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefoneTest {

    @Test
    void testeTelefone(){
        assertThrows(IllegalArgumentException.class, ()-> new Telefone("000", "1234567890"));
        assertThrows(NullPointerException.class, ()-> new Telefone(null, null));
        assertThrows(IllegalArgumentException.class, ()-> new Telefone("Telefone Inválido ", "Telefone inválido "));
    }

}