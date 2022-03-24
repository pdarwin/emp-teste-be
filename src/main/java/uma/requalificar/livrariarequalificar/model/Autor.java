package uma.requalificar.livrariarequalificar.model;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Autor")
public class Autor
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	private String nome;

	private Date data_nascimento;
	
	private String email;
	
	private boolean ativo;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "editora_id", nullable = false)
	private Editora editora;
	
    @JsonIgnore
    @ManyToMany(mappedBy = "autores")
    private List<Livro> livros = new ArrayList<>();

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
	 * @return the id
	 */
	public Long getId()
	{
		return id;
	}

	/**
	 * @return the editora
	 */
	public Editora getEditora()
	{
		return editora;
	}

	/**
	 * @param editora the editora to set
	 */
	public void setEditora(Editora editora)
	{
		this.editora = editora;
	}

	/**
	 * @return the livros
	 */
	public List<Livro> getLivros()
	{
		return livros;
	}

	/**
	 * @param livros the livros to set
	 */
	public void setLivros(List<Livro> livros)
	{
		this.livros = livros;
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
