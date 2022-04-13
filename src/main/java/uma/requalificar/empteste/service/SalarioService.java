package uma.requalificar.empteste.service;

import static java.lang.Float.NaN;
import static java.lang.Long.parseLong;

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
	
	public ListaResposta removeSalario(String id) {
		ListaResposta listaResposta = new ListaResposta();
		try {
			Long id_long = parseLong(id);

			if (id == null || id_long == NaN || salarioRepository.findById(id_long).isEmpty()) {
				listaResposta.addMsg("ID de salário inexistente ou fora de formato.");
				return (listaResposta);
			}

			salarioRepository.delete(salarioRepository.findById(id_long).get());
			listaResposta.setStatusOk(true);
			return (listaResposta);

		} catch (Exception e) {
			listaResposta.addMsg("o ID tem de ser um n.º longo.");
			return (listaResposta);
		}

	}

}
