package cdio3.server.controller;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import cdio3.server.DB.DAO.MySQLOperatoerDAO;
import cdio3.server.DB.DAO.MySQLTestingDAO;
import cdio3.shared.DALException;
import cdio3.shared.OperatoerDTO;


@SuppressWarnings("unused")
public class MainController {
	
	MySQLTestingDAO testingDAO = new MySQLTestingDAO();
	boolean testing = true;

	MySQLOperatoerDAO oprDAO = new MySQLOperatoerDAO();
//	MySQLProduktBatchDAO pbDAO = new MySQLProduktBatchDAO();
//	MySQLProduktBatchKompDAO pbkDAO = new MySQLProduktBatchKompDAO();
//	MySQLReceptDAO recDAO = new MySQLReceptDAO();
//	MySQLReceptKompDAO reckomDAO = new MySQLReceptKompDAO();
//	MySQLRaavareBatchDAO rbDAO = new MySQLRaavareBatchDAO();
//	MySQLRaavareDAO rDAO = new MySQLRaavareDAO();
	
	public MainController() {
	}
	
	public OperatoerDTO login(int id, String pass) throws DALException {
		if(testing) {
			if(validatePassword(id, pass)) {
				return testingDAO.getOperatoer(id);
			} else {
				return null;
			}
		} else {
			if(validatePassword(id, pass)) {
				return oprDAO.getOperatoer(id);
			} else {
				return null;
			}
		}
	}
	
	/* 
	*/
	private boolean validatePassword(int oprID, String pass) throws DALException {
		if(testing) {
			OperatoerDTO oprDTO = new OperatoerDTO(testingDAO.getOperatoer(oprID));
			if(oprDTO.getPassword() == pass) {
				return true;
			} else {
				return false;
			}
		} else {
			OperatoerDTO oprDTO = new OperatoerDTO(oprDAO.getOperatoer(oprID));
			if(oprDTO.getPassword() == pass) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public void changePassword(int oprID, String oldPass, String newPass) throws DALException {
		if(testing) {
			if (validatePassword(oprID, oldPass)) {	
				OperatoerDTO oprDTO = new OperatoerDTO(testingDAO.getOperatoer(oprID));
				oprDTO.setPassword(newPass);
				testingDAO.updateOperatoer(oprDTO);				
			} else {
//				return false();
			}
		}
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
	public OperatoerDTO createOperator(int id, String firstName, String lastName, String cpr, int stilling) /*throws DALException*/ {

		// make oprName from the first and last name
		String oprName = firstName + " " + lastName;
		// make 4 char initials, from the first two char in first name and last name
		String ini = firstName.substring(0, 2) + lastName.substring(0, 2);
		
		String password = new LogicController().generatePassword();
		
		OperatoerDTO oprDTO = new OperatoerDTO(id, oprName, ini, cpr, password, stilling);
//		oprDAO.createOperatoer(oprDTO);
		return oprDTO;
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
	public boolean deleteOperator(/*OperatoerDTO opr*/) /*throws DALException*/ {
//		opr.setStilling(0);
//		oprDAO.updateOperator(opr);
		return true;
	}
}
