package br.com.drogariav3.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import br.com.drogariav3.dao.FabricanteDAO;
import br.com.drogariav3.domain.Fabricante;

@Path("fabricante")
public class FabricanteService {

	// http://http://localhost:8080/DrogariaV3/rest/fabricante
	@GET
	public String listar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> fabricantes = fabricanteDAO.listar("descricao");

		Gson gson = new Gson();
		String json = gson.toJson(fabricantes);

		return json;

	}

	// http://localhost:8080/DrogariaV3/rest/fabricante/codigo => no lugar do
	// código informo o id que quero buscar
	// http://localhost:8080/DrogariaV3/rest/fabricante/2 => Exemplo
	@GET
	@Path("{codigo}") // Cada vez que coloco o path é uma barra no endereço.
	public String buscar(@PathParam("codigo") Long codigo) {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);

		Gson gson = new Gson();
		String json = gson.toJson(fabricante);

		return json;
	}

	// http://http://localhost:8080/DrogariaV3/rest/fabricante
	@POST
	public String salvar(String json) {
		Gson gson = new Gson();
		Fabricante fabricante = gson.fromJson(json, Fabricante.class);

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante);

		String jsonSaida = gson.toJson(fabricante);

		return jsonSaida;
	}

	// http://http://localhost:8080/DrogariaV3/rest/fabricante
	@PUT
	public String editar(String json) {
		Gson gson = new Gson();
		Fabricante fabricante = gson.fromJson(json, Fabricante.class);

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.editar(fabricante);

		String jsonSaida = gson.toJson(fabricante);

		return jsonSaida;
	}

	// http://localhost:8080/DrogariaV3/rest/fabricante/codigo
	@DELETE
	public String excluir(String json) {
		Gson gson = new Gson();
		Fabricante fabricante = gson.fromJson(json, Fabricante.class);

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricante = fabricanteDAO.buscar(fabricante.getCodigo());
		fabricanteDAO.excluir(fabricante);

		String saida = gson.toJson(fabricante);

		return saida;
	}

}
