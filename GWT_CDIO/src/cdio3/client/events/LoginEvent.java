package cdio3.client.events;

import cdio3.shared.OperatoerDTO;

public class LoginEvent extends DataEvent{
	private OperatoerDTO oprDTO;

	public OperatoerDTO getOprDTO() {
		return oprDTO;
	}

	public void setOprDTO(OperatoerDTO oprDTO) {
		this.oprDTO = oprDTO;
	}
}
