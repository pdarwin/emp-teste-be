package uma.requalificar.livrariarequalificar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.livrariarequalificar.dto.ListaResposta;
import uma.requalificar.livrariarequalificar.model.Cliente;
import uma.requalificar.livrariarequalificar.model.Compra;
import uma.requalificar.livrariarequalificar.model.Cupao;
import uma.requalificar.livrariarequalificar.repository.ClienteRepository;
import uma.requalificar.livrariarequalificar.repository.CompraRepository;
import uma.requalificar.livrariarequalificar.repository.CupaoRepository;

@Service
public class CompraService 
{
	private final CompraRepository compraRepository;
	private final CupaoRepository cupaoRepository;
	private final ClienteRepository clienteRepository;
	
	@Autowired
	public CompraService (CompraRepository compraRepository, CupaoRepository cupaoRepository,ClienteRepository clienteRepository)
	{
		this.compraRepository = compraRepository;
		this.cupaoRepository = cupaoRepository;
		this.clienteRepository = clienteRepository;
	}
	
	
	public List<Compra> getCompras ()
	{
		List<Compra> compras = new ArrayList<> ();
		compraRepository.findAll ().forEach (compras::add);

		return compras;
	}
	
	// Regras de Negócio

	public ListaResposta addCompra (Compra compra, String cliente_id) 
	{
		ListaResposta listaResposta = new ListaResposta(); 
		
		if (compra.getValor() <= 0 )
		{
			listaResposta.addMsg( "O valor da compra tem de ser maior que zero.");
			return listaResposta;
		}
		
		Cliente cliente = clienteRepository.findById(Long.parseLong (cliente_id)).get();
		
		compra.setCliente(cliente);
		
		if (compra.getValor() >= 50 )
		{
			Cupao cupao = new Cupao ();
			cupao.setCliente(cliente);
			int desconto = (compra.getValor() < 100) ? 5:15;
			 cupao.setDesconto(desconto);
			cupaoRepository.save(cupao);
		}
		
		compraRepository.save (compra);
		listaResposta.setNewID(compra.getId());
		listaResposta.setStatusOk(true);
		return listaResposta;
	}
	
}
