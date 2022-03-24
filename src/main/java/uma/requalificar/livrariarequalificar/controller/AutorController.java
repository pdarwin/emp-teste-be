package uma.requalificar.livrariarequalificar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import uma.requalificar.livrariarequalificar.model.Autor;
import uma.requalificar.livrariarequalificar.service.AutorService;

@RestController
@CrossOrigin
public class AutorController {

	private final AutorService autorService;
	
	@Autowired
	public AutorController (AutorService autorService)
	{
		this.autorService = autorService;
	}
	
    @GetMapping("/getAutores")
	@CrossOrigin
    public List<Autor> getAutores(){
		return autorService.getAutores();
    }
    
}
