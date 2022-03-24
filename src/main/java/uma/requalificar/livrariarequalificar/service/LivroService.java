package uma.requalificar.livrariarequalificar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.livrariarequalificar.model.Livro;
import uma.requalificar.livrariarequalificar.repository.LivroRepository;

@Service
public class LivroService {

	private final LivroRepository livroRepository;

	@Autowired
	public LivroService (LivroRepository livroRepository)
	{
		this.livroRepository = livroRepository;
	}
	
	public List<Livro> getLivros()
	{
		List<Livro> livros = new ArrayList<>();
		livroRepository.findAll().forEach(livros::add);

		return livros;
	}
	
}
