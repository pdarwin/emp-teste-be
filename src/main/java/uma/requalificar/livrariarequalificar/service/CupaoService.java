package uma.requalificar.livrariarequalificar.service;

import static java.lang.Float.NaN;
import static java.lang.Long.parseLong;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.livrariarequalificar.dto.ListaResposta;
import uma.requalificar.livrariarequalificar.model.Cupao;
import uma.requalificar.livrariarequalificar.repository.CupaoRepository;

@Service
public class CupaoService 
{
	private final CupaoRepository cupaoRepository;

	
	@Autowired
	public CupaoService (CupaoRepository cupaoRepository)
	{
		this.cupaoRepository = cupaoRepository;
	}
	
	
	public List<Cupao> getCupoes ()
	{
		List<Cupao> cupoes = new ArrayList<> ();
		cupaoRepository.findAll ().forEach (cupoes::add);

		return cupoes;
	}
	
	public ListaResposta getCupoesByClienteId(String cliente_id) {
		ListaResposta listaResposta = new ListaResposta();

		try {
			List<Cupao> cupoes = new ArrayList<>();
			cupaoRepository.findAll().forEach(cupoes::add);

			List<Cupao> cupoesByCliente = new ArrayList<>();
			for (Cupao cupao : cupoes) {
				if (cupao.getCliente().getId() == Long.parseLong(cliente_id) && cupao.isAtivo()) {
					cupoesByCliente.add(cupao);
				}
			}
			listaResposta.setLista(cupoesByCliente);
			return listaResposta;

		} catch (NumberFormatException e) {
			listaResposta.addMsg("Erro de formato no ID do cupao");
			return listaResposta;
		}
	}
	
	public ListaResposta  remCupao (String id) 
	{
		ListaResposta listaResposta = new ListaResposta(); 
		try
		{
			Long id_long = parseLong (id);

			if (id == null || id_long == NaN || cupaoRepository.findById (id_long).isEmpty () )
			{
				listaResposta.addMsg("ID de cupão inexistente ou fora de formato.");
				return (listaResposta);
			}

			Cupao cupao = cupaoRepository.findById (id_long).get ();
			cupao.setAtivo(false);
			cupaoRepository.save(cupao);
			listaResposta.setStatusOk(true);
			return (listaResposta);

		} 
		catch (Exception e)
		{
			listaResposta.addMsg("o ID tem de ser um n.º longo.");
			return (listaResposta);
		}

	}

	
}
