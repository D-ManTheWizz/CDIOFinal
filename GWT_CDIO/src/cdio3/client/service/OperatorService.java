package cdio3.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("operatorservice")
public interface OperatorService extends RemoteService {
	String login(int id, String pass) throws IllegalArgumentException;
	String createOperator(String firstName, String lastName, String CPR);
	String changeOperator(String ID, String firstName, String lastName);
	String deleteOperator(String ID);
}
