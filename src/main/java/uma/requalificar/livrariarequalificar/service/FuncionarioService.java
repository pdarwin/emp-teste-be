package uma.requalificar.livrariarequalificar.service;

import org.springframework.beans.factory.annotation.Autowired;

import uma.requalificar.livrariarequalificar.repository.FuncionarioRepository;

public class FuncionarioService {

	private final FuncionarioRepository fRepository;

	@Autowired
	public FuncionarioService(FuncionarioRepository fRepository)
	{
		this.fRepository = fRepository;
	}
	
}
