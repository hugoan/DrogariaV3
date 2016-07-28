package br.com.drogariav3.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogariav3.dao.FabricanteDAO;
import br.com.drogariav3.domain.Fabricante;

public class FabricanteDAOTest {

	@Test
	public void salvar() {
		Fabricante fabricante1 = new Fabricante();
		Fabricante fabricante2 = new Fabricante();
		Fabricante fabricante3 = new Fabricante();
		fabricante1.setDescricao("Biosintética");
		fabricante2.setDescricao("Unicom");
		fabricante3.setDescricao("Neo Química");

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante1);
		fabricanteDAO.salvar(fabricante2);
		fabricanteDAO.salvar(fabricante3);

	}

	@Test
	@Ignore
	public void listar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> resultado = fabricanteDAO.listar();

		for (Fabricante fabricante : resultado) {
			System.out.println(fabricante.getDescricao());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 3L;

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);

		if (fabricante == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("O fabricante selecionado é: "
					+ fabricante.getDescricao());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 3L;

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);

		if (fabricante == null) {
			System.out
					.println("Nenhum registro encontrado");
		} else {
			fabricanteDAO.excluir(fabricante);
			System.out.println("O fabricante " + fabricante.getDescricao()
					+ " foi removido com sucesso!");
		}
	}
	
	@Test
	@Ignore
	public void editar(){
		long codigo = 2L;
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if(fabricante == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			System.out.println("O fabricante " + fabricante.getDescricao() + " foi alterado para: ");
			fabricante.setDescricao("Neo Química");
			fabricanteDAO.editar(fabricante);
			
			fabricante = fabricanteDAO.buscar(codigo);
			System.out.println(fabricante);
		}
	}
}
