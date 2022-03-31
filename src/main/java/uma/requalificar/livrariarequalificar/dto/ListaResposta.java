package uma.requalificar.livrariarequalificar.dto;

import java.util.List;

public class ListaResposta extends SimpleResponse
{
	private List<?> lista;
	private long newID;
	
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


	/**
	 * @return the newID
	 */
	public long getNewID() {
		return newID;
	}


	/**
	 * @param newID the newID to set
	 */
	public void setNewID(long newID) {
		this.newID = newID;
	}
	


	
}
