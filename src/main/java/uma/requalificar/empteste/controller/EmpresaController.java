package uma.requalificar.empteste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uma.requalificar.empteste.dto.ListaResposta;
import uma.requalificar.empteste.dto.SimpleResponse;
import uma.requalificar.empteste.model.Empresa;
import uma.requalificar.empteste.service.EmpresaService;


@RestController
@CrossOrigin
public class EmpresaController 
{
	private final EmpresaService empresaService;

	
	@Autowired
	public EmpresaController (EmpresaService empresaService)
	{
		this.empresaService = empresaService;
	}

	
    @GetMapping ("/getEmpresas")
	@CrossOrigin
    public List<Empresa> getEmpresas ()
    {
		return empresaService.getEmpresas ();
    }

    
    @PostMapping ("/addEmpresa")
    @CrossOrigin
	public ResponseEntity<ListaResposta> addEmpresa (@RequestBody Empresa empresa)
	{

		ListaResposta listaResposta = new ListaResposta ();

		if (empresa.getId () != null)
		{
			listaResposta.addMsg ("Ao adicionar um item, o ID tem de ser nulo.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (listaResposta);
		}

		if ( (empresa.getNome () == null) )
		{
			listaResposta.addMsg ("Nome nulo.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (listaResposta);
		}
		
		if ( (empresa.getMorada () == null) )
		{
			listaResposta.addMsg ("Morada nula.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (listaResposta);
		}

		
		listaResposta = empresaService.addEmpresa (empresa);

		if (!listaResposta.isStatusOk() )
		{
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (listaResposta);
		} 
		else
		{
			return ResponseEntity.status (HttpStatus.OK).body (listaResposta);
		}

	}
    
    
	/*
	 * @CrossOrigin
	 * 
	 * @PutMapping ("/updateEmpresa/{id}") public ResponseEntity<SimpleResponse>
	 * updateEmpresa (@PathVariable String id) {
	 * 
	 * ListaResposta listaResposta = empresaService.updateEmpresa (id);
	 * 
	 * if (!listaResposta.isStatusOk() ) { return ResponseEntity.status
	 * (HttpStatus.BAD_REQUEST).body (listaResposta); } else { return
	 * ResponseEntity.status (HttpStatus.OK).body (listaResposta); }
	 * 
	 * }
	 */
    
    @CrossOrigin
    @DeleteMapping ("/deleteEmpresa/{id}")
	public ResponseEntity<SimpleResponse> removeEmpresa (@PathVariable String id)
	{

		SimpleResponse simpleResponse = new SimpleResponse ();

		String msg = empresaService.deleteEmpresa (id);

		if (!msg.isBlank () )
		{
			simpleResponse.addMsg (msg);
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (simpleResponse);
		} 
		else
		{
			simpleResponse.setStatusOk (true);
			return ResponseEntity.status (HttpStatus.OK).body (simpleResponse);
		}

	}
        
    
    
}
