package br.com.drogaria.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogariav3.dao.ClienteDAO;
import br.com.drogariav3.dao.FuncionarioDAO;
import br.com.drogariav3.dao.VendaDAO;
import br.com.drogariav3.domain.Cliente;
import br.com.drogariav3.domain.Funcionario;
import br.com.drogariav3.domain.Venda;

public class VendaDAOTest {

	@Test
	@Ignore
	public void salvar() {

		Long codigoCliente = 1L;
		Long codigoFuncionario = 2L;

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigoCliente);

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigoFuncionario);

		if (cliente == null || funcionario == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			Venda venda = new Venda();
			venda.setHorario(new Date());
			venda.setValorTotal(new BigDecimal("100.00"));
			venda.setFuncionario(funcionario);
			venda.setCliente(cliente);

			VendaDAO vendaDAO = new VendaDAO();

			vendaDAO.salvar(venda);

			System.out.println("Venda cadastrada com sucesso!");
		}

	}

	@Test
	@Ignore
	public void listar() {
		VendaDAO vendaDAO = new VendaDAO();
		List<Venda> resultado = vendaDAO.listar();

		if (resultado.size() == 0) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			for (Venda venda : resultado) {
				System.out.println("Cliente: "
						+ venda.getCliente().getPessoa().getNome());
				System.out.println("Funcionário: "
						+ venda.getFuncionario().getPessoa().getNome());
				System.out.println("Valor Total: " + venda.getValorTotal());
				System.out.println("Data: " + venda.getHorario());
				System.out.println("");
			}
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 2L;

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(codigo);

		if (venda == null) {
			System.out.println("Nenhum registo encontrado.");
		} else {
			System.out.println("Cliente: "
					+ venda.getCliente().getPessoa().getNome());
			System.out.println("Funcionário: "
					+ venda.getFuncionario().getPessoa().getNome());
			System.out.println("Valor Total: " + venda.getValorTotal());
			System.out.println("Data: " + venda.getHorario());
		}
	}

	@Test
	public void excluir() {
		Long codigo = 3L;

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(codigo);

		if (venda == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			vendaDAO.excluir(venda);
			System.out.println("Venda excluída com sucesso.");
		}
	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 2L;

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(codigo);

		if (venda == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			venda.setHorario(new Date());
			venda.setValorTotal(new BigDecimal("276.57"));

			vendaDAO.editar(venda);
			System.out.println("Cadastro de venda alterado com sucesso.");
		}
	}
}
