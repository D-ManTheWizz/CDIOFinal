package cdio3.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

import cdio3.client.events.DataEvent;
import cdio3.client.gui.LoginView;
import cdio3.shared.OperatoerDTO;

public interface OperatorServiceAsync {
	void login(int id, String pass, AsyncCallback<DataEvent> callback)throws IllegalArgumentException;
	void updatePassword(OperatoerDTO oprDTO, AsyncCallback<DataEvent> callback);
//	void createOperator(int oprId, String firstName, String lastName, String CPR, int stilling,
//			AsyncCallback<OperatoerDTO> callback);
//	void changeOperator(String ID, String firstName, String lastName, AsyncCallback<String> callback);
//	void deleteOperator(String ID, AsyncCallback<String> callback);
//	void changePassword(int oprID, String oldPass, String newPass, AsyncCallback<Boolean> callback);

	
}
