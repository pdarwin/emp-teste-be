package uma.requalificar.livrariarequalificar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.livrariarequalificar.model.Cupao;
import uma.requalificar.livrariarequalificar.repository.CupaoRepository;

@Service
public class CupaoService {

	private final CupaoRepository cupaoRepository;

	@Autowired
	public CupaoService(CupaoRepository cupaoRepository)
	{
		this.cupaoRepository = cupaoRepository;
	}
	
	public List<Cupao> getCupoes()
	{
		List<Cupao> cupoes = new ArrayList<>();
		cupaoRepository.findAll().forEach(cupoes::add);

		return cupoes;
	}
	
}
