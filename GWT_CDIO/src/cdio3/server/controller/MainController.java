package cdio3.server.controller;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;


public class MainController {

//	MySQLOperatorDAO oprDAO = new MySQLOperatorDAO();
//	MySQLProduktBatchDAO pbDAO = new MySQLProduktBatchDAO();
//	MySQLProduktBatchKompDAO pbkDAO = new MySQLProduktBatchKompDAO();
//	MySQLReceptDAO recDAO = new MySQLReceptDAO();
//	MySQLReceptKompDAO reckomDAO = new MySQLReceptKompDAO();
//	MySQLRaavareBatchDAO rbDAO = new MySQLRaavareBatchDAO();
//	MySQLRaavareDAO rDAO = new MySQLRaavareDAO();
	
//	OperatoerDTO oprDTO;
//	ArrayList<RaavareBatchDTO> rbList;
	
	public MainController() {

	}
	
	/* 
	*/
	public boolean validatePassword(int oprID, String password) /*throws DALException*/ {
//		this.oprDTO = new OperatoerDTO(oprDAO.getOperatoer(oprID));
//		if(oprDTO.getPass == password) {
			return true;
//		} else {
//			return false;
//		}
	}
	
	public void changePassword(int oprID, String oldPass, String newPass) /*throws DALException*/ {
		// check if the ID and password is correspondent
		if (validatePassword(oprID, oldPass) == true) {		
//			oprDTO.setPassword(newPass);
//			oprDAO.updateOperatoer(oprDTO);				
		} else {
//			errormsg.
		}		
	}
	
	public List getRaavareBatchList() {
//		rbList = rbDAO.getRaavareBatchList();
		return null/*rbList*/;
	}
	
	public List getProduktBatchList() {
//		List</*produktBatchDTO*/> pbListDTO = new ArrayList( .getProduktBatchList());
		return null/*pbListDTO*/;
	}
	
	public void createRaavareBatch(/*int, int, double*/) {
//		RaavareBatchDTO rbDTO = new RaavareBatchDTO(int, int, double);
//		.setRaavareBatch(rbDTO);
	}
	
	public void createProduktBatch(/*int, int, String*/) {
//		ProduktBatchDTO pbDTO = new ProduktBatchDTO(int, int, String);
//		.setProduktBatch(pbDTO);
	}
	
	public List getRaavareList() {
//		List</*raavareDTO*/> rListDTO = new ArrayList( .getRaavareList());
		return null/*rListDTO*/;
	}
	
	public void createRaavare(/*int, String, String*/) {
//		RaavareDTO rDTO = new RaavareDTO(int, String, String);
//		.setRaavare(rDTO);
	}
	
	public String/*raavareDTO*/ getRaavare(int raavareID) {
//		RaavareDTO rDTO = new RaavareDTO( .getRaavareDTO());
		return null/*rDTO*/;
	}
	
	public void updateRaavare(/*raavareDTO raavare*/) {
//		.updateRaavare(raavare);
	}
	
	public List getReceptList() {
//		List</*receptDTO*/> recListDTO = new ArrayList( .getReceptList());
		return null/*recListDTO*/;
	}
	
	public void createRecept(/*int, String, String[]*/) {
//		ReceptDTO recDTO = new ReceptDTO(int, String, String[]);
//		.setRecept(recDTO);
	}
	
	public List getOperatorList() {
//		List</*operatorDTO*/> oprListDTO = new ArrayList( .getOperatorList());
		return null/*oprListDTO*/;
	}
	
	/*
	 */
	public void createOperator() /*throws DALException*/ {

		String oprFirstName = null;
		String oprLastName = null;		
		String oprCpr = null;
		
		// make oprName from the first and last name
		String oprName = oprFirstName + " " + oprLastName;
		// make 4 char initials, from the first two char in first name and last name
		String ini = oprFirstName.substring(0, 2) + oprLastName.substring(0, 2);
		
//		// iterating through the list of Operators to check if an Operator with this cpr already exist.
//		for (Iterator<OperatorDTO> oprIter = oDAO.getOperatorList().listIterator(); oprIter.hasNext(); ) {
//		    OperatorDTO operator = oprIter.next();
				    
//		    if (operator.getCpr().contains(oprCpr)) {
//				UI.getInput();
//				adminMenu();	        
//		    } 
//		}	
//		oDAO.createOperator(oprName, ini, oprCpr);    	
//		/*
//		 * iterating through the list of Operators, finding the newly created operator, using the cpr. to
//		 * get the password and ID for displaying, and asking the admin to confirm.
//		 * (we can't use getOperator(opID); as the ID is autogenerated in OperatorDAO, so we iterate).
//		 */
//    	for (Iterator<OperatorDTO> oprIterForPassAndID = oDAO.getOperatorList().listIterator(); oprIterForPassAndID.hasNext(); ) {
//		    OperatorDTO operatorPassID = oprIterForPassAndID.next();		    
//		    if (operatorPassID.getCpr() == oprCpr) {		    		    
//    	}		    	
	}
	
	/*
	 *  if the admin choose to change some oprInfo, he will be asked what info to change
	 */
	public void changeOprInfo() /*throws DALException*/ {
		String choiceString = null;
		
//		if(choiceString.equals("1") || choiceString.equals("2") || choiceString.equals("3")) {
//
//			int choice = Integer.parseInt(choiceString);
//			
//			switch (choice) {
//			
//				case 1: 	changeOprName(); // prompt for valid ID
//				
//				case 2:		changeOprCpr(); // prompt for valid ID
//				
//				case 3:		adminMenu();
//			
//			}
//			
//		} else {
//			
//			UI.getInput();
//			changeOprInfo();
//			
//		}
	}
	
	/*
	 *  deleting an Operator containing the ID the admin provides, confirming the deletion.
	 */
	public void deleteOprInfo() /*throws DALException*/ {
		
//		oDTO = oDAO.getOperator(Integer.parseInt(UI.getInput()));
//		if(oDTO == null) {	

//			UI.getInput();
//			adminMenu();			
//		}
		
//		// showing the Operator to be deleted
//		// deleting the operator IF, and only if, the admin confirm
//		if (UI.getInput().contains("yes")) {	
//			oDAO.deleteOperator((OperatorDTO) oDTO); 			
//		} else {	
//			adminMenu();		
//		}
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
