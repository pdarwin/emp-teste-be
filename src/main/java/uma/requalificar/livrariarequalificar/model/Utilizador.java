package uma.requalificar.livrariarequalificar.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public abstract class Utilizador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	private String nome;
	
	private Date data_nascimento;

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the data_nascimento
	 */
	public Date getData_nascimento() {
		return data_nascimento;
	}

	/**
	 * @param data_nascimento the data_nascimento to set
	 */
	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	
	
	
}
