 package cdio3.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import cdio3.client.service.OperatorService;
import cdio3.server.controller.MainController;

public class OperatorServiceImpl extends RemoteServiceServlet implements OperatorService {
	private static final long serialVersionUID = 1L;
	MainController main = new MainController();
	
//	@Override
//	public OperatorDTO login(int id, String pass) {
//		return main.login(id, pass);
//	}
	
//	@Override
//	public OperatorDTO createOperator(String firstName, String lastName, String cpr) {
//		return OperatorDTO;
//	}
//	
//	@Override
//	public OperatorDTO getOperator(int id) {
//		return OperatorDTO;
//	}
//	
//	@Override
//	public OperatorDTO changeOperator(int id) {
//		return new OperatorDTO;
//	}
//	
//	@Override
//	public boolean deleteOperator(int id) {
//		return true;
//	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public String createOperator(String firstName, String lastName, String CPR) {
		return "created";
	}

	@Override
	public String changeOperator(String ID, String firstName, String lastName) {
		return "changed";
	}

	@Override
	public String deleteOperator(String ID) {
		return "deleted";
	}

	@Override
	public String login(int id, String pass) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}
}
