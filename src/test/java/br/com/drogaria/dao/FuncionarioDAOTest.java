package br.com.drogaria.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogariav3.dao.FuncionarioDAO;
import br.com.drogariav3.dao.PessoaDAO;
import br.com.drogariav3.domain.Funcionario;
import br.com.drogariav3.domain.Pessoa;

public class FuncionarioDAOTest {

	@Test
	@Ignore
	public void salvar() throws ParseException {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);

		if (pessoa == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			Funcionario funcionario = new Funcionario();
			funcionario.setCarteiraTrabalho("012345678");
			funcionario.setDataAdmissao(new SimpleDateFormat("dd/MM/yyyy")
					.parse("26/09/2016"));
			funcionario.setPessoa(pessoa);

			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.salvar(funcionario);

			System.out.println("Funcionário cadastrado com sucesso!");
		}
	}

	@Test
	@Ignore
	public void listar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		List<Funcionario> resultado = funcionarioDAO.listar();

		if (resultado.size() == 0) {
			System.out.println("Nenhum resultado encontrado.");
		} else {
			for (Funcionario funcionario : resultado) {
				System.out
						.println("Nome: " + funcionario.getPessoa().getNome());
				System.out.println("Carteira nº: "
						+ funcionario.getCarteiraTrabalho());
				System.out.println("Data de Admissão: "
						+ funcionario.getDataAdmissao());
				System.out.println("");
			}
		}
	}

	@Test
	@Ignore
	public void buscar() {

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(1L);

		if (funcionario == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Nome: " + funcionario.getPessoa().getNome());
			System.out.println("Carteira nº: "
					+ funcionario.getCarteiraTrabalho());
			System.out.println("Data de Admissão: "
					+ funcionario.getDataAdmissao());
			System.out.println("");
		}
	}

	@Test
	@Ignore
	public void excluir() {

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(2L);

		if (funcionario == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			funcionarioDAO.excluir(funcionario);
			System.out.println("Funcionario excluído com sucesso.");
		}
	}

	@Test
	public void editar() throws ParseException {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(1L);

		if (funcionario == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			funcionario.setCarteiraTrabalho("012345678");
			funcionario.setDataAdmissao(new SimpleDateFormat("dd/MM/yyyy").parse("17/09/2016"));
			
			PessoaDAO pessoaDAO = new PessoaDAO();
			Pessoa pessoa = pessoaDAO.buscar(2L);
			
			funcionario.setPessoa(pessoa);
			
			funcionarioDAO.editar(funcionario);
			
			System.out.println("Cadastro editado com sucesso.");
		}
	}
}
