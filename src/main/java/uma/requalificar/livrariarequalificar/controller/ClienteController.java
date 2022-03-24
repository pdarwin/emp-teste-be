package uma.requalificar.livrariarequalificar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import uma.requalificar.livrariarequalificar.model.Cliente;
import uma.requalificar.livrariarequalificar.service.ClienteService;

@RestController
@CrossOrigin
public class ClienteController {

	private final ClienteService clienteService;
	
	@Autowired
	public ClienteController (ClienteService clienteService)
	{
		this.clienteService = clienteService;
	}
	
    @GetMapping("/getClientes")
	@CrossOrigin
    public List<Cliente> getClientes(){
		return clienteService.getClientes();
    }
    
}

