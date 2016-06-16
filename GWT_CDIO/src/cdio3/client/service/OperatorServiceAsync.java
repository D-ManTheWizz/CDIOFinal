package cdio3.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

import cdio3.client.events.DataEvent;
import cdio3.shared.OperatoerDTO;

public interface OperatorServiceAsync {
	void login(int id, String pass, AsyncCallback<DataEvent> callback)throws IllegalArgumentException;
	void updatePassword(OperatoerDTO oprDTO, AsyncCallback<DataEvent> callback);
	void createOperator(OperatoerDTO newOprDTO, AsyncCallback<DataEvent> callback);	
}