package uma.requalificar.livrariarequalificar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import uma.requalificar.livrariarequalificar.dto.ListaResposta;
import uma.requalificar.livrariarequalificar.dto.SimpleResponse;
import uma.requalificar.livrariarequalificar.model.Cupao;
import uma.requalificar.livrariarequalificar.service.CupaoService;


@RestController
@CrossOrigin
public class CupaoController 
{
	private final CupaoService cupaoService;
	
	
	@Autowired
	public CupaoController (CupaoService cupaoService)
	{
		this.cupaoService = cupaoService;
	}

	
    @GetMapping ("/getCupoes")
	@CrossOrigin
    public List<Cupao> getCupoes ()
    {
		return cupaoService.getCupoes ();
    }
 
    @GetMapping("/getCupoesByClienteId/{cliente_id}")
	@CrossOrigin
	public ResponseEntity<ListaResposta> getCupoesByClienteId(@PathVariable String cliente_id) {
		ListaResposta listaResposta = new ListaResposta();

		if (cliente_id.isBlank()) {
			listaResposta.addMsg("O ID do cliente não pode ser nulo.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaResposta);
		}

		listaResposta = cupaoService.getCupoesByClienteId(cliente_id);

		listaResposta.setStatusOk(true);
		return ResponseEntity.status(HttpStatus.OK).body(listaResposta);

	}
    
    @CrossOrigin
    @PutMapping ("/remCupao/{id}")
    public ResponseEntity<SimpleResponse> remCupao (@PathVariable String id)
    {
        
        ListaResposta listaResposta = cupaoService.remCupao (id);

        if (!listaResposta.isStatusOk() )
		{
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (listaResposta);
		} 
		else
		{
			return ResponseEntity.status (HttpStatus.OK).body (listaResposta);
		}

	}

}
