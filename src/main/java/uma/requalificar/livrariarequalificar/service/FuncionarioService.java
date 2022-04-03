package uma.requalificar.livrariarequalificar.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import uma.requalificar.livrariarequalificar.dto.ListaResposta;
import uma.requalificar.livrariarequalificar.model.Funcionario;
import uma.requalificar.livrariarequalificar.repository.FuncionarioRepository;
import uma.requalificar.livrariarequalificar.utils.Utils;

@Service
public class FuncionarioService {
	private final FuncionarioRepository funcionarioRepository;

	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	

	public List<Funcionario> getFuncionarios() {
		List<Funcionario> funcionarios = new ArrayList<>();
		funcionarioRepository.findAll().forEach(funcionarios::add);

		return funcionarios;
	}
	
	// Regras de Negócio

	public ListaResposta addFuncionario(Funcionario funcionario) {
		ListaResposta listaResposta = new ListaResposta();

		if (funcionario.getNome().isBlank()) {
			listaResposta.addMsg("Nome não preenchido.");
			return listaResposta;
		}

		if (funcionario.getPassword().isBlank()) {
			listaResposta.addMsg("Palavra-passe não preenchida.");
			return listaResposta;
		}

		if (!Utils.validatePassword(funcionario.getPassword())) {
			listaResposta
					.addMsg("Palavra-passe inválida." + " A palavra-passe deve ter entre 8 e 20 caracteres, e conter"
							+ " pelo menos uma letra minúscula, uma letra maiúscula e um dígito");
			return listaResposta;
		}

		LocalDate dataMaxima = LocalDate.now();

		LocalDate dataMinima = dataMaxima.minusYears(120);

		if (dataMinima.compareTo(funcionario.getData_nascimento().toLocalDate()) > 0
				|| dataMaxima.compareTo(funcionario.getData_nascimento().toLocalDate()) <= 0) {
			listaResposta.addMsg("Data de nascimento inválida.");
			return listaResposta;
		}

		// Encriptar password
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		funcionario.setPassword(passwordEncoder.encode(funcionario.getPassword()));

		funcionario.setAtivo(true);

		String username = genUsername(funcionario.getNome());
		funcionario.setUsername(username);

		funcionarioRepository.save(funcionario);
		listaResposta.setNewID(funcionario.getId());
		listaResposta.setNewUsername(funcionario.getUsername());
		listaResposta.setStatusOk(true);
		return listaResposta;
	}

	public ListaResposta loginFuncionario(Funcionario funcionario) {

		ListaResposta listaResposta = new ListaResposta();

		if (funcionario.getUsername().isBlank()) {
			listaResposta.addMsg("Username não preenchido.");
			return listaResposta;
		}

		if (funcionario.getPassword().isBlank()) {
			listaResposta.addMsg("Palavra-passe não preenchida.");
			return listaResposta;
		}

		for (Funcionario funcionarioAux : getFuncionarios()) {
			if (funcionarioAux.getUsername().equals(funcionario.getUsername())) {
				// Testar password
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				if (!passwordEncoder.matches(funcionario.getPassword(), funcionarioAux.getPassword())) {
					listaResposta.addMsg("Palavra-passe errada.");
					return listaResposta;
				} else if (!funcionarioAux.isAtivo()) {
					listaResposta.addMsg("Funcionario inativo.");
					return listaResposta;
				} else {
					listaResposta.setNewID(funcionarioAux.getId());
					listaResposta.setStatusOk(true);
					return listaResposta;
				}

			}

		}

		listaResposta.addMsg("Email incorreto ou inexistente.");
		return listaResposta;
	}

	private String genUsername(String username) {

		String usernameAux;

		if (username.indexOf(" ") > 0) {
			usernameAux = username.substring(0, username.indexOf(" "));
		} else {
			// Gera um random entre 0 e 9
			Random rand = new Random();
			int x = rand.nextInt(10);

			// acrescenta o random ao username, e prossegue com a testagem
			usernameAux = username + x;
		}

		for (Funcionario funcionario : getFuncionarios()) {
			if (funcionario.getUsername().equals(usernameAux)) {
				// Já existindo um utilizador com este username, prossegue a testagem
				// recursivamente
				return genUsername(usernameAux);

			}

		}
		return usernameAux;
	}

}
