package uma.requalificar.livrariarequalificar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uma.requalificar.livrariarequalificar.dto.ListaResposta;
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
 
    @PostMapping("/loginFuncionario")
	@CrossOrigin
	public ResponseEntity<ListaResposta> loginFuncionario(@RequestBody Funcionario funcionario) {
		ListaResposta listaResposta = new ListaResposta();

		if ((funcionario.getUsername() == null)) {
			listaResposta.addMsg("Username nulo.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaResposta);
		}

		if ((funcionario.getPassword() == null)) {
			listaResposta.addMsg("Password nula.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaResposta);
		}

		listaResposta = funcionarioService.loginFuncionario(funcionario);

		if (!listaResposta.isStatusOk()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaResposta);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(listaResposta);
		}
	}

	@PostMapping("/addFuncionario")
	@CrossOrigin
	public ResponseEntity<ListaResposta> addFuncionario(@RequestBody Funcionario funcionario) {
		ListaResposta listaResposta = new ListaResposta();

		if (funcionario.getId() != null) {
			listaResposta.addMsg("Ao adicionar um funcionario, o ID tem de ser nulo.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaResposta);
		}

		if ((funcionario.getNome() == null)) {
			listaResposta.addMsg("Nome nulo.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaResposta);
		}

		if ((funcionario.getPassword() == null)) {
			listaResposta.addMsg("Password nula.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaResposta);
		}

		if ((funcionario.getData_nascimento() == null)) {
			listaResposta.addMsg("Data de nascimento nula.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaResposta);
		}

		listaResposta = funcionarioService.addFuncionario(funcionario);

		if (!listaResposta.isStatusOk()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaResposta);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(listaResposta);
		}

	}
    
}
