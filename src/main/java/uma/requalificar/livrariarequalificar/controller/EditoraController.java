package uma.requalificar.livrariarequalificar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import uma.requalificar.livrariarequalificar.model.Editora;
import uma.requalificar.livrariarequalificar.service.EditoraService;

@RestController
@CrossOrigin
public class EditoraController {

	private final EditoraService editoraService;
	
	@Autowired
	public EditoraController (EditoraService editoraService)
	{
		this.editoraService = editoraService;
	}
	
    @GetMapping("/getEditoras")
	@CrossOrigin
    public List<Editora> getEditoras(){
		return editoraService.getEditoras();
    }
    
}
