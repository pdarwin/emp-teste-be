package uma.requalificar.livrariarequalificar.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.livrariarequalificar.model.Cliente;
import uma.requalificar.livrariarequalificar.repository.ClienteRepository;
import uma.requalificar.livrariarequalificar.utils.Utils;

@Service
public class ClienteService {
	
	private final ClienteRepository clienteRepository;

	@Autowired
	public ClienteService (ClienteRepository clienteRepository)
	{
		this.clienteRepository = clienteRepository;
	}
	
	public List<Cliente> getClientes()
	{
		List<Cliente> clientes = new ArrayList<>();
		clienteRepository.findAll().forEach(clientes::add);

		return clientes;
	}
	
	public String regCliente(Cliente cliente)
	{
		if (cliente.getNome().isBlank())
			return "Nome não preenchido.";
		
		if (cliente.getEmail().isBlank())
			return "Email não preenchido.";
		
		if (!Utils.validateEmail(cliente.getEmail()))
			return "Email inválido.";
		
		if (cliente.getPassword().isBlank())
			return "Palavra-passe não preenchida.";
		
		if (!Utils.validatePassword(cliente.getPassword()))
			return "Palavra-passe inválida. A palavra-passe deve ter entre 8 e 20 caracteres, e conter pelo menos uma letra minúscula, uma letra maiúscula e um dígito";
	
		
		LocalDate dataMaxima = LocalDate.now();
		
		LocalDate dataMinima = dataMaxima.minusYears(120);
		
		if (dataMinima.compareTo(cliente.getData_nascimento().toLocalDate()) > 0 || dataMaxima.compareTo(cliente.getData_nascimento().toLocalDate()) <= 0)
			return "Data de nascimento inválida.";
		
		//Encriptar password
		cliente.setPassword(Utils.encrypt(cliente.getPassword()));
		
		clienteRepository.save(cliente);
		return "";
	}

}
