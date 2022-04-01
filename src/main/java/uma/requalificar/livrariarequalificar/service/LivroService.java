package uma.requalificar.livrariarequalificar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.livrariarequalificar.dto.ListaResposta;
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


	public ListaResposta addLivro (Livro livro)
	{
		ListaResposta listaResposta = new ListaResposta();

		if (livro.getTitulo ().isBlank () )
		{
			listaResposta.addMsg("Título não preenchido.");
			return listaResposta;
		}

		if (livro.getSinopse ().isBlank () )
		{
			listaResposta.addMsg("Sinopse não preenchida.");
			return listaResposta;
		}

		if (livro.getEdicao ().isBlank () )
		{
			listaResposta.addMsg("Edição não preenchida.");
			return listaResposta;
		}

		if (livro.getImagem_capa ().isBlank () )
		{
			listaResposta.addMsg("Tem de escolher uma imagem de capa.");
			return listaResposta;
		}

		if (livro.getNum_paginas () <= 0 )
		{
			listaResposta.addMsg("O número de páginas tem de ser maior que zero.");
			return listaResposta;
		}

		if (livro.getPreco () <= 0 )
		{
			listaResposta.addMsg("O preço tem de ser maior que zero.");
			return listaResposta;
		}

		if (livro.getIsbn ().isBlank () )
		{
			listaResposta.addMsg("ISBN não preenchido.");
			return listaResposta;
		}

		if (livro.getAutores ().size () ==0 )
		{
			listaResposta.addMsg("Tem de escolher pelo menos um autor.");
			return listaResposta;
		}

		for (Livro livroAux: getLivros())
		{
			if (livroAux.getTitulo().equals(livro.getTitulo()))
			{
				listaResposta.addMsg( "Já existe um livro com este título.");
				return listaResposta;
			}
		}

		livro.setAtivo(true);
		
		livroRepository.save (livro);
		listaResposta.setNewID(livro.getId());
		listaResposta.setStatusOk(true);
		return listaResposta;
	}


}
