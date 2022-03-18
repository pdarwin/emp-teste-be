package uma.requalificar.livrariarequalificar.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	private String nome;

	private Date data_nascimento;
	
	private String email;
	
	private String password;
	
	private String morada;
	
	@OneToMany(mappedBy = "cliente")
	private List<Cupao> cupoes;
	
	@OneToMany(mappedBy = "cliente")
	private List<Compra> compras;

	/**
	 * @return the nome
	 */
	public String getNome()
	{
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome)
	{
		this.nome = nome;
	}

	/**
	 * @return the data_nascimento
	 */
	public Date getData_nascimento()
	{
		return data_nascimento;
	}

	/**
	 * @param data_nascimento the data_nascimento to set
	 */
	public void setData_nascimento(Date data_nascimento)
	{
		this.data_nascimento = data_nascimento;
	}

	/**
	 * @return the id
	 */
	public Long getId()
	{
		return id;
	}

	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * @return the morada
	 */
	public String getMorada()
	{
		return morada;
	}

	/**
	 * @param morada the morada to set
	 */
	public void setMorada(String morada)
	{
		this.morada = morada;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * @return the cupoes
	 */
	public List<Cupao> getCupoes()
	{
		return cupoes;
	}

	/**
	 * @param cupoes the cupoes to set
	 */
	public void setCupoes(List<Cupao> cupoes)
	{
		this.cupoes = cupoes;
	}
	
	

}
