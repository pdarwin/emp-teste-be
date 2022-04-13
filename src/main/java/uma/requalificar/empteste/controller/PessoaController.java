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
import uma.requalificar.empteste.model.Pessoa;
import uma.requalificar.empteste.service.PessoaService;


@RestController
@CrossOrigin
public class PessoaController 
{
	private final PessoaService pessoaService;

	
	@Autowired
	public PessoaController (PessoaService pessoaService)
	{
		this.pessoaService = pessoaService;
	}

	
    @GetMapping ("/getPessoasByEmpresa/{empresa_id}")
	@CrossOrigin
    public List<Pessoa> getPessoasByEmpresa (@PathVariable String empresa_id)
    {
		return pessoaService.getPessoasByEmpresa (empresa_id);
    }
    
    
    @PostMapping ("/addPessoa/{empresa_id}")
    @CrossOrigin
	public ResponseEntity<ListaResposta> addPessoa (@RequestBody Pessoa pessoa, @PathVariable String empresa_id)
	{
    	ListaResposta listaResposta = new ListaResposta ();

		if (pessoa.getId () != null)
		{
			listaResposta.addMsg ("ID pessoa não nulo.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (listaResposta);
		}

		if (empresa_id == null || empresa_id.isBlank () )
		{
			listaResposta.addMsg ("ID da empresa não preenchido.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (listaResposta);
		}

		listaResposta = pessoaService.addPessoa (pessoa, empresa_id);

		if (!listaResposta.isStatusOk() )
		{
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (listaResposta);
		} 
		else
		{
			return ResponseEntity.status (HttpStatus.OK).body (listaResposta);
		}

	}

    
	@CrossOrigin
	@DeleteMapping("/removePessoa/{id}")
	public ResponseEntity<SimpleResponse> removePessoa(@PathVariable String id) {

		ListaResposta listaResposta = pessoaService.removePessoa(id);

		if (!listaResposta.isStatusOk()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaResposta);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(listaResposta);
		}

	}
    
}
