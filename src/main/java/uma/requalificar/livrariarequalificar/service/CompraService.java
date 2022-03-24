package uma.requalificar.livrariarequalificar.service;

import org.springframework.beans.factory.annotation.Autowired;

import uma.requalificar.livrariarequalificar.repository.CompraRepository;

public class CompraService {
	
	private final CompraRepository compraRepository;

	@Autowired
	public CompraService (CompraRepository compraRepository)
	{
		this.compraRepository = compraRepository;
	}

}
