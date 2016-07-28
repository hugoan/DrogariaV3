package br.com.drogariav3.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogariav3.dao.ClienteDAO;
import br.com.drogariav3.dao.PessoaDAO;
import br.com.drogariav3.domain.Cliente;
import br.com.drogariav3.domain.Pessoa;

public class ClienteDAOTest {

	@Test
	@Ignore
	public void salvar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);

		if (pessoa == null) {
			System.out.println("Nenhum registro de pessoa encontrado.");
		} else {

			Cliente cliente = new Cliente();
			cliente.setDataCadastro(new Date());
			cliente.setLiberado(false);
			cliente.setPessoa(pessoa);

			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.salvar(cliente);

			System.out.println("Cliente cadastrado com sucesso.");

		}
	}

	@Test
	@Ignore
	public void listar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> resultado = clienteDAO.listar();

		if (resultado.size() == 0) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			for (Cliente cliente : resultado) {

				System.out.println("Cliente: " + cliente.getPessoa().getNome());
				System.out.println("Data do Cadastro: "
						+ cliente.getDataCadastro());
				System.out.println("Liberado: " + cliente.getLiberado());
				System.out.println("");
			}
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);

		if (cliente == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Cliente: " + cliente.getPessoa().getNome());
			System.out
					.println("Data do Cadastro: " + cliente.getDataCadastro());
			System.out.println("Liberado: " + cliente.getLiberado());
			System.out.println("");
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);

		if (cliente == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			clienteDAO.excluir(cliente);
			System.out.println("Cliente excluido com sucesso.");
		}
	}

	@Test
	public void editar() {
		Long codigo = 1L;

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);

		if (cliente == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			cliente.setLiberado(false);
			clienteDAO.editar(cliente);

			System.out.println("Cadastro editado com sucesso.");
		}

	}

}
