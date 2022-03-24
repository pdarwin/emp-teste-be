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
	public ResponseEntity<ListaResposta> addEditora (@RequestBody Editora editora)
	{

		ListaResposta sResponse = new ListaResposta ();

		if (editora.getId () != null)
		{
			sResponse.addMsg ("Ao adicionar um item, o ID tem de ser nulo.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (sResponse);
		}

		if ( (editora.getNome () == null) )
		{
			sResponse.addMsg ("Nome nulo.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (sResponse);
		}
		
		if ( (editora.getMorada () == null) )
		{
			sResponse.addMsg ("Morada nula.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (sResponse);
		}

		
		String msg = editoraService.addEditora (editora);

		if (!msg.isBlank () )
		{
			sResponse.addMsg (msg);
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (sResponse);
		} 
		else
		{
			sResponse.setStatusOk (true);
			sResponse.setLista (editoraService.getEditoras () );
			return ResponseEntity.status (HttpStatus.OK).body (sResponse);
		}

	}
  
    
}
