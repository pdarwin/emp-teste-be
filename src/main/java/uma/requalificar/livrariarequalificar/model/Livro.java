package uma.requalificar.livrariarequalificar.model;

import java.sql.Date;

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
@Table(name = "Livro")
public class Livro
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	private String titulo;
	
	private String isbn;
	
	private double preco;
	
	private int stock;
	
	private Date data_lancamento;
	
	private int num_paginas;
	
	private String sinopse;

	private String edicao;
	
	private String imagem_capa;
	
	private boolean ativo;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "autor_id", nullable = false)
	private Autor autor;

	/**
	 * @return the titulo
	 */
	public String getTitulo()
	{
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn()
	{
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}

	/**
	 * @return the preco
	 */
	public double getPreco()
	{
		return preco;
	}

	/**
	 * @param preco the preco to set
	 */
	public void setPreco(double preco)
	{
		this.preco = preco;
	}

	/**
	 * @return the stock
	 */
	public int getStock()
	{
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock)
	{
		this.stock = stock;
	}

	/**
	 * @return the data_lancamento
	 */
	public Date getData_lancamento()
	{
		return data_lancamento;
	}

	/**
	 * @param data_lancamento the data_lancamento to set
	 */
	public void setData_lancamento(Date data_lancamento)
	{
		this.data_lancamento = data_lancamento;
	}

	/**
	 * @return the num_paginas
	 */
	public int getNum_paginas()
	{
		return num_paginas;
	}

	/**
	 * @param num_paginas the num_paginas to set
	 */
	public void setNum_paginas(int num_paginas)
	{
		this.num_paginas = num_paginas;
	}

	/**
	 * @return the sinopse
	 */
	public String getSinopse()
	{
		return sinopse;
	}

	/**
	 * @param sinopse the sinopse to set
	 */
	public void setSinopse(String sinopse)
	{
		this.sinopse = sinopse;
	}

	/**
	 * @return the edicao
	 */
	public String getEdicao()
	{
		return edicao;
	}

	/**
	 * @param edicao the edicao to set
	 */
	public void setEdicao(String edicao)
	{
		this.edicao = edicao;
	}

	/**
	 * @return the imagem_capa
	 */
	public String getImagem_capa()
	{
		return imagem_capa;
	}

	/**
	 * @param imagem_capa the imagem_capa to set
	 */
	public void setImagem_capa(String imagem_capa)
	{
		this.imagem_capa = imagem_capa;
	}

	/**
	 * @return the id
	 */
	public Long getId()
	{
		return id;
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
