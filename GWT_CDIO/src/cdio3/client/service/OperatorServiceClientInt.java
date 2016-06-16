package cdio3.client.service;

import cdio3.shared.OperatoerDTO;

public interface OperatorServiceClientInt {
	void login(int id, String pass) throws IllegalArgumentException;
	void updatePassword(OperatoerDTO oprDTO);
	void createOperator(OperatoerDTO newOprDTO);
}