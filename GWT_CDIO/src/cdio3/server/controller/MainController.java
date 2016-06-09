package cdio3.server.controller;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;


@SuppressWarnings("unused")
public class MainController {

//	MySQLOperatorDAO oprDAO = new MySQLOperatorDAO();
//	MySQLProduktBatchDAO pbDAO = new MySQLProduktBatchDAO();
//	MySQLProduktBatchKompDAO pbkDAO = new MySQLProduktBatchKompDAO();
//	MySQLReceptDAO recDAO = new MySQLReceptDAO();
//	MySQLReceptKompDAO reckomDAO = new MySQLReceptKompDAO();
//	MySQLRaavareBatchDAO rbDAO = new MySQLRaavareBatchDAO();
//	MySQLRaavareDAO rDAO = new MySQLRaavareDAO();
	
	public MainController() {

	}
	public int/*OperatoerDTO*/ login(int id, String pass) {
		if (validatePassword(id, pass)) {
//			OperatoerDTO oprDTO = new OperatoerDTO(oprDAO.getOperatoer(id));
			return 0/*oprDTO*/;
		} else {
			return 404;
		}
	}
	
	/* 
	*/
	private boolean validatePassword(int oprID, String pass) /*throws DALException*/ {
//		OperatoerDTO oprDTO = new OperatoerDTO(oprDAO.getOperatoer(oprID));
//		if(oprDTO.getPass == pass) {
			return true;
//		} else {
//			return false;
//		}
	}
	
	public void changePassword(int oprID, String oldPass, String newPass) /*throws DALException*/ {
		// check if the ID and password is correspondent
		if (validatePassword(oprID, oldPass)) {	
//			OperatoerDTO oprDTO = new OperatoerDTO(oprDAO.getOperatoer(oprID));
//			oprDTO.setPassword(newPass);
//			oprDAO.updateOperatoer(oprDTO);				
		} else {
//			errormsg.
		}		
	}
	
	public List getRaavareBatchList() {
//		ArrayList<RaavareBatchDTO> rbList = new ArrayList();
//		rbList = rbDAO.getRaavareBatchList();
		return null/*rbList*/;
	}
	
	public List getProduktBatchList() {
//		ArrayList<ProduktBatchDTO> pbList = new ArrayList();
//		pbList = pbDAO.getProduktBatchList();
		return null/*pbList*/;
	}
	
	public boolean createRaavareBatch(int rbId, int raavareId, double maengde) {
//		RaavareBatchDTO rbDTO = new RaavareBatchDTO(int, int, double);
//		rbDAO.createRaavareBatch(rbDTO);
		return true;
	}
	
	public boolean createProduktBatch(int pbId, int status, String receptId) {
//		ProduktBatchDTO pbDTO = new ProduktBatchDTO(int, int, String);
//		pbDAO.createProduktBatch(pbDTO);
		return true;
	}
	
	public List getRaavareList() {
//		ArrayList<raavareDTO> rList = new ArrayList();
//		rList = rDAO.getRaavareList();
		return null/*rList*/;
	}
	
	public boolean createRaavare(int raavareId, String raavareNavn, String leverandoer) {
//		RaavareDTO rDTO = new RaavareDTO(raavareId, raavareNavn, leverandoer);
//		rDTO.createRaavare(rDTO);
		return true;
	}
	
	public String/*RaavareDTO*/ getRaavare(int raavareID) {
//		RaavareDTO rDTO; // eller... = null;???
//		rDTO = rDAO.getRaavareDTO();
		return null/*rDTO*/;
	}
	
	public boolean updateRaavare(/*raavareDTO raavare*/) {
//		rDAO.updateRaavare(raavare);
		return true;
	}
	
	public List getReceptList() {
//		ArrayList<receptDTO> recList = new ArrayList();
//		recList = recDAO.getReceptList();
		return null/*recList*/;
	}
	
	public boolean createRecept(/*int receptId, String receptNavn, ArrayList<ReceptKompDTO> kompList*/) {
//		ReceptDTO recDTO = new ReceptDTO(receptId, receptNavn, kompList);
//		recDAO.createRecept(recDTO);
		return true;
	}
	
	public List getOperatorList() {
//		ArrayList<OperatoerDTO> oprList = new ArrayList();
//		oprList = oprDAO.getOperatoerList();
		return null/*oprList*/;
	}
	
	/*
	 */
	public String/*OperatoerDTO*/ createOperator(int id, String firstName, String lastName, String cpr, int stilling) /*throws DALException*/ {

		// make oprName from the first and last name
		String oprName = firstName + " " + lastName;
		// make 4 char initials, from the first two char in first name and last name
		String ini = firstName.substring(0, 2) + lastName.substring(0, 2);
		
		String password = new LogicController().generatePassword();
		
//		OperatoerDTO oprDTO = new OperatoerDTO(id, oprName, ini, cpr, password, stilling);
//		oprDAO.createOperatoer(oprDTO);
		return null/*oprDTO*/;
	}
	
	public String/*OperatorDTO*/ getOperator(int oprID) {
//		OperatorDTO oprDTO; // eller... = null;???
//		oprDTO = oprDAO.getRaavareDTO();
		return null/*oprDTO*/;
	}
	
	public boolean updateOperator(/*OperatorDTO opr*/) {
//		oprDAO.updateOperatoer(opr);
		return true;
	}
	
	/*
	 *  deleting an Operator containing the ID the admin provides, confirming the deletion.
	 */
	public void deleteOperator(/*OperatoerDTO opr*/) /*throws DALException*/ {
//		opr.setStilling(0);
//		oprDAO.updateOperator(opr);
	}
	
	/* 
	 * providing a valid oprID the operator can change his own password and will
	 * also be asked to confirm the new password, and/or returning to the mainMenu.
	 * The new password will not be checked if it "lives up to the standard".
	*/
//	private void startWeight() throws DALException {
//		
//		controllerText.setWeightAskID();
//		
//		int oprID = Integer.parseInt(UI.getInput());
//		
//		controllerText.setWeightAskPass();
//		
//		String password = UI.getInput();
//		
//		if (validatePassword(oprID, password) == true) {
//			
//			controllerText.setWeightAskTare();
//			
//			double tareWeight = Integer.parseInt(UI.getInput());
//			
//			controllerText.setWeightAskGross();
//			
//			double grossWeight = Integer.parseInt(UI.getInput());
//			double netWeight = round(grossWeight-tareWeight);
//			
//			UI.showInput("                                         ");
//			UI.showInput("************** Weight Menu **************");
//			UI.showInput("|                                       |");
//			UI.showInput("|     Your net-weight is:  " + netWeight + "        |");
//			UI.showInput("|                                       |");
//			UI.showInput("| Enter \"exit\" to exit to the mani menu |");
//			UI.showInput("|                                       |");
//			UI.showInput("*****************************************");
//			UI.showInput("                                         ");
//			
//			
//			if(UI.getInput().equals("exit")) startMenu();
//			
//			startWeight();
//			
//		} else {
	
//		}
//	}
	
	/*
	 *  round the weight to two digits
	 */
	private double round(double weight) {
		double rounded = (double) Math.round(weight * 100) / 100;
		return rounded;
	}
}
