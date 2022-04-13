package uma.requalificar.empteste.service;

import static java.lang.Float.NaN;
import static java.lang.Long.parseLong;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.empteste.dto.ListaResposta;
import uma.requalificar.empteste.model.Empresa;
import uma.requalificar.empteste.repository.EmpresaRepository;

@Service
public class EmpresaService 
{

	private final EmpresaRepository empresaRepository;

	
	@Autowired
	public EmpresaService (EmpresaRepository empresaRepository)
	{
		this.empresaRepository = empresaRepository;
	}
	
	
	public List<Empresa> getEmpresas ()
	{
		List<Empresa> empresas = new ArrayList<> ();
		empresaRepository.findAll ().forEach (empresas::add);

		return empresas;
	}
	
	// Regras de Negócio
	
	public ListaResposta addEmpresa (Empresa empresa) 
	{
		ListaResposta listaResposta = new ListaResposta(); 
		
		if (empresa.getNome ().isBlank () )
		{
			listaResposta.addMsg( "Nome não preenchido.");
			return listaResposta;
		}
		
		if (empresa.getMorada ().isBlank () )
		{
			listaResposta.addMsg( "Morada não preenchida.");
			return listaResposta;
		}
		
		for (Empresa empresaAux: getEmpresas())
		{
			if (empresaAux.getNome().equals(empresa.getNome()))
			{
				listaResposta.addMsg( "Já existe uma empresa com este nome.");
				return listaResposta;
			}
		}

		
		empresaRepository.save (empresa);
		listaResposta.setNewID(empresa.getId());
		listaResposta.setStatusOk(true);
		return listaResposta;
	}
	
	
	public ListaResposta  updateEmpresa (String id) 
	{
		ListaResposta listaResposta = new ListaResposta(); 
		try
		{
			Long id_long = parseLong (id);

			if (id == null || id_long == NaN || empresaRepository.findById (id_long).isEmpty () )
			{
				listaResposta.addMsg("ID de empresa inexistente ou fora de formato.");
				return (listaResposta);
			}

			Empresa empresa = empresaRepository.findById (id_long).get ();
			empresaRepository.save(empresa);
			listaResposta.setStatusOk(true);
			return (listaResposta);

		} 
		catch (Exception e)
		{
			listaResposta.addMsg("o ID tem de ser um n.º longo.");
			return (listaResposta);
		}

	}

	
	public String deleteEmpresa (String id)
	{
		try
		{
			Long id_long = parseLong (id);

			if (id == null || id_long == NaN || empresaRepository.findById (id_long).isEmpty () )
			{
				return "ID de empresa inexistente ou fora de formato.";
			}
			
			
			Empresa empresa = empresaRepository.findById (id_long).get ();
			empresaRepository.delete (empresa);
			return "";

		} 
		catch (Exception e)
		{
			return "o ID tem de ser um n.º longo.";
		}

	}
	
	
}

	
	
	
	
//	public boolean updateEmpresa(Empresa empresa) {
//        Optional<Empresa> empresaOptional = getEmpresa(empresa);
//        if (empresaOptional.isEmpty()){
//            return false;
//        }
//
//        Empresa empresaToUpdate = empresaOptional.get();
//
//        if (empresa.getNome()!= null && !empresa.getNome().isBlank()){
//            empresaToUpdate.setNome(empresa.getNome());
//        }
//
//        if (empresa.getMorada()!= null && !empresa.getMorada().isBlank()){
//            empresaToUpdate.setMorada(empresa.getMorada());
//        }
//
//        empresaRepository.save(empresa);
//
//        return true;
//    }
//
//	private Optional<Empresa> getEmpresa(Empresa empresa) {
//		return empresaRepository.findById(empresa.getId());
//		
//		if (empresa.getId()!= null) {
//
//
//        ArrayList<Empresa> empresasAux = new ArrayList<>();
//        empresaRepository.findAll().forEach(empresasAux::add);
//
//        for (Empresa aux : empresasAux) {
//            if (aux.getId().equals(empresa.getId())) {
//                return Optional.of(aux);
//            }
//
//    }
//
//    return Optional.empty();} 
//}

	

	

