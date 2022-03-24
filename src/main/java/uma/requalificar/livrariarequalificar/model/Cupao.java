package uma.requalificar.livrariarequalificar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Cupao")
public class Cupao
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	private int desconto; // em percentagem, sobre o preço do livro
	
	private boolean ativo;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;

	/**
	 * @return the desconto
	 */
	public int getDesconto()
	{
		return desconto;
	}

	/**
	 * @param desconto the desconto to set
	 */
	public void setDesconto(int desconto)
	{
		this.desconto = desconto;
	}

	/**
	 * @return the id
	 */
	public Long getId()
	{
		return id;
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente()
	{
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente)
	{
		this.cliente = cliente;
	}
	
	/**
	 * @return the ativo
	 */
	public boolean isAtivo()
	{
		return ativo;
	}

	/**
	 * @param ativo the ativo to set
	 */
	public void setAtivo(boolean ativo)
	{
		this.ativo = ativo;
	}
	
}
