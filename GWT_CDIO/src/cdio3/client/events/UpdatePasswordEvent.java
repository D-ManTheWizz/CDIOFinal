package cdio3.client.events;

import cdio3.shared.OperatoerDTO;

public class UpdatePasswordEvent extends DataEvent{
	private static final long serialVersionUID = 1L;
	private OperatoerDTO oprDTO;
	
	public OperatoerDTO getOprDTO() {
		return oprDTO;
	}

	public void setOprDTO(OperatoerDTO oprDTO) {
		this.oprDTO = oprDTO;
	}
}
