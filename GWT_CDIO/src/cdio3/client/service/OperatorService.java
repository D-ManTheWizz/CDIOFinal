package cdio3.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import cdio3.client.gui.LoginView;
import cdio3.shared.DALException;
import cdio3.shared.OperatoerDTO;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("operatorservice")
public interface OperatorService extends RemoteService {
	OperatoerDTO login(int id, String pass) throws IllegalArgumentException, DALException;
	OperatoerDTO createOperator(int oprId, String firstName, String lastName, String CPR, int stilling);
	String changeOperator(String ID, String firstName, String lastName);
	String deleteOperator(String ID);
	boolean changePassword(int oprID, String oldPass, String newPass) throws DALException;
}
