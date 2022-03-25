package uma.requalificar.livrariarequalificar.dto;

import java.util.List;

public class ListaResposta extends SimpleResponse
{
	private List<?> lista;

	/**
	 * @return the pessoas
	 */
	public List<?> getLista ()
	{
		return lista;
	}

	
	/**
	 * @param pessoas the pessoas to set
	 */
	public void setLista (List<?> lista)
	{
		this.lista = lista;
	}

	
}
