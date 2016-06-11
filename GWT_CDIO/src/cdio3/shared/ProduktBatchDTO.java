package cdio3.shared;

import java.io.Serializable;

public class ProduktBatchDTO  implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	int pbId;                     // i omraadet 1-99999999
	int status;					// 0: ikke paabegyndt, 1: under produktion, 2: afsluttet
	int receptId;
	int pro_start;
	int pro_slut;
	
	public ProduktBatchDTO(int pbId, int receptId, int status, int pro_start, int pro_slut)
	{
		this.pbId = pbId;
		this.status = status;
		this.receptId = receptId;
		this.pro_start = pro_start;
		this.pro_slut = pro_slut;
	}
	
	public int getPbId() { return pbId; }
	public void setPbId(int pbId) { this.pbId = pbId; }
	public int getStatus() { return status; }
	public void setStatus(int status) { this.status = status; }
	public int getReceptId() { return receptId; }
	public void setReceptId(int receptId) { this.receptId = receptId; }
	public int getPro_start() { return pro_start; }
	public void setPro_start(int pro_start) {this.pro_start = pro_start; }
	public int getPro_slut() {return pro_slut; }
	public void setPro_slut(int pro_slut) {this.pro_slut = pro_slut; }

	public String toString() { return pbId + "\t" + status + "\t" + receptId + "\t" + pro_start + "\t" + pro_slut; }
}

