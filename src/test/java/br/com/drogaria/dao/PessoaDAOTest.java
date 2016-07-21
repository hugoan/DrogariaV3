package br.com.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogariav3.dao.CidadeDAO;
import br.com.drogariav3.dao.PessoaDAO;
import br.com.drogariav3.domain.Cidade;
import br.com.drogariav3.domain.Pessoa;

public class PessoaDAOTest {

	@Test
	
	public void salvar() {

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(2L);

		if (cidade == null) {
			System.out.println("Nenhum registro de cidade encontrado.");
		} else {
			Pessoa pessoa = new Pessoa();
			pessoa.setNome("Nathália Pinto Nóbrega");
			pessoa.setCpf("004.644.211-10");
			pessoa.setRg("0000000 DF");
			pessoa.setRua("QNO 15 Conj A");
			pessoa.setNumero(new Short("5"));
			pessoa.setBairro("Setor O");
			pessoa.setCep("72255-601");
			pessoa.setComplemento("Casa");
			pessoa.setTelefone("61 3374-7397");
			pessoa.setCelular("61 98110-5023");
			pessoa.setEmail("nathaliapnobrega@gmail.com");
			pessoa.setCidade(cidade);

			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.salvar(pessoa);

		}
	}

	@Test
	@Ignore
	public void listar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> resultado = pessoaDAO.listar();

		if (resultado.size() == 0) {
			System.out.println("Nenhum registro encontrado.");
		} else {

			for (Pessoa pessoa : resultado) {
				System.out.println("Nome: " + pessoa.getNome());
				System.out.println("CPF: " + pessoa.getCpf());
				System.out.println("RG: " + pessoa.getRg());
				System.out.println("Rua: " + pessoa.getRua());
				System.out.println("Complemento: " + pessoa.getComplemento());
				System.out.println("Número: " + pessoa.getNumero());
				System.out.println("Bairro: " + pessoa.getBairro());
				System.out.println("Cidade: " + pessoa.getCidade().getNome());
				System.out.println("Estado: "
						+ pessoa.getCidade().getEstado().getSigla());
				System.out.println("CEP: " + pessoa.getCep());
				System.out.println("Telefone: " + pessoa.getTelefone());
				System.out.println("Celular: " + pessoa.getCelular());
				System.out.println("E-mail: " + pessoa.getEmail());
				System.out.println("-------------------------------------");

			}

		}

	}

	@Test
	@Ignore
	public void buscar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);

		if (pessoa == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("CPF: " + pessoa.getCpf());
			System.out.println("RG: " + pessoa.getRg());
			System.out.println("Rua: " + pessoa.getRua());
			System.out.println("Complemento: " + pessoa.getComplemento());
			System.out.println("Número: " + pessoa.getNumero());
			System.out.println("Bairro: " + pessoa.getBairro());
			System.out.println("Cidade: " + pessoa.getCidade().getNome());
			System.out.println("Estado: "
					+ pessoa.getCidade().getEstado().getSigla());
			System.out.println("CEP: " + pessoa.getCep());
			System.out.println("Telefone: " + pessoa.getTelefone());
			System.out.println("Celular: " + pessoa.getCelular());
			System.out.println("E-mail: " + pessoa.getEmail());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(3L);

		if (pessoa == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			pessoaDAO.excluir(pessoa);
			System.out.println("Cadastro excluído com sucesso!");
		}
	}

	@Test
	@Ignore
	public void editar() {

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(3L);

		if (pessoa == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			CidadeDAO cidadeDAO = new CidadeDAO();
			Cidade cidade = cidadeDAO.buscar(1L);
			
			pessoa.setNome("Nathália Pinto Nóbrega");
			pessoa.setCpf("000.000.000-00");
			pessoa.setRg("0000000 DF");
			pessoa.setRua("CAS Chacara 122");
			pessoa.setNumero(new Short("303"));
			pessoa.setBairro("Vicente Pires");
			pessoa.setCep("72010-000");
			pessoa.setComplemento("Apt");
			pessoa.setTelefone("61 3374-7397");
			pessoa.setCelular("61 98110-5023");
			pessoa.setEmail("nathaliapnobrega@gmail.com");
			pessoa.setCidade(cidade);

			pessoaDAO.editar(pessoa);
			
			System.out.println("Cadastro editado com sucesso.");
		}
	}
}
