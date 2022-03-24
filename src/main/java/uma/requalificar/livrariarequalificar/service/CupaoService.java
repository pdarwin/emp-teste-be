package uma.requalificar.livrariarequalificar.service;

import org.springframework.beans.factory.annotation.Autowired;

import uma.requalificar.livrariarequalificar.repository.CupaoRepository;

public class CupaoService {

	private final CupaoRepository cupaoRepository;

	@Autowired
	public CupaoService(CupaoRepository cupaoRepository)
	{
		this.cupaoRepository = cupaoRepository;
	}
	
}
