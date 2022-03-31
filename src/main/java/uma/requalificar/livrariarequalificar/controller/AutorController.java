package uma.requalificar.livrariarequalificar.controller;

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

import uma.requalificar.livrariarequalificar.dto.ListaResposta;
import uma.requalificar.livrariarequalificar.dto.SimpleResponse;
import uma.requalificar.livrariarequalificar.model.Autor;
import uma.requalificar.livrariarequalificar.service.AutorService;


@RestController
@CrossOrigin
public class AutorController 
{
	private final AutorService autorService;

	
	@Autowired
	public AutorController (AutorService autorService)
	{
		this.autorService = autorService;
	}

	
    @GetMapping ("/getAutores")
	@CrossOrigin
    public List<Autor> getAutores ()
    {
		return autorService.getAutores ();
    }
 
    
    @PostMapping ("/addAutor/{editora_id}")
    @CrossOrigin
	public ResponseEntity<ListaResposta> addAutor (@RequestBody Autor autor, @PathVariable String editora_id)
	{
    	ListaResposta listaResposta = new ListaResposta ();

		if (autor.getId () != null)
		{
			listaResposta.addMsg ("ID autor não nulo.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (listaResposta);
		}

		if (editora_id == null || editora_id.isBlank () )
		{
			listaResposta.addMsg ("ID da Editora não preenchido.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (listaResposta);
		}

		listaResposta = autorService.addAutor (autor, editora_id);

		if (!listaResposta.isStatusOk() )
		{
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (listaResposta);
		} 
		else
		{
			return ResponseEntity.status (HttpStatus.OK).body (listaResposta);
		}

	}

    
 /*   @DeleteMapping ("/deleteAutor/{id}")
	public ResponseEntity<SimpleResponse> removePessoa (@PathVariable String id)
	{

		SimpleResponse sResponse = new SimpleResponse ();

		String msg = autorService.deleteAutor (id);

		if (!msg.isBlank () )
		{
			sResponse.addMsg (msg);
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (sResponse);
		} 
		else
		{
			sResponse.setStatusOk (true);
			return ResponseEntity.status (HttpStatus.OK).body (sResponse);
		}

	} 
*/
 
    
}
