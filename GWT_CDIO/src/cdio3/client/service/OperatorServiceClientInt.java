package cdio3.client.service;

public interface OperatorServiceClientInt {
	void login(int id, String pass) throws IllegalArgumentException;
	void createOperator(String firstName, String lastName, String CPR);
	void changeOperator(String ID, String firstName, String lastName);
	void deleteOperator(String ID);
}
