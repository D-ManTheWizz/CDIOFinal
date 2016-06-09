package cdio3.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import cdio3.server.OperatoerDTO;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("operatorservice")
public interface OperatorService extends RemoteService {
	String login(int id, String pass) throws IllegalArgumentException;
	OperatoerDTO createOperator(int oprId, String firstName, String lastName, String CPR, int stilling);
	String changeOperator(String ID, String firstName, String lastName);
	String deleteOperator(String ID);
}
