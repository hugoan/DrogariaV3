package br.com.drogariav3.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogariav3.dao.EstadoDAO;
import br.com.drogariav3.domain.Estado;

public class EstadoDAOTest {

	@Test
	
	public void salvar() {
		Estado estado1 = new Estado();
		Estado estado2 = new Estado();
		Estado estado3 = new Estado();
		Estado estado4 = new Estado();
		
		estado1.setNome("Distrito Federal");
		estado1.setSigla("DF");
		
		estado2.setNome("Minas Gerais");
		estado2.setSigla("MG");
		
		estado3.setNome("Paraíba");
		estado3.setSigla("PB");
		
		estado4.setNome("Rio Grande do Norte");
		estado4.setSigla("RN");

		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado1);
		estadoDAO.salvar(estado2);
		estadoDAO.salvar(estado3);
		estadoDAO.salvar(estado4);
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
	@Ignore
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
