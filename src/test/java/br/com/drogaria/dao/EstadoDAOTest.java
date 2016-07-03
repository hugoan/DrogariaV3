package br.com.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogariav3.dao.EstadoDAO;
import br.com.drogariav3.domain.Estado;

public class EstadoDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Estado estado = new Estado();
		estado.setNome("São Paulo");
		estado.setSigla("SP");

		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}

	@Test
	@Ignore
	public void listar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();

		for (Estado estado : resultado) {
			System.out.println(estado.getNome() + " - " + estado.getSigla());

		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 3L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);

		if (estado == null) {
			System.out.println("Nenhum estado encontrado");
		} else {
			System.out.println("Registro encontrado: ");
			System.out.println(estado.getNome() + " - " + estado.getSigla());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 5L;

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);

		if (estado == null) {
			System.out.println("Nenhum estado encontrado.");
		} else {
			estadoDAO.excluir(estado);
			System.out.println("Estado " + estado.getNome()
					+ " removido com sucesso.");
		}
	}

	@Test
	public void editar() {
		Long codigo = 4L;

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);

		if (estado == null) {
			System.out.println("Nenhum registro encontrado;");
		} else {
			System.out.println("Estado " + estado.getNome() + "/"
					+ estado.getSigla() + " alterado para: ");
			estado.setNome("Minas Gerais");
			estado.setSigla("MG");
			estadoDAO.editar(estado);

			estado = estadoDAO.buscar(codigo);

			System.out.println(estado.getNome() + "/" + estado.getSigla());
		}

	}

}
