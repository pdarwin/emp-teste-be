package uma.requalificar.livrariarequalificar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uma.requalificar.livrariarequalificar.dto.ListaResposta;
import uma.requalificar.livrariarequalificar.model.Compra;
import uma.requalificar.livrariarequalificar.model.Editora;
import uma.requalificar.livrariarequalificar.service.CompraService;


@RestController
@CrossOrigin
public class CompraController 
{
	private final CompraService compraService;

	
	@Autowired
	public CompraController (CompraService compraService)
	{
		this.compraService = compraService;
	}

	
    @GetMapping ("/getCompras")
	@CrossOrigin
    public List<Compra> getCompras ()
    {
		return compraService.getCompras ();
    }
 
    @PostMapping ("/addCompra/{cliente_id}")
    @CrossOrigin
	public ResponseEntity<ListaResposta> addCompra (@RequestBody Compra compra,  @PathVariable String cliente_id)
	{

		ListaResposta listaResposta = new ListaResposta ();

		if (compra.getId () != null)
		{
			listaResposta.addMsg ("ID compra não nulo.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (listaResposta);
		}

		if (cliente_id == null || cliente_id.isBlank () )
		{
			listaResposta.addMsg ("ID do cliente não preenchido.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (listaResposta);
		}

		listaResposta = compraService.addCompra (compra, cliente_id);

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

