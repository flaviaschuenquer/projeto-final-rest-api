package org.serratec.backend.ProjetoFinal.dto;

import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.ProjetoFinal.domain.Categoria;


public class CategoriaDTO {
	
	private long id;
	private String nome;
	
	
	public CategoriaDTO(long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public CategoriaDTO(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}


	public CategoriaDTO() {	
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static List<CategoriaDTO> convert(List<Categoria> categorias){
		List<CategoriaDTO> categoriasDto = new ArrayList<>();
		for (Categoria categoria : categorias) {
			CategoriaDTO categoriaDto = new CategoriaDTO(categoria);
			categoriasDto.add(categoriaDto);			
		}
		return categoriasDto;
	}

	public Categoria createCategoria() {
		return null;
	}

		
}

