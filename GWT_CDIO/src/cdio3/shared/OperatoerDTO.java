package cdio3.shared;

public class OperatoerDTO {
	private int id;
	private String oprName;
	private String ini;
	private String cpr;
	private String password;
	private int stilling;
	
	public OperatoerDTO() {
		this.id = 0;
		this.oprName = null;
		this.ini = null;
		this.cpr = null;
		this.password = null;
		this.stilling = 0;
	}

	public OperatoerDTO(int id, String oprName, String ini, String cpr, String password, int stilling) {
		this.id = id;
		this.oprName = oprName;
		this.ini = ini;
		this.cpr = cpr;
		this.password = password;
		this.stilling = stilling;
	}
	
	public OperatoerDTO(OperatoerDTO opr)
    {
    	this.id = opr.getOprId();
    	this.oprName = opr.getOprNavn();
    	this.ini = opr.getIni();
    	this.cpr = opr.getCpr();
    	this.password = opr.getPassword();
    	this.stilling = opr.getStilling();
    }
	
	public int getOprId() { return id; }
	public void setOprId(int id) { this.id = id; }
	public String getOprNavn() { return oprName; }
	public void setOprNavn(String oprName) { this.oprName = oprName; }
	public String getIni() { return ini; }
	public void setIni(String ini) { this.ini = ini; }
	public String getCpr() { return cpr; }
	public void setCpr(String cpr) { this.cpr = cpr; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	public int getStilling() { return stilling; }
	public void setStilling(int stilling) { this.stilling = stilling; }
}
