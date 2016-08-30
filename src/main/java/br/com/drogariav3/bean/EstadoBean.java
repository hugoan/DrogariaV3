package br.com.drogariav3.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.drogariav3.dao.EstadoDAO;
import br.com.drogariav3.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {
	private Estado estado;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void novo() {
		estado = new Estado();
	}

	public void salvar() {
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.salvar(estado);

			novo();

			Messages.addFlashGlobalInfo("Estado salvo com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar um estado");
			erro.printStackTrace();
		}
	}

}
