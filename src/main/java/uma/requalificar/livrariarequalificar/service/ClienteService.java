package uma.requalificar.livrariarequalificar.service;

import org.springframework.beans.factory.annotation.Autowired;

import uma.requalificar.livrariarequalificar.repository.ClienteRepository;

public class ClienteService {
	
	private final ClienteRepository clienteRepository;

	@Autowired
	public ClienteService (ClienteRepository clienteRepository)
	{
		this.clienteRepository = clienteRepository;
	}	

}
