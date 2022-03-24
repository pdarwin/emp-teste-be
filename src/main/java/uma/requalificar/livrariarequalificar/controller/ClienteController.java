package uma.requalificar.livrariarequalificar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uma.requalificar.livrariarequalificar.dto.ListaResposta;
import uma.requalificar.livrariarequalificar.model.Cliente;
import uma.requalificar.livrariarequalificar.service.ClienteService;


@RestController
@CrossOrigin
public class ClienteController 
{
	private final ClienteService clienteService;

	
	@Autowired
	public ClienteController (ClienteService clienteService)
	{
		this.clienteService = clienteService;
	}
	
	
    @GetMapping("/getClientes")
	@CrossOrigin
    public List<Cliente> getClientes()
    {
		return clienteService.getClientes();
    }
    
    
    @PostMapping("/regCliente")
	@CrossOrigin
	public ResponseEntity<ListaResposta> regCliente(@RequestBody Cliente cliente)
	{
    	ListaResposta sResponse = new ListaResposta();

		if (cliente.getId() != null)
		{
			sResponse.addMsg("Ao adicionar um cliente, o ID tem de ser nulo.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sResponse);
		}
		
		if ((cliente.getNome() == null))
		{
			sResponse.addMsg("Nome nulo.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sResponse);
		}
	
		if ((cliente.getEmail() == null))
		{
			sResponse.addMsg("Email nulo.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sResponse);
		}
		
		if ((cliente.getPassword() == null))
		{
			sResponse.addMsg("Password nula.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sResponse);
		}
		
		if ((cliente.getMorada() == null))
		{
			sResponse.addMsg("Morada nula.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sResponse);
		}

		if ((cliente.getData_nascimento() == null))
		{
			sResponse.addMsg("Data de nascimento nula.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sResponse);
		}
		
		String msg = clienteService.regCliente(cliente);

		if (!msg.isBlank())
		{
			sResponse.addMsg(msg);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sResponse);
		} 
		else
		{
			sResponse.setStatusOk(true);
			sResponse.setLista(clienteService.getClientes());
			return ResponseEntity.status(HttpStatus.OK).body(sResponse);
		}

	}
    
}

