package br.com.drogariav3.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.drogariav3.dao.CidadeDAO;
import br.com.drogariav3.dao.EstadoDAO;
import br.com.drogariav3.dao.PessoaDAO;
import br.com.drogariav3.domain.Cidade;
import br.com.drogariav3.domain.Estado;
import br.com.drogariav3.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable {
	private Pessoa pessoa;
	private List<Pessoa> pessoas;

	// variavel temporaria para guardar o estado selecionado pelo usuário e
	// carregar a listagem de cidades de acordo com o estado
	private Estado estado;

	private List<Estado> estados;
	private List<Cidade> cidades;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	@PostConstruct
	public void listar() {
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar("nome");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar as pessoas");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			pessoa = new Pessoa();
			estado = new Estado();

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar("nome");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar uma nova pessoa");
			erro.printStackTrace();
		}
		cidades = new ArrayList<Cidade>();
	}

	public void editar(ActionEvent evento) {
		pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionada");

		EstadoDAO estadoDAO = new EstadoDAO();
		estados = estadoDAO.listar("nome");

	}

	public void salvar() {
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.merge(pessoa);

			pessoas = pessoaDAO.listar("nome");

			pessoa = new Pessoa();

			estado = new Estado();
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar("nome");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a pessoa");
			erro.printStackTrace();
		}

	}

	public void excluir(ActionEvent evento) {
		try {
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionada");

			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.excluir(pessoa);

			pessoas = pessoaDAO.listar("nome");

			Messages.addGlobalInfo("Pessoa removida com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir a pessoa");
			erro.printStackTrace();
		}

	}

	public void popular() {
		try {
			if (estado != null) {
				CidadeDAO cidadeDAO = new CidadeDAO();
				cidades = cidadeDAO.buscarPorEstado(estado.getCodigo());
			} else {
				cidades = new ArrayList<>();
			}
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar filtrar as cidades");
			erro.printStackTrace();
		}

	}

}
