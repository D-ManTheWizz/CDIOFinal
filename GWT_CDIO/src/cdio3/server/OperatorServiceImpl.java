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
//	public boolean changePassword(int oprID, String oldPass, String newPass) {
//		return main.changePassword(oprID, oldPass, newPass);
//	}
	
//	@Override
//	public List getRaavareBatchList() {
//		return main.getRaavareBatchList();
//	}
	
//	@Override
//	public List getProduktBatchList() {
//		return main.getProduktBatchList();
//	}
	
//	@Override
//	public boolean createRaavareBatch(int rbId, int raavareId, double maengde) {
//		return main.createRaavareBatch(rbId, raavareId, maengde);
//	}
	
//	@Override
//	public boolean createProduktBatch(int pbId, int status, String receptId) {
//		return main.createProduktBatch(pbId, status, receptId);
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
