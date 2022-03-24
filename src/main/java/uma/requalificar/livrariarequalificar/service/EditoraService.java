package uma.requalificar.livrariarequalificar.service;

import org.springframework.beans.factory.annotation.Autowired;

import uma.requalificar.livrariarequalificar.repository.EditoraRepository;

public class EditoraService {

	private final EditoraRepository eRepository;

	@Autowired
	public EditoraService(EditoraRepository eRepository)
	{
		this.eRepository = eRepository;
	}
	
}
