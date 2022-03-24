package uma.requalificar.livrariarequalificar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.livrariarequalificar.model.Compra;
import uma.requalificar.livrariarequalificar.repository.CompraRepository;

@Service
public class CompraService {
	
	private final CompraRepository compraRepository;

	@Autowired
	public CompraService (CompraRepository compraRepository)
	{
		this.compraRepository = compraRepository;
	}
	
	public List<Compra> getCompras()
	{
		List<Compra> compras = new ArrayList<>();
		compraRepository.findAll().forEach(compras::add);

		return compras;
	}

}
