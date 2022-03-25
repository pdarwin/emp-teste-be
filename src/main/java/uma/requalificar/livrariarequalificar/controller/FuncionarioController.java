package uma.requalificar.livrariarequalificar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import uma.requalificar.livrariarequalificar.model.Funcionario;
import uma.requalificar.livrariarequalificar.service.FuncionarioService;


@RestController
@CrossOrigin
public class FuncionarioController 
{
	private final FuncionarioService funcionarioService;
	
	
	@Autowired
	public FuncionarioController (FuncionarioService funcionarioService)
	{
		this.funcionarioService = funcionarioService;
	}
	
	
    @GetMapping ("/getFuncionarios")
	@CrossOrigin
    public List<Funcionario> getFuncionarios ()
    {
		return funcionarioService.getFuncionarios ();
    }
 
    
}
