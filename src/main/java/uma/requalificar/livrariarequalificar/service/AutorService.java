package uma.requalificar.livrariarequalificar.service;

import java.util.ArrayList;
import java.util.List;

//import static java.lang.Float.NaN;
//import static java.lang.Long.parseLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.livrariarequalificar.model.Autor;
import uma.requalificar.livrariarequalificar.repository.AutorRepository;

@Service
public class AutorService 
{
	private final AutorRepository autorRepository;

	
	@Autowired
	public AutorService (AutorRepository autorRepository)
	{
		this.autorRepository = autorRepository;
	}
	
	public List<Autor> getAutores ()
	{
		List<Autor> autores = new ArrayList<> ();
		autorRepository.findAll ().forEach (autores::add);

		return autores;
	}

	public String addAutor (Autor autor, String editora_id) 
	{
		autorRepository.save (autor);
		return "";
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
