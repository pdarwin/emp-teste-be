package uma.requalificar.empteste.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.empteste.dto.ListaResposta;
import uma.requalificar.empteste.model.Pessoa;
import uma.requalificar.empteste.model.Empresa;
import uma.requalificar.empteste.repository.PessoaRepository;
import uma.requalificar.empteste.repository.EmpresaRepository;

@Service
public class PessoaService {
	private final PessoaRepository pessoaRepository;
	private final EmpresaRepository empresaRepository;

	@Autowired
	public PessoaService(PessoaRepository pessoaRepository, EmpresaRepository empresaRepository) {
		this.pessoaRepository = pessoaRepository;
		this.empresaRepository = empresaRepository;
	}

	public List<Pessoa> getPessoas() {
		List<Pessoa> pessoas = new ArrayList<>();
		pessoaRepository.findAll().forEach(pessoas::add);

		return pessoas;
	}

	// Regras de Negócio

	public ListaResposta addPessoa(Pessoa pessoa, String empresa_id) {
		ListaResposta listaResposta = new ListaResposta();

		if (pessoa.getNome().isBlank()) {
			listaResposta.addMsg("Nome não preenchido.");
			return listaResposta;
		}

		if (pessoa.getEmail().isBlank()) {
			listaResposta.addMsg("Email não preenchido.");
			return listaResposta;
		}

		for (Pessoa pessoaAux : getPessoas()) {
			if (pessoaAux.getNome().equals(pessoa.getNome())) {
				listaResposta.addMsg("Já existe um pessoa com este nome.");
				return listaResposta;
			}

		}

		Empresa empresa = empresaRepository.findById(Long.parseLong(empresa_id)).get();
		pessoa.setEmpresa(empresa);


		pessoaRepository.save(pessoa);
		listaResposta.setNewID(pessoa.getId());
		listaResposta.setStatusOk(true);
		return listaResposta;
	}


}
