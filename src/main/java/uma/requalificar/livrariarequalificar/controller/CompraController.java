package uma.requalificar.livrariarequalificar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import uma.requalificar.livrariarequalificar.model.Compra;
import uma.requalificar.livrariarequalificar.service.CompraService;


@RestController
@CrossOrigin
public class CompraController 
{
	private final CompraService compraService;

	
	@Autowired
	public CompraController (CompraService compraService)
	{
		this.compraService = compraService;
	}

	
    @GetMapping ("/getCompras")
	@CrossOrigin
    public List<Compra> getCompras ()
    {
		return compraService.getCompras ();
    }
 
    
}

