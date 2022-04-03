package uma.requalificar.livrariarequalificar.service;

import static java.lang.Long.parseLong;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.livrariarequalificar.dto.ListaResposta;
import uma.requalificar.livrariarequalificar.model.Autor;
import uma.requalificar.livrariarequalificar.model.Editora;
import uma.requalificar.livrariarequalificar.model.Livro;
import uma.requalificar.livrariarequalificar.repository.AutorRepository;
import uma.requalificar.livrariarequalificar.repository.EditoraRepository;

@Service
public class AutorService 
{
	private final AutorRepository autorRepository;
	private final EditoraRepository editoraRepository;
	
	@Autowired
	public AutorService (AutorRepository autorRepository, EditoraRepository editoraRepository)
	{
		this.autorRepository = autorRepository;
		this.editoraRepository = editoraRepository;
	}
	
	
	public List<Autor> getAutores ()
	{
		List<Autor> autores = new ArrayList<> ();
		autorRepository.findAll ().forEach (autores::add);

		return autores;
	}
	
	// Regras de Negócio
	
	public ListaResposta addAutor (Autor autor, String editora_id) 
	{
		ListaResposta listaResposta = new ListaResposta(); 
		
		if (autor.getNome ().isBlank () )
		{
			listaResposta.addMsg( "Nome não preenchido.");
			return listaResposta;
		}
		
		if (autor.getEmail ().isBlank () )
		{
			listaResposta.addMsg( "Email não preenchido.");
			return listaResposta;
		}
		
		for (Autor autorAux: getAutores())
		{
			if (autorAux.getNome().equals(autor.getNome()))
			{
				listaResposta.addMsg( "Já existe um autor com este nome.");
				return listaResposta;
			}
		}
	
		Editora editora = editoraRepository.findById(Long.parseLong (editora_id)).get();
		autor.setEditora(editora);
		
		autor.setAtivo(true);
		
		autorRepository.save (autor);
		listaResposta.setNewID(autor.getId());
		listaResposta.setStatusOk(true);
		return listaResposta;
	}

	
	
/*	public String deleteAutor (String id) 
 * {
		try
		{
			Long id_long = parseLong (id);

			if (id == null || id_long == NaN || autorRepository.findById (id_long).isEmpty () )
			{
				return "ID de andar inexistente ou fora de formato.";
			}

			Autor autor = autorRepository.findById (id_long).get ();
			autorRepository.delete (autor);
			return "";

		} 
		catch (Exception e)
		{
			return "o ID tem de ser um n.º longo.";
		}
	}
*/
	
	
}
