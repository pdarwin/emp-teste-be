package uma.requalificar.livrariarequalificar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.livrariarequalificar.model.Livro;
import uma.requalificar.livrariarequalificar.repository.LivroRepository;

@Service
public class LivroService 
{
	private final LivroRepository livroRepository;

	
	@Autowired
	public LivroService (LivroRepository livroRepository)
	{
		this.livroRepository = livroRepository;
	}
	
	public List<Livro> getLivros ()
	{
		List<Livro> livros = new ArrayList<> ();
		livroRepository.findAll ().forEach (livros::add);

		return livros;
	}
	
	
	public String addLivro (Livro livro)
	{
		if (livro.getTitulo ().isBlank () )
			return "Título não preenchido.";
		
		if (livro.getSinopse ().isBlank () )
			return "Sinopse não preenchida.";
		
		if (livro.getEdicao ().isBlank () )
			return "Edição não preenchida.";

		if (livro.getImagem_capa ().isBlank () )
			return "Tem de escolher uma imagem de capa.";
		
		if (livro.getNum_paginas () <= 0 )
			return "O número de páginas tem de ser maior que zero.";

		if (livro.getPreco () <= 0 )
			return "O preço tem de ser maior que zero.";

		if (livro.getIsbn ().isBlank () )
			return "ISBN não preenchido.";
		
		if (livro.getAutores ().size () ==0 )
			return "Não foi escolhido nenhum autor.";
		
		
		livroRepository.save (livro);
		return "";
	}
	
	
}
