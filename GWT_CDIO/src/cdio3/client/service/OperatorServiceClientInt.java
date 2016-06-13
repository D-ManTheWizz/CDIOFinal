package cdio3.client.service;

import cdio3.client.gui.LoginView;

public interface OperatorServiceClientInt {
	void login(int id, String pass) throws IllegalArgumentException;
	void changeOperator(String ID, String firstName, String lastName);
	void deleteOperator(String ID);
	void createOperator(int oprId, String firstName, String lastName, String CPR, int stilling);
	void changePassword(int oprID, String oldPass, String newPass);
}
