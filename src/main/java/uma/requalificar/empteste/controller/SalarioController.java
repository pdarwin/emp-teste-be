package uma.requalificar.empteste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uma.requalificar.empteste.dto.ListaResposta;
import uma.requalificar.empteste.model.Pessoa;
import uma.requalificar.empteste.model.Salario;
import uma.requalificar.empteste.service.SalarioService;

@RestController
@CrossOrigin
public class SalarioController {
	private final SalarioService salarioService;

	@Autowired
	public SalarioController(SalarioService salarioService) {
		this.salarioService = salarioService;
	}

	@GetMapping("/getSalarios")
	@CrossOrigin
	public List<Salario> getSalarios() {
		return salarioService.getSalarios();
	}

	@GetMapping("/getSalariosByPessoa/{pessoa_id}")
	@CrossOrigin
	public List<Salario> getSalariosByPessoa(@PathVariable String pessoa_id) {
		return salarioService.getSalariosByPessoa(pessoa_id);
	}

	@PostMapping("/addSalario/{pessoa_id}")
	@CrossOrigin
	public ResponseEntity<ListaResposta> addSalario(@RequestBody Salario salario, @PathVariable String pessoa_id) {
		ListaResposta listaResposta = new ListaResposta();

		if (salario.getId() != null) {
			listaResposta.addMsg("Ao adicionar um salario, o ID tem de ser nulo.");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaResposta);
		}

		listaResposta = salarioService.addSalario(salario, pessoa_id);

		if (!listaResposta.isStatusOk()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaResposta);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(listaResposta);
		}

	}

}
