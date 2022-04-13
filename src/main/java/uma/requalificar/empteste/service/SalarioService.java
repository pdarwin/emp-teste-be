package uma.requalificar.empteste.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.empteste.dto.ListaResposta;
import uma.requalificar.empteste.model.Salario;
import uma.requalificar.empteste.repository.SalarioRepository;

@Service
public class SalarioService {
	private final SalarioRepository salarioRepository;

	@Autowired
	public SalarioService(SalarioRepository salarioRepository) {
		this.salarioRepository = salarioRepository;
	}
	
	
	public List<Salario> getSalarios() {
		List<Salario> salarios = new ArrayList<>();
		salarioRepository.findAll().forEach(salarios::add);

		return salarios;
	}
	
	// Regras de Negócio

	public ListaResposta addSalario(Salario salario) {
		ListaResposta listaResposta = new ListaResposta();


		salarioRepository.save(salario);
		listaResposta.setNewID(salario.getId());
		listaResposta.setStatusOk(true);
		return listaResposta;
	}

}
