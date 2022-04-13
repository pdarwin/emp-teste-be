package uma.requalificar.empteste.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.empteste.dto.ListaResposta;
import uma.requalificar.empteste.model.Pessoa;
import uma.requalificar.empteste.model.Salario;
import uma.requalificar.empteste.repository.PessoaRepository;
import uma.requalificar.empteste.repository.SalarioRepository;

@Service
public class SalarioService {
	private final SalarioRepository salarioRepository;
	private final PessoaRepository pessoaRepository;

	@Autowired
	public SalarioService(SalarioRepository salarioRepository, PessoaRepository pessoaRepository) {
		this.salarioRepository = salarioRepository;
		this.pessoaRepository = pessoaRepository;
	}
	
	
	public List<Salario> getSalarios() {
		List<Salario> salarios = new ArrayList<>();
		salarioRepository.findAll().forEach(salarios::add);

		return salarios;
	}
	
	public List<Salario> getSalariosByPessoa(String pessoa_id) {

		return pessoaRepository.findById(Long.parseLong(pessoa_id)).get().getSalarios();
		
	}
	
	public ListaResposta addSalario(Salario salario,String pessoa_id) {
		ListaResposta listaResposta = new ListaResposta();

		Pessoa pessoa = pessoaRepository.findById(Long.parseLong(pessoa_id)).get();
		salario.setPessoa(pessoa);

		salarioRepository.save(salario);
		listaResposta.setNewID(salario.getId());
		listaResposta.setStatusOk(true);
		return listaResposta;
	}

}
