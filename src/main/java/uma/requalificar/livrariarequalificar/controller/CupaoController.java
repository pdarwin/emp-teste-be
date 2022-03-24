package uma.requalificar.livrariarequalificar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import uma.requalificar.livrariarequalificar.model.Cupao;
import uma.requalificar.livrariarequalificar.service.CupaoService;

@RestController
@CrossOrigin
public class CupaoController {

	private final CupaoService cupaoService;
	
	@Autowired
	public CupaoController (CupaoService cupaoService)
	{
		this.cupaoService = cupaoService;
	}
	
    @GetMapping("/getCupoes")
	@CrossOrigin
    public List<Cupao> getCupoes(){
		return cupaoService.getCupoes();
    }
    
}
