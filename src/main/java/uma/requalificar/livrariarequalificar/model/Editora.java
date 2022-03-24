package uma.requalificar.livrariarequalificar.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "Editora")
public class Editora
{
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id", nullable = false)
	private Long id;

	private String nome;
		
	private String morada;
	
	private boolean ativo;
	
	
	@OneToMany (mappedBy = "editora")
	private List<Autor> autores;

	
	/**
	 * @return the nome
	 */
	public String getNome ()
	{
		return nome;
	}

	
	/**
	 * @param nome the nome to set
	 */
	public void setNome (String nome)
	{
		this.nome = nome;
	}

	
	/**
	 * @return the morada
	 */
	public String getMorada ()
	{
		return morada;
	}

	
	/**
	 * @param morada the morada to set
	 */
	public void setMorada (String morada)
	{
		this.morada = morada;
	}

	
	/**
	 * @return the id
	 */
	public Long getId ()
	{
		return id;
	}

	
	/**
	 * @return the autores
	 */
	public List<Autor> getAutores ()
	{
		return autores;
	}

	
	/**
	 * @param autores the autores to set
	 */
	public void setAutores (List<Autor> autores)
	{
		this.autores = autores;
	}
	
	
	/**
	 * @return the ativo
	 */
	public boolean isAtivo ()
	{
		return ativo;
	}

	
	/**
	 * @param ativo the ativo to set
	 */
	public void setAtivo (boolean ativo)
	{
		this.ativo = ativo;
	}
	
	
}
