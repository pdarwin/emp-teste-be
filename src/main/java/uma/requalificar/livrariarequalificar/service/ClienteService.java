package uma.requalificar.livrariarequalificar.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.livrariarequalificar.dto.ListaResposta;
import uma.requalificar.livrariarequalificar.model.Cliente;
import uma.requalificar.livrariarequalificar.repository.ClienteRepository;
import uma.requalificar.livrariarequalificar.utils.Utils;

@Service
public class ClienteService {
	private final ClienteRepository clienteRepository;

	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	
	public List<Cliente> getClientes() {
		List<Cliente> clientes = new ArrayList<>();
		clienteRepository.findAll().forEach(clientes::add);

		return clientes;
	}
	
	// Regras de Negócio

	public ListaResposta addCliente(Cliente cliente) {
		ListaResposta listaResposta = new ListaResposta();

		if (cliente.getNome().isBlank()) {
			listaResposta.addMsg("Nome não preenchido.");
			return listaResposta;
		}

		if (cliente.getEmail().isBlank()) {
			listaResposta.addMsg("Email não preenchido.");
			return listaResposta;
		}

		if (!Utils.validateEmail(cliente.getEmail())) {
			listaResposta.addMsg("Email inválido.");
			return listaResposta;
		}

		if (cliente.getPassword().isBlank()) {
			listaResposta.addMsg("Palavra-passe não preenchida.");
			return listaResposta;
		}

		if (!Utils.validatePassword(cliente.getPassword())) {
			listaResposta
					.addMsg("Palavra-passe inválida." + " A palavra-passe deve ter entre 8 e 20 caracteres, e conter"
							+ " pelo menos uma letra minúscula, uma letra maiúscula e um dígito");
			return listaResposta;
		}

		for (Cliente clienteAux : getClientes()) {
			if (clienteAux.getEmail().equals(cliente.getEmail())) {
				listaResposta.addMsg("Já existe um cliente registado com este email");
				return listaResposta;
			}
		}

		LocalDate dataMaxima = LocalDate.now();

		LocalDate dataMinima = dataMaxima.minusYears(120);

		if (dataMinima.compareTo(cliente.getData_nascimento().toLocalDate()) > 0
				|| dataMaxima.compareTo(cliente.getData_nascimento().toLocalDate()) <= 0) {
			listaResposta.addMsg("Data de nascimento inválida.");
			return listaResposta;
		}

		// Encriptar password
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		cliente.setPassword(passwordEncoder.encode(cliente.getPassword()));

		cliente.setAtivo(true);

		clienteRepository.save(cliente);
		listaResposta.setNewID(cliente.getId());
		listaResposta.setStatusOk(true);
		return listaResposta;
	}

	public ListaResposta loginCliente(Cliente cliente) {

		ListaResposta listaResposta = new ListaResposta();

		if (cliente.getEmail().isBlank()) {
			listaResposta.addMsg("Email não preenchido.");
			return listaResposta;
		}

		if (cliente.getPassword().isBlank()) {
			listaResposta.addMsg("Palavra-passe não preenchida.");
			return listaResposta;
		}

		for (Cliente clienteAux : getClientes()) {
			if (clienteAux.getEmail().equals(cliente.getEmail())) {
				// Testar password
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				if (!passwordEncoder.matches(cliente.getPassword(), clienteAux.getPassword())) {
					listaResposta.addMsg("Palavra-passe errada.");
					return listaResposta;
				} else if (!clienteAux.isAtivo()) {
					listaResposta.addMsg("Cliente inativo.");
					return listaResposta;
				} else {
					listaResposta.setNewID(clienteAux.getId());
					listaResposta.setStatusOk(true);
					return listaResposta;
				}

			}

		}

		listaResposta.addMsg("Email incorreto ou inexistente.");
		return listaResposta;
	}

}
