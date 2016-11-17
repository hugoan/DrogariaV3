package br.com.drogariav3.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import br.com.drogariav3.dao.FabricanteDAO;
import br.com.drogariav3.domain.Fabricante;

@Path("fabricante")
public class FabricanteService {
	
	//http://http://localhost:8080/DrogariaV3/rest/fabricante
	@GET
	public String listar(){
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> fabricantes = fabricanteDAO.listar("descricao");
		
		Gson gson = new Gson();
		String json = gson.toJson(fabricantes);
		
		return json;
		
		
	}
	
	//http://localhost:8080/DrogariaV3/rest/fabricante/codigo => no lugar do código informo o id que quero buscar
	//http://localhost:8080/DrogariaV3/rest/fabricante/2 => Exemplo
	@GET
	@Path("{codigo}") //Cada vez que coloco o path é uma barra no endereço.
	public String buscar(@PathParam("codigo") Long codigo){
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		Gson gson = new Gson();
		String json = gson.toJson(fabricante);
		
		return json;
	}

}
