package uma.requalificar.livrariarequalificar.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.livrariarequalificar.model.Cliente;
import uma.requalificar.livrariarequalificar.repository.ClienteRepository;
import uma.requalificar.livrariarequalificar.utils.Utils;

@Service
public class ClienteService 
{
	private final ClienteRepository clienteRepository;
	
	
	@Autowired
	public ClienteService (ClienteRepository clienteRepository)
	{
		this.clienteRepository = clienteRepository;
	}
	
	public List<Cliente> getClientes ()
	{
		List<Cliente> clientes = new ArrayList<> ();
		clienteRepository.findAll ().forEach (clientes::add);

		return clientes;
	}
	
	
	public String addCliente (Cliente cliente)
	{
		if (cliente.getNome ().isBlank () )
			return "Nome não preenchido.";
		
		if (cliente.getEmail ().isBlank () )
			return "Email não preenchido.";
		
		if (!Utils.validateEmail (cliente.getEmail () ) )
			return "Email inválido.";
		
		if (cliente.getPassword ().isBlank () )
			return "Palavra-passe não preenchida.";
		
		if (!Utils.validatePassword (cliente.getPassword () ) )
			return "Palavra-passe inválida. A palavra-passe deve ter entre 8 e 20 caracteres, e conter pelo menos uma letra minúscula, uma letra maiúscula e um dígito";
	
		String msg = validaEmail(cliente.getEmail());
		if (!msg.isBlank())
			return msg;
		
		LocalDate dataMaxima = LocalDate.now ();
		
		LocalDate dataMinima = dataMaxima.minusYears (120);
		
		if (dataMinima.compareTo (cliente.getData_nascimento ().toLocalDate () ) > 0 || dataMaxima.compareTo (cliente.getData_nascimento ().toLocalDate () ) <= 0 )
			return "Data de nascimento inválida.";
		
		//Encriptar password
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		cliente.setPassword (passwordEncoder.encode(cliente.getPassword () ) );
		
		
		clienteRepository.save (cliente);
		return "";
	}
	
	public String validateCliente (Cliente cliente)
	{
		if (cliente.getEmail ().isBlank () )
			return "Email não preenchido.";
		
		if (cliente.getPassword ().isBlank () )
			return "Palavra-passe não preenchida.";
		
		for (Cliente clienteAux : getClientes())
		{
			if (clienteAux.getEmail().equals(cliente.getEmail()))
			{
				//Testar password
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				if (!passwordEncoder.matches(cliente.getPassword(), clienteAux.getPassword()))
				{
					return "Palavra-passe errada.";
				}
				else if (!clienteAux.isAtivo())
				{
					return "Cliente inativo.";
				}
				else return "";

			}
			
		}
	
		return "Email não encontrado";
	}

	public String validaEmail (String email)
	{
		if (email.isBlank () )
			return "Email não preenchido.";
		
		for (Cliente clienteAux : getClientes())
		{
			if (clienteAux.getEmail().equals(email))
			{
				return "Já existe um cliente registado com este email";
			}
		}
	
		return "";
	}
	
}
