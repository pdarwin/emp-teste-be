package uma.requalificar.livrariarequalificar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import uma.requalificar.livrariarequalificar.model.Livro;
import uma.requalificar.livrariarequalificar.service.LivroService;

@RestController
@CrossOrigin
public class LivroController {

	private final LivroService livroService;
	
	@Autowired
	public LivroController (LivroService livroService)
	{
		this.livroService = livroService;
	}
	
    @GetMapping("/getLivros")
	@CrossOrigin
    public List<Livro> getLivros(){
		return livroService.getLivros();
    }
    
}
