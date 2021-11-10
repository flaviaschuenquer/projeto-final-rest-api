package org.serratec.backend.ProjetoFinal.Controllers;

import java.util.List;
import java.util.Optional;


import org.serratec.backend.ProjetoFinal.domain.Categoria;
import org.serratec.backend.ProjetoFinal.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	public List<Categoria> listar(){
		return categoriaRepository.findAll();
	}
	
	public Optional<Categoria> getById(long id) {
		return categoriaRepository.findById(id);
	}

	public Categoria inserir(Categoria categoria) {
	
		return null;
	}
	
		
		
	
}


