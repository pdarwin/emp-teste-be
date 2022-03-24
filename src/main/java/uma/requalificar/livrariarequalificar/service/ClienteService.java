package uma.requalificar.livrariarequalificar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.livrariarequalificar.model.Cliente;
import uma.requalificar.livrariarequalificar.repository.ClienteRepository;

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

}
