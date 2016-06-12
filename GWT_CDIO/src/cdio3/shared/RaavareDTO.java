package cdio3.shared;

import java.io.Serializable;

/**
 * Raavare Data Objekt
 * 
 * @author mn/sh/tb
 * @version 1.2
 */

public class RaavareDTO  implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** i omraadet 1-99999999 vaelges af brugerne */
    int raavareId;                     
    /** min. 2 max. 20 karakterer */
    String raavareNavn;                
    /** min. 2 max. 20 karakterer */
    String leverandoer;         
	
	public RaavareDTO(int raavareId, String raavareNavn, String leverandoer)
	{
		this.raavareId = raavareId;
		this.raavareNavn = raavareNavn;
		this.leverandoer = leverandoer;
	}
	
	public RaavareDTO(RaavareDTO raaDTO)
    {
		this.raavareId = raaDTO.getRaavareID();
		this.raavareNavn = raaDTO.getRaavareNavn();
		this.leverandoer = raaDTO.getLeverandoer();
    }
	
    public int getRaavareID() { return raavareId; }
    public void setRaavareID(int raavareId) { this.raavareId = raavareId; }
    public String getRaavareNavn() { return raavareNavn; }
    public void setRaavareNavn(String raavareNavn) { this.raavareNavn = raavareNavn; }
    public String getLeverandoer() { return leverandoer; }
    public void setLeverandoer(String leverandoer) { this.leverandoer = leverandoer; }
    public String toString() { 
		return raavareId + "\t" + raavareNavn +"\t" + leverandoer; 
	}
}
