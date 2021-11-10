package org.serratec.backend.ProjetoFinal.Controllers;


import org.serratec.backend.ProjetoFinal.domain.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;



import java.net.URI;
import java.util.List;
import java.util.Optional;


import org.serratec.backend.ProjetoFinal.dto.CategoriaDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<Object> get() {
		List<Categoria> categorias = categoriaService.listar();		
		return ResponseEntity.ok(CategoriaDTO.convert(categorias));
	}
	

	@GetMapping("{id}")
	public ResponseEntity<Object> get(@PathVariable("id") long id) {
		Optional<Categoria> categoria = categoriaService.getById(id);
		
		if(categoria.isPresent())
		{
			return ResponseEntity.ok(new CategoriaDTO(categoria.get()));	
		}
		
		return ResponseEntity.notFound().build();		
	}

	@PostMapping
	// Retornar 201 - Criado
	// Retornar 422 - NÃ£o foi possivel processar a requisiÃ§Ã£o.
	public ResponseEntity<Object> criar(@RequestBody CategoriaDTO categoriaInserirDTO) throws Exception {

		Categoria categoria = categoriaInserirDTO.createCategoria();
		categoria = categoriaService.inserir(categoria);

		URI uri = 
				ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(categoria.getId())
				.toUri();

		return ResponseEntity.created(uri).body(new CategoriaDTO(categoria));

	}
}



/*@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@PostMapping
	@ApiOperation(value = "Criar nova categoria")
	@ApiResponses(value= {
			@ApiResponse(code = 201, message = "retornar todos"),
			@ApiResponse(code = 40, message = "request error"),
	})
	public Categoria criate(@Valid @RequestBody Categoria categoria) {
		return categoriaRepository.save(categoria);
		
		
	}
	*/


