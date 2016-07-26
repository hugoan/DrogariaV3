package br.com.drogaria.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogariav3.dao.ItemVendaDAO;
import br.com.drogariav3.dao.ProdutoDAO;
import br.com.drogariav3.dao.VendaDAO;
import br.com.drogariav3.domain.ItemVenda;
import br.com.drogariav3.domain.Produto;
import br.com.drogariav3.domain.Venda;

public class ItemVendaDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Long codigoVenda = 2L;
		Long codigoProduto = 1L;

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(codigoVenda);

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigoProduto);

		if (venda == null || produto == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			ItemVenda itemVenda = new ItemVenda();
			itemVenda.setVenda(venda);
			itemVenda.setProduto(produto);
			itemVenda.setQuantidade(new Short("2"));
			itemVenda.setPrecoParcial(new BigDecimal("27.40"));

			ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
			itemVendaDAO.salvar(itemVenda);
			System.out.println("Item registrado com sucesso.");
		}
	}

	@Test
	@Ignore
	public void listar() {
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		List<ItemVenda> resultado = itemVendaDAO.listar();

		if (resultado.size() == 0) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			for (ItemVenda itemVenda : resultado) {
				System.out.println("Código da Venda: "
						+ itemVenda.getVenda().getCodigo());
				System.out.println("Cliente: "
						+ itemVenda.getVenda().getCliente().getPessoa()
								.getNome());
				System.out.println("Vendedor: "
						+ itemVenda.getVenda().getFuncionario().getPessoa()
								.getNome());
				System.out.println("Produto: "
						+ itemVenda.getProduto().getDescricao());
				System.out.println("Quantidade: " + itemVenda.getQuantidade());
				System.out.println("Preço Parcial: "
						+ itemVenda.getPrecoParcial());
				System.out.println("");
			}

		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		ItemVenda itemVenda = itemVendaDAO.buscar(codigo);

		if (itemVenda == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Código da Venda: "
					+ itemVenda.getVenda().getCodigo());
			System.out.println("Cliente: "
					+ itemVenda.getVenda().getCliente().getPessoa().getNome());
			System.out.println("Vendedor: "
					+ itemVenda.getVenda().getFuncionario().getPessoa()
							.getNome());
			System.out.println("Produto: "
					+ itemVenda.getProduto().getDescricao());
			System.out.println("Quantidade: " + itemVenda.getQuantidade());
			System.out.println("Preço Parcial: " + itemVenda.getPrecoParcial());
			System.out.println("");
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;

		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		ItemVenda itemVenda = itemVendaDAO.buscar(codigo);

		if (itemVenda == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			itemVendaDAO.excluir(itemVenda);
			System.out.println("Registro excluído com sucesso!");
		}
	}

	@Test
	public void editar() {
		Long codigo = 1L;

		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		ItemVenda itemVenda = itemVendaDAO.buscar(codigo);

		if (itemVenda == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			itemVenda.setQuantidade(new Short("3"));
			itemVenda.setPrecoParcial(new BigDecimal("41.10"));

			itemVendaDAO.editar(itemVenda);

			System.out.println("Registro atualizado com sucesso!");
		}
	}

}
