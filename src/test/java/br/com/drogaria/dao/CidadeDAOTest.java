package br.com.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogariav3.dao.CidadeDAO;
import br.com.drogariav3.dao.EstadoDAO;
import br.com.drogariav3.domain.Cidade;
import br.com.drogariav3.domain.Estado;

public class CidadeDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(1L);
		
		Cidade cidade = new Cidade();
		cidade.setNome("Ceilândia");
		cidade.setEstado(estado);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);
	}
	
	@Test
	@Ignore
	public void listar(){
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.listar();
		
		for(Cidade cidade : resultado){
			
			System.out.println("Código: " + cidade.getCodigo() + " Cidade: " + cidade.getNome() + " Estado: " + cidade.getEstado().getNome() + "/" + cidade.getEstado().getSigla());
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		if(cidade == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			System.out.println("Código: " + cidade.getCodigo());
			System.out.println("Cidade: " + cidade.getNome());
			System.out.println("Estado: " + cidade.getEstado().getNome() + "/" + cidade.getEstado().getSigla());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 5L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		if(cidade == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			cidadeDAO.excluir(cidade);
			System.out.println("Cidade removida: " + cidade.getNome());
		}
	}
	
	@Test
	public void editar(){
		Long codigoCidade = 4L;
		
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
		
		if(cidade == null){
			System.out.println("Nenhum registro encontrado.");
		}else{
			System.out.println("Cidade a ser editada: " + cidade.getNome() + "/" + cidade.getEstado().getSigla());
			Long codigoEstado = 5L;
			EstadoDAO estadoDAO = new EstadoDAO();
			Estado estado = estadoDAO.buscar(codigoEstado);
			
			cidade.setNome("Campinas");
			cidade.setEstado(estado);
			cidadeDAO.editar(cidade);
			
			System.out.println("Cidade: " + cidade.getNome() + "/" + cidade.getEstado().getSigla());
		}
	}

}
