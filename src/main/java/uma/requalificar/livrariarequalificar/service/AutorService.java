package uma.requalificar.livrariarequalificar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.livrariarequalificar.model.Autor;
import uma.requalificar.livrariarequalificar.repository.AutorRepository;

@Service
public class AutorService {
	
	private final AutorRepository autorRepository;

	@Autowired
	public AutorService (AutorRepository autorRepository)
	{
		this.autorRepository = autorRepository;
	}
	
	public List<Autor> getAutores()
	{
		List<Autor> autores = new ArrayList<>();
		autorRepository.findAll().forEach(autores::add);

		return autores;
	}
	
}
