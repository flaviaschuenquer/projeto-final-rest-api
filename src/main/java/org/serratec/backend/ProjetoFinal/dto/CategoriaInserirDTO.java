package org.serratec.backend.ProjetoFinal.dto;

import org.serratec.backend.ProjetoFinal.domain.Categoria;

public class CategoriaInserirDTO {
	
		private String nome;

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public Categoria createCategoria() {
			return new Categoria( this.nome);
		}
}
