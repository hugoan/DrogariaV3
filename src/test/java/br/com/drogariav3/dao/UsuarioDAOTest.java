package br.com.drogariav3.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogariav3.domain.Pessoa;
import br.com.drogariav3.domain.Usuario;

public class UsuarioDAOTest {

	@Test
	@Ignore
	public void salvar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(1L);

		if (pessoa == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			Usuario usuario = new Usuario();
			usuario.setAtivo(true);
			usuario.setPessoa(pessoa);
			usuario.setSenha("1q2w3e4r");
			usuario.setTipo('A');

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.salvar(usuario);

			System.out.println("Cadastro efetuado com sucesso.");

		}
	}

	@Test
	@Ignore
	public void listar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> resultado = usuarioDAO.listar();

		if (resultado.size() == 0) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			for (Usuario usuario : resultado) {
				System.out.println("Nome: " + usuario.getPessoa().getNome());
				System.out.println("CPF: " + usuario.getPessoa().getCpf());
				System.out.println("Ativo: " + usuario.getAtivo());
				System.out.println("Perfil: " + usuario.getTipo());
				System.out.println("");
			}
		}
	}

	@Test
	@Ignore
	public void buscar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(2L);

		if (usuario == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Nome: " + usuario.getPessoa().getNome());
			System.out.println("CPF: " + usuario.getPessoa().getCpf());
			System.out.println("Ativo: " + usuario.getAtivo());
			System.out.println("Perfil: " + usuario.getTipo());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(1L);

		if (usuario == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			usuarioDAO.excluir(usuario);
			System.out.println("Registro excluído com sucesso.");
		}
	}

	@Test
	public void editar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(2L);

		if (usuario == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			usuario.setAtivo(false);
			usuario.setSenha("q1w2e3r4");
			usuario.setTipo('A');

			usuarioDAO.editar(usuario);

			System.out.println("Registro alterado com sucesso.");
		}
	}

}
