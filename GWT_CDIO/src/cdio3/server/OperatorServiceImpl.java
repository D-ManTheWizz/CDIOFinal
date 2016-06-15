 package cdio3.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import cdio3.client.events.DataEvent;
import cdio3.client.events.LoginEvent;
import cdio3.client.events.UpdatePasswordEvent;
import cdio3.client.gui.LoginView;
import cdio3.client.service.OperatorService;
import cdio3.server.controller.MainController;
import cdio3.shared.DALException;
import cdio3.shared.OperatoerDTO;

public class OperatorServiceImpl extends RemoteServiceServlet implements OperatorService {
	private static final long serialVersionUID = 1L;
	MainController main = new MainController();
	
//	@Override
//	public OperatorDTO login(int id, String pass) {
//		return main.login(id, pass);
//	}
	
//	@Override
//	public boolean changePassword(int oprID, String oldPass, String newPass) throws DALException {
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
//	public List getRaavareList() {
//		return main.getRaavareList();
//	}
	
//	@Override
//	public boolean createRaavare(int raavareId, String raavareNavn, String leverandoer) {
//		return main.createRaavare(raavareId, raavareNavn, leverandoer);
//	}
	
//	@Override
//	public RaavareDTO getRaavare(int raavareID) {
//		return main.getRaavare(raavareId);
//	}
	
//	@Override
//	public boolean updateRaavare(RaavareDTO raavare) {
//		return main.updateRaavare(raavare);
//	}
	
//	@Override
//	public List getReceptList() {
//		return main.getReceptList();
//	}
	
//	@Override
//	public List getOperatorList() {
//		return main.getOperatorList();
//	}
	
//	@Override
//	public boolean createRecept(int receptId, String receptNavn, List kompList) {
//		return main.createRecept(receptId, receptNavn, kompList);
//	}
	
//	@Override
//	public OperatoerDTO createOperator(int id, String firstName, String lastName, String cpr, int stilling) {
//		return main.createOperator(id, firstName, lastName, cpr, stilling);
//	}
	
//	@Override
//	public OperatoerDTO getOperator(int oprID) {
//		return main.getOperator(oprID);
//	}
	
//	@Override
//	public boolean updateOperator(OperatorDTO opr) {
//		return main.updateOperator(opr);
//	}
	
//	@Override
//	public boolean deleteOperator(OperatoerDTO opr) {
//		return main.deleteOperator(opr);
//	}
	
//	@Override
//	public String changeOperator(String ID, String firstName, String lastName) {
//		return "changed";
//	}

//	@Override
//	public String deleteOperator(String ID) {
//		return "deleted";
//	}
	
	@Override
	public DataEvent updatePassword(OperatoerDTO oprDTO) throws DALException {
		OperatoerDTO oprDTO_Back = new OperatoerDTO(main.updatePassword(oprDTO));
		UpdatePasswordEvent updatePasswordEvent = new UpdatePasswordEvent();
		updatePasswordEvent.setOprDTO(oprDTO_Back);
		return updatePasswordEvent;
	}

	@Override
	public DataEvent login(int id, String pass) throws IllegalArgumentException, DALException{
		OperatoerDTO oprDTO = new OperatoerDTO(main.login(id, pass)/*4, "Hans Jensen", "HaJe", "lkjbkbj", "4567Pass", 4*/);
		LoginEvent loginEvent = new LoginEvent();
		loginEvent.setOprDTO(oprDTO);
		
		return loginEvent;
	}
}