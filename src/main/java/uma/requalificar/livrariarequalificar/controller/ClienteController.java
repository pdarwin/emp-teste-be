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
	
	
    @GetMapping ("/getClientes")
	@CrossOrigin
    public List<Cliente> getClientes ()
    {
		return clienteService.getClientes ();
    }
    
    // mudar para ("/registoCliente") ou ("/registarCliente") ??
    @PostMapping ("/regCliente")
	@CrossOrigin
	public ResponseEntity<ListaResposta> regCliente (@RequestBody Cliente cliente)
	{
    	ListaResposta simpleResponse = new ListaResposta ();

		if (cliente.getId() != null)
		{
			simpleResponse.addMsg ("Ao adicionar um cliente, o ID tem de ser nulo.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (simpleResponse);
		}
		
		if ( (cliente.getNome () == null) )
		{
			simpleResponse.addMsg ("Nome nulo.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (simpleResponse);
		}
	
		if ( (cliente.getEmail () == null) )
		{
			simpleResponse.addMsg ("Email nulo.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (simpleResponse);
		}
		
		if ( (cliente.getPassword () == null) )
		{
			simpleResponse.addMsg ("Password nula.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (simpleResponse);
		}
		
		if ( (cliente.getMorada () == null) )
		{
			simpleResponse.addMsg ("Morada nula.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (simpleResponse);
		}

		if ( (cliente.getData_nascimento () == null) )
		{
			simpleResponse.addMsg ("Data de nascimento nula.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (simpleResponse);
		}
		
		String msg = clienteService.regCliente (cliente);

		if (!msg.isBlank () )
		{
			simpleResponse.addMsg (msg);
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (simpleResponse);
		} 
		else
		{
			simpleResponse.setStatusOk (true);
			simpleResponse.setLista (clienteService.getClientes () );
			return ResponseEntity.status (HttpStatus.OK).body (simpleResponse);
		}

	}
    
}

