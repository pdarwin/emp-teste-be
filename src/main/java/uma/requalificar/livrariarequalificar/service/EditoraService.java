package uma.requalificar.livrariarequalificar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	
/*	public boolean updateEditora(Editora editora) {
        Optional<Editora> editoraOptional = getEditora(editora);
        if (editoraOptional.isEmpty()){
            return false;
        }

        Editora editoraToUpdate = editoraOptional.get();

        if (editora.getNome()!= null && !editora.getNome().isBlank()){
            editoraToUpdate.setNome(editora.getNome());
        }

        if (editora.getMorada()!= null && !editora.getMorada().isBlank()){
            editoraToUpdate.setMorada(editora.getMorada());
        }

        editoraRepository.save(editora);

        return true;
    }

	private Optional<Editora> getEditora(Editora editora) {
		return editoraRepository.findById(editora.getId());
		
		if (editora.getId()!= null) {


        ArrayList<Editora> editorasAux = new ArrayList<>();
        editoraRepository.findAll().forEach(editorasAux::add);

        for (Editora aux : editorasAux) {
            if (aux.getId().equals(editora.getId())) {
                return Optional.of(aux);
            }

    }

    return Optional.empty();} 
} 
*/
	}

	

