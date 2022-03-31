package uma.requalificar.livrariarequalificar.service;

import static java.lang.Float.NaN;
import static java.lang.Long.parseLong;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.livrariarequalificar.dto.ListaResposta;
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

	
	public ListaResposta addEditora (Editora editora) 
	{
		ListaResposta listaResposta = new ListaResposta(); 
		
		if (editora.getNome ().isBlank () )
		{
			listaResposta.addMsg( "Nome não preenchido.");
			return listaResposta;
		}
		
		if (editora.getMorada ().isBlank () )
		{
			listaResposta.addMsg( "Morada não preenchida.");
			return listaResposta;
		}
		
		for (Editora editoraAux: getEditoras())
		{
			if (editoraAux.getNome().equals(editora.getNome()))
			{
				listaResposta.addMsg( "Já existe uma editora com este nome.");
				return listaResposta;
			}
		}
		
		editora.setAtivo(true);
		
		editoraRepository.save (editora);
		listaResposta.setNewID(editora.getId());
		listaResposta.setStatusOk(true);
		return listaResposta;
	}
	
	// Estou a passar o update como se fosse um delete!!! Mudar?!
	public ListaResposta  updateEditora (String id) 
	{
		ListaResposta listaResposta = new ListaResposta(); 
		try
		{
			Long id_long = parseLong (id);

			if (id == null || id_long == NaN || editoraRepository.findById (id_long).isEmpty () )
			{
				listaResposta.addMsg("ID de editora inexistente ou fora de formato.");
				return (listaResposta);
			}

			Editora editora = editoraRepository.findById (id_long).get ();
			editoraRepository.save(editora);
			listaResposta.setStatusOk(true);
			return (listaResposta);

		} 
		catch (Exception e)
		{
			listaResposta.addMsg("o ID tem de ser um n.º longo.");
			return (listaResposta);
		}

	}

	
	public String deleteEditora (String id)
	{
		try
		{
			Long id_long = parseLong (id);

			if (id == null || id_long == NaN || editoraRepository.findById (id_long).isEmpty () )
			{
				return "ID de editora inexistente ou fora de formato.";
			}
			
			
			Editora editora = editoraRepository.findById (id_long).get ();
			editora.setAtivo(false);
			editoraRepository.delete (editora);
			return "";

		} 
		catch (Exception e)
		{
			return "o ID tem de ser um n.º longo.";
		}

	}
	
	
}

	
	
	
	
//	public boolean updateEditora(Editora editora) {
//        Optional<Editora> editoraOptional = getEditora(editora);
//        if (editoraOptional.isEmpty()){
//            return false;
//        }
//
//        Editora editoraToUpdate = editoraOptional.get();
//
//        if (editora.getNome()!= null && !editora.getNome().isBlank()){
//            editoraToUpdate.setNome(editora.getNome());
//        }
//
//        if (editora.getMorada()!= null && !editora.getMorada().isBlank()){
//            editoraToUpdate.setMorada(editora.getMorada());
//        }
//
//        editoraRepository.save(editora);
//
//        return true;
//    }
//
//	private Optional<Editora> getEditora(Editora editora) {
//		return editoraRepository.findById(editora.getId());
//		
//		if (editora.getId()!= null) {
//
//
//        ArrayList<Editora> editorasAux = new ArrayList<>();
//        editoraRepository.findAll().forEach(editorasAux::add);
//
//        for (Editora aux : editorasAux) {
//            if (aux.getId().equals(editora.getId())) {
//                return Optional.of(aux);
//            }
//
//    }
//
//    return Optional.empty();} 
//}

	

	

