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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uma.requalificar.livrariarequalificar.dto.ListaResposta;
import uma.requalificar.livrariarequalificar.dto.SimpleResponse;
import uma.requalificar.livrariarequalificar.model.Editora;
import uma.requalificar.livrariarequalificar.service.EditoraService;


@RestController
@CrossOrigin
public class EditoraController 
{
	private final EditoraService editoraService;

	
	@Autowired
	public EditoraController (EditoraService editoraService)
	{
		this.editoraService = editoraService;
	}

	
    @GetMapping ("/getEditoras")
	@CrossOrigin
    public List<Editora> getEditoras ()
    {
		return editoraService.getEditoras ();
    }

    
    @PostMapping ("/addEditora")
    @CrossOrigin
	public ResponseEntity<ListaResposta> addEditora (@RequestBody Editora editora)
	{

		ListaResposta listaResposta = new ListaResposta ();

		if (editora.getId () != null)
		{
			listaResposta.addMsg ("Ao adicionar um item, o ID tem de ser nulo.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (listaResposta);
		}

		if ( (editora.getNome () == null) )
		{
			listaResposta.addMsg ("Nome nulo.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (listaResposta);
		}
		
		if ( (editora.getMorada () == null) )
		{
			listaResposta.addMsg ("Morada nula.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (listaResposta);
		}

		
		listaResposta = editoraService.addEditora (editora);

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
	 * @PutMapping ("/updateEditora/{id}") public ResponseEntity<SimpleResponse>
	 * updateEmpresa (@PathVariable String id) {
	 * 
	 * ListaResposta listaResposta = editoraService.updateEditora (id);
	 * 
	 * if (!listaResposta.isStatusOk() ) { return ResponseEntity.status
	 * (HttpStatus.BAD_REQUEST).body (listaResposta); } else { return
	 * ResponseEntity.status (HttpStatus.OK).body (listaResposta); }
	 * 
	 * }
	 */
    
    @CrossOrigin
    @DeleteMapping ("/deleteEditora/{id}")
	public ResponseEntity<SimpleResponse> removeEditora (@PathVariable String id)
	{

		SimpleResponse simpleResponse = new SimpleResponse ();

		String msg = editoraService.deleteEditora (id);

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
