package uma.requalificar.livrariarequalificar.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import uma.requalificar.livrariarequalificar.dto.ListaResposta;
import uma.requalificar.livrariarequalificar.model.Funcionario;
import uma.requalificar.livrariarequalificar.model.Funcionario;
import uma.requalificar.livrariarequalificar.repository.FuncionarioRepository;
import uma.requalificar.livrariarequalificar.utils.Utils;

@Service
public class FuncionarioService 
{
	private final FuncionarioRepository funcionarioRepository;

	
	@Autowired
	public FuncionarioService (FuncionarioRepository funcionarioRepository)
	{
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public List<Funcionario> getFuncionarios ()
	{
		List<Funcionario> funcionarios = new ArrayList<> ();
		funcionarioRepository.findAll ().forEach (funcionarios::add);

		return funcionarios;
	}
	
	public String addFuncionario (Funcionario funcionario)
	{
		if (funcionario.getNome ().isBlank () )
			return "Nome não preenchido.";
		
		if (funcionario.getPassword ().isBlank () )
			return "Palavra-passe não preenchida.";
		
		if (!Utils.validatePassword (funcionario.getPassword () ) )
			return "Palavra-passe inválida. A palavra-passe deve ter entre 8 e 20 caracteres, e conter pelo menos uma letra minúscula, uma letra maiúscula e um dígito";
	
		
		LocalDate dataMaxima = LocalDate.now ();
		
		LocalDate dataMinima = dataMaxima.minusYears (120);
		
		if (dataMinima.compareTo (funcionario.getData_nascimento ().toLocalDate () ) > 0 || dataMaxima.compareTo (funcionario.getData_nascimento ().toLocalDate () ) <= 0 )
			return "Data de nascimento inválida.";
		
		//Encriptar password
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		funcionario.setPassword (passwordEncoder.encode(funcionario.getPassword () ) );
		
		
		funcionarioRepository.save (funcionario);
		return "";
	}
	
	public ListaResposta loginFuncionario (Funcionario funcionario)
	{
		
		ListaResposta listaResposta = new ListaResposta ();
		
		if (funcionario.getNome ().isBlank () )
		{
			listaResposta.addMsg("Nome não preenchido.");
			return listaResposta;
		}
			
		
		if (funcionario.getPassword ().isBlank () )
		{
			listaResposta.addMsg("Palavra-passe não preenchida.");
			return listaResposta;
		}
		
		for (Funcionario funcionarioAux : getFuncionarios())
		{
			if (funcionarioAux.getNome().equals(funcionario.getNome()))
			{
				//Testar password
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				if (!passwordEncoder.matches(funcionario.getPassword(), funcionarioAux.getPassword()))
				{
					listaResposta.addMsg("Palavra-passe errada.");
					return listaResposta;
				}
				else if (!funcionarioAux.isAtivo())
				{
					listaResposta.addMsg("Funcionario inativo.");
					return listaResposta;
				}
				else
				{
					listaResposta.setNewID(funcionarioAux.getId());
					listaResposta.setStatusOk(true);
					return listaResposta;
				}

			}
			
		}
	
		listaResposta.addMsg("Email incorreto ou inexistente.");
		return listaResposta;
	}
	
	
}
