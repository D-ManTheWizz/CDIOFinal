package cdio3.server.controller;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
	
	private ArrayList<String> password = new ArrayList<String>();
	
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
		if (validatePassword(oprID, oldPass)) {		
//			this.oprDTO.setPassword(newPass);
//			oprDAO.updateOperatoer(this.oprDTO);				
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
	
	public void createRaavareBatch(int rbId, int raavareId, double maengde) {
//		RaavareBatchDTO rbDTO = new RaavareBatchDTO(int, int, double);
//		rbDAO.createRaavareBatch(rbDTO);
	}
	
	public void createProduktBatch(int pbId, int status, String receptId) {
//		ProduktBatchDTO pbDTO = new ProduktBatchDTO(int, int, String);
//		pbDAO.createProduktBatch(pbDTO);
	}
	
	public List getRaavareList() {
//		ArrayList<raavareDTO> rList = new ArrayList();
//		rList = rDAO.getRaavareList();
		return null/*rList*/;
	}
	
	public void createRaavare(int raavareId, String raavareNavn, String leverandoer) {
//		RaavareDTO rDTO = new RaavareDTO(raavareId, raavareNavn, leverandoer);
//		rDTO.createRaavare(rDTO);
	}
	
	public String/*RaavareDTO*/ getRaavare(int raavareID) {
//		RaavareDTO rDTO; // eller... = null;???
//		rDTO = rDAO.getRaavareDTO();
		return null/*rDTO*/;
	}
	
	public void updateRaavare(/*raavareDTO raavare*/) {
//		rDAO.updateRaavare(raavare);
	}
	
	public List getReceptList() {
//		ArrayList<receptDTO> recList = new ArrayList();
//		recList = recDAO.getReceptList();
		return null/*recList*/;
	}
	
	public void createRecept(/*int receptId, String receptNavn, ArrayList<ReceptKompDTO> kompList*/) {
//		ReceptDTO recDTO = new ReceptDTO(receptId, receptNavn, kompList);
//		recDAO.createRecept(recDTO);
	}
	
	public List getOperatorList() {
//		ArrayList<OperatoerDTO> oprList = new ArrayList();
//		oprList = oprDAO.getOperatoerList();
		return null/*oprList*/;
	}
	
	/*
	 */
	public void createOperator(int id, String firstName, String lastName, String cpr, int stilling) /*throws DALException*/ {

		// make oprName from the first and last name
		String oprName = firstName + " " + lastName;
		// make 4 char initials, from the first two char in first name and last name
		String ini = firstName.substring(0, 2) + lastName.substring(0, 2);
		
		generatePassword();
		
//		OperatoerDTO oprDTO = new OperatoerDTO(id, oprName, ini, cpr, this.password, stilling);
//		oprDAO.createOperatoer(oprDTO);
	}
	
	private String generatePassword() {
		
		// create a list of numbers 1-8       
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		a.add(6);
		a.add(7);
		a.add(8);
		
		
		// shuffle the list
		Collections.shuffle(a); 
		
		for(int i=0; i<=7; i++) {
			
			// iterate through the shuffled list
			int choice = a.get(i); 
			
			// run all 8 cases in random order
			switch(choice) {
			
				// get a random UpperCase letter and add to the StringArray: password
				case 1: getUppercase();
						break;
						
				// get a random	LowerCase letter and add to the StringArray: password
				case 2: getLowercase();
						break;
				
				// get a random integer and add to the StringArray: password
				case 3: getInt();
						break;
						
				// get a random special-sign and add to the StringArray: password
				case 4: getSpecial();
						break;
						
				// get a random letter/int/sign and add to the StringArray: password
				case 5: getRandom();
						break;
						
				// get a random letter/int/sign and add to the StringArray: password
				case 6: getRandom();
						break;
				
				// get a random letter/int/sign and add to the StringArray: password
				case 7: getRandom();
						break;
				
				// get a random letter/int/sign and add to the StringArray: password
				case 8: getRandom();
						break;
									
			}
			
		}
		
		// generate the password from the StringArray: password
		String generatedPassword = 	password.get(0) + password.get(1) + 
									password.get(2) + password.get(3) + 
									password.get(4) + password.get(5) + 
									password.get(6) + password.get(7);

		return generatedPassword;
				      
	}
	
	private void getUppercase() {
		
		String[] upper = {"A","B","C","D","E","F","G","H","I","J","K","L",
				"M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		Collections.shuffle(Arrays.asList(upper));
		
		password.add(upper[0]);
		
	}
	
	private void getLowercase() {
		
		String[] lower = {"a","b","c","d","e","f","g","h","i","j","k","l",
				"m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		Collections.shuffle(Arrays.asList(lower));
		
		password.add(lower[0]);
		
	}
	
	private void getInt() {
		
		String[] number = {"0","1","2","3","4","5","6","7","8","9"};
		Collections.shuffle(Arrays.asList(number));
		
		password.add(number[0]);
		
	}
	
	private void getSpecial() {
		
		String[] special = {".", ",", "-", "_", "+", "!", "?", "="};
		Collections.shuffle(Arrays.asList(special));
		
		password.add(special[0]);
		
	}
	
	private void getRandom() {
		
		String[] random = {".", ",", "-", "_", "+", "!", "?", "=","0","1",
				"2","3","4","5","6","7","8","9","a","b","c","d","e","f","g",
				"h","i","j","k","l","m","n","o","p","q","r","s","t","u","v",
				"w","x","y","z","A","B","C","D","E","F","G","H","I","J","K",
				"L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		Collections.shuffle(Arrays.asList(random));
		
		password.add(random[0]);
		
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
