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
import uma.requalificar.livrariarequalificar.model.Livro;
import uma.requalificar.livrariarequalificar.service.LivroService;


@RestController
@CrossOrigin
public class LivroController 
{
	private final LivroService livroService;

	
	@Autowired
	public LivroController (LivroService livroService)
	{
		this.livroService = livroService;
	}
	
	
    @GetMapping ("/getLivros")
	@CrossOrigin
    public List<Livro> getLivros ()
    {
		return livroService.getLivros ();
    }
   
    
    @PostMapping ("/addLivro")
	@CrossOrigin
	public ResponseEntity<ListaResposta> addLivro (@RequestBody Livro livro)
	{
    	ListaResposta simpleResponse = new ListaResposta ();

		if (livro.getId () != null)
		{
			simpleResponse.addMsg ("Ao adicionar um livro, o ID tem de ser nulo.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (simpleResponse);
		}

		if ( (livro.getTitulo () == null) )
		{
			simpleResponse.addMsg ("Título nulo.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (simpleResponse);
		}

		if ( (livro.getData_lancamento () == null) )
		{
			simpleResponse.addMsg ("Data de lançamento nula.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (simpleResponse);
		}
		
		if ( (livro.getEdicao () == null) )
		{
			simpleResponse.addMsg ("Edição nula.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (simpleResponse);
		}

		if ( (livro.getImagem_capa () == null) )
		{
			simpleResponse.addMsg ("Imagem de capa nula.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (simpleResponse);
		}
		
		if ( (livro.getIsbn () == null) )
		{
			simpleResponse.addMsg ("ISBN nulo.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (simpleResponse);
		}
		
		if ( (livro.getSinopse () == null) )
		{
			simpleResponse.addMsg ("Sinopse nula.");
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (simpleResponse);
		}
		
		String msg = livroService.addLivro (livro);

		if (!msg.isBlank () )
		{
			simpleResponse.addMsg (msg);
			return ResponseEntity.status (HttpStatus.BAD_REQUEST).body (simpleResponse);
		} 
		else
		{
			simpleResponse.setStatusOk (true);
			simpleResponse.setLista (livroService.getLivros () );
			return ResponseEntity.status (HttpStatus.OK).body (simpleResponse);
		}

	}
  
    
}
