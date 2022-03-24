package uma.requalificar.livrariarequalificar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.livrariarequalificar.model.Editora;
import uma.requalificar.livrariarequalificar.repository.EditoraRepository;

@Service
public class EditoraService 
{
	private final EditoraRepository editoraRepository;

	
	@Autowired
	public EditoraService (EditoraRepository editoraRepository)
	{
		this.editoraRepository = editoraRepository;
	}
	
	public List<Editora> getEditoras ()
	{
		List<Editora> editoras = new ArrayList<> ();
		editoraRepository.findAll ().forEach (editoras::add);

		return editoras;
	}

	
	public String addEditora (Editora editora) 
	{
		if (editora.getNome ().isBlank () )
			return "Nome não preenchido.";
		
		if (editora.getMorada ().isBlank () )
			return "Morada não preenchida.";
		
		
		editoraRepository.save (editora);
		return "";
	}

	
}
