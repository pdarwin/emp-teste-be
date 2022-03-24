package uma.requalificar.livrariarequalificar.service;

import org.springframework.beans.factory.annotation.Autowired;

import uma.requalificar.livrariarequalificar.repository.AutorRepository;

public class AutorService {
	
	private final AutorRepository aRepository;

	@Autowired
	public AutorService (AutorRepository aRepository)
	{
		this.aRepository = aRepository;
	}
	

}
