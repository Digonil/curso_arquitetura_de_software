package br.com.alura.escola.infra.aluno;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.AlunoNaoEncontrado;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.Email;
import br.com.alura.escola.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.dominio.aluno.Telefone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RepositorioDeAlunosComJDBC implements RepositorioDeAlunos {


    private final Connection connection;

    public RepositorioDeAlunosComJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        String sql = "INSERT INTO VALUES (?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, aluno.getCpf());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getEmail());
            ps.execute();

            sql = "INSERT INTO TELEFONE VALUES (?, ?)";
            ps = connection.prepareStatement(sql);
            for (Telefone telefone : aluno.getTelefones()) {
                ps.setString(1, telefone.getDdd());
                ps.setString(2, telefone.getNumero());
                ps.execute();
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    String sqlSearch = "SELECT * INTO VALUES";
    ResultSet rs = null;

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
        try {
            String sql = "SELECT id, nome, email FROM ALUNO WHERE cpf";
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            boolean encontrou = rs.next();
            if (!encontrou) {
                throw new AlunoNaoEncontrado(cpf);
            }

            String nome = rs.getString("nome");
            Email email = new Email("email");
            Aluno encontrado = new Aluno(cpf, nome, email);

            Long id = rs.getLong("id");
            sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                String numero = rs.getString("numero");
                String ddd = rs.getString("ddd");
                encontrado.adicionarTelefone(ddd, numero);
            }
            return encontrado;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Aluno> listarTodosOsAlunosMatriculados() {
        return null;
    }
}
