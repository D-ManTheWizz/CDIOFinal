package cdio3.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface OperatorServiceAsync {
	void login(int id, String pass, AsyncCallback<String> callback)throws IllegalArgumentException;
	void createOperator(String firstName, String lastName, String CPR, AsyncCallback<String> callback);
	void changeOperator(String ID, String firstName, String lastName, AsyncCallback<String> callback);
	void deleteOperator(String ID, AsyncCallback<String> callback);
}
