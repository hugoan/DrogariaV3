package br.com.drogaria.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogariav3.dao.FabricanteDAO;
import br.com.drogariav3.dao.ProdutoDAO;
import br.com.drogariav3.domain.Fabricante;
import br.com.drogariav3.domain.Produto;

public class ProdutoDAOTest {
	@Test
	@Ignore
	public void salvar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(new Long("3"));

		Produto produto = new Produto();
		produto.setDescricao("Cataflan 50mg com 20 Comprimidos");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal("13.70"));
		produto.setQuantidade(new Short("7"));

		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);

		System.out.println("Produto salvo com sucesso");
	}

	@Test
	@Ignore
	public void listar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> resultado = produtoDAO.listar();

		for (Produto produto : resultado) {
			System.out.println("Descrição: " + produto.getDescricao());
			System.out.println("Fabricante: "
					+ produto.getFabricante().getDescricao());
			System.out.println("Quantidade: " + produto.getQuantidade());
			System.out.println("Preço: " + produto.getPreco());
			System.out.println("");
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 3L;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);

		if (produto == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Descrição: " + produto.getDescricao());
			System.out.println("Fabricante: "
					+ produto.getFabricante().getDescricao());
			System.out.println("Quantidade: " + produto.getQuantidade());
			System.out.println("Preço: " + produto.getPreco());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 3L;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);

		if (produto == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			produtoDAO.excluir(produto);
			System.out.println("Produto excluído com sucesso!");
		}

	}

	@Test
	public void editar() {
		Long codigoProduto = 1L;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigoProduto);

		if (produto == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			Long codigoFabricante = 2L;
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			Fabricante fabricante = fabricanteDAO.buscar(codigoFabricante);

			produto.setDescricao("Cataflan Plus 200mg");
			produto.setFabricante(fabricante);
			produto.setQuantidade(new Short("62"));
			produto.setPreco(new BigDecimal("7.40"));

			produtoDAO.editar(produto);
		}
	}

}
