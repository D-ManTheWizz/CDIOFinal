package cdio3.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import cdio3.client.events.DataEvent;
import cdio3.shared.DALException;
import cdio3.shared.OperatoerDTO;

@RemoteServiceRelativePath("operatorservice")
public interface OperatorService extends RemoteService {
	DataEvent login(int id, String pass) throws DALException;
	DataEvent updatePassword(OperatoerDTO oprDTO) throws DALException;
	DataEvent createOperator(OperatoerDTO newOprDTO) throws DALException;
}