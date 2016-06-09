package cdio3.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

import cdio3.shared.OperatoerDTO;

public interface OperatorServiceAsync {
	void login(int id, String pass, AsyncCallback<String> callback)throws IllegalArgumentException;
	void createOperator(int oprId, String firstName, String lastName, String CPR, int stilling,
			AsyncCallback<OperatoerDTO> callback);
	void changeOperator(String ID, String firstName, String lastName, AsyncCallback<String> callback);
	void deleteOperator(String ID, AsyncCallback<String> callback);
}
