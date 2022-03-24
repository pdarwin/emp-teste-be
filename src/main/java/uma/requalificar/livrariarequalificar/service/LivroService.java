package uma.requalificar.livrariarequalificar.service;

import org.springframework.beans.factory.annotation.Autowired;

import uma.requalificar.livrariarequalificar.repository.LivroRepository;

public class LivroService {

	private final LivroRepository lRepository;

	@Autowired
	public LivroService (LivroRepository lRepository)
	{
		this.lRepository = lRepository;
	}
	
}
