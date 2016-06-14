package cdio3.server.controller;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;

import cdio3.server.DB.DAO.MySQLOperatoerDAO;
import cdio3.server.DB.DAO.MySQLProduktBatchDAO;
import cdio3.server.DB.DAO.MySQLRaavareBatchDAO;
import cdio3.server.DB.DAO.MySQLRaavareDAO;
import cdio3.server.DB.DAO.MySQLReceptDAO;
import cdio3.server.DB.DAO.MySQLTestingDAO;
import cdio3.shared.DALException;
import cdio3.shared.OperatoerDTO;
import cdio3.shared.ProduktBatchDTO;
import cdio3.shared.RaavareBatchDTO;
import cdio3.shared.RaavareDTO;
import cdio3.shared.ReceptDTO;


@SuppressWarnings("unused")
public class MainController {
	
	MySQLTestingDAO testingDAO = new MySQLTestingDAO();
	boolean testing = true;

	MySQLOperatoerDAO oprDAO = new MySQLOperatoerDAO();
	MySQLProduktBatchDAO pbDAO = new MySQLProduktBatchDAO();
//	MySQLProduktBatchKompDAO pbkDAO = new MySQLProduktBatchKompDAO();
	MySQLReceptDAO recDAO = new MySQLReceptDAO();
//	MySQLReceptKompDAO reckomDAO = new MySQLReceptKompDAO();
	MySQLRaavareBatchDAO rbDAO = new MySQLRaavareBatchDAO();
	MySQLRaavareDAO rDAO = new MySQLRaavareDAO();
	
	public MainController() {
	}
	
	public OperatoerDTO login(int id, String pass) throws DALException {
		if(testing) {
			OperatoerDTO oprDTO = new OperatoerDTO(testingDAO.getOperatoer(id));
			if(pass.equals(oprDTO.getPassword())) {
				return oprDTO;
			} else {
				return null;
			}
		} else {
			OperatoerDTO oprDTO = new OperatoerDTO(oprDAO.getOperatoer(id));
			if(pass.equals(oprDTO.getPassword())) {
				return oprDTO;
			} else {
				return null;
			}
		}
	}
	
	/* 
	*/
	private boolean validatePassword(int oprID, String pass) throws DALException {
		if(testing) {
//			OperatoerDTO oprDTO = new OperatoerDTO(/*testingDAO.getOperatoer(oprID)*/4, "Admin Jensen", "AdJe", "456789-4567", "4567Pass", 4);
//			if(oprDTO.getPassword() == pass) {
				return true;
//			} else {
//				return false;
//			}
		} else {
			OperatoerDTO oprDTO = new OperatoerDTO(oprDAO.getOperatoer(oprID));
			if(oprDTO.getPassword().equals(pass)) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public boolean changePassword(int oprID, String oldPass, String newPass) throws DALException {
		if(testing) {
			if (validatePassword(oprID, oldPass)) {	
				OperatoerDTO oprDTO = new OperatoerDTO(testingDAO.getOperatoer(oprID));
				oprDTO.setPassword(newPass);
				testingDAO.updateOperatoer(oprDTO);	
				return true;
			} else {
				return false;
			}
		} else {
			// check if the ID and password is correspondent
			if (validatePassword(oprID, oldPass)) {	
				OperatoerDTO oprDTO = new OperatoerDTO(oprDAO.getOperatoer(oprID));
				oprDTO.setPassword(newPass);
				oprDAO.updateOperatoer(oprDTO);		
				return true;
			} else {
				return false;
			}
		}
	}
	
	public ArrayList<RaavareBatchDTO> getRaavareBatchList() throws DALException {
		if(testing) {
			ArrayList<RaavareBatchDTO> rbList = new ArrayList<RaavareBatchDTO>(testingDAO.getRaavareBatchList());
			return rbList;
		} else {
			ArrayList<RaavareBatchDTO> rbList = new ArrayList<RaavareBatchDTO>(rbDAO.getRaavareBatchList());
			return rbList;
		}
	}
	
	public ArrayList<ProduktBatchDTO> getProduktBatchList() throws DALException {
		if(testing) {
			ArrayList<ProduktBatchDTO> pbList = new ArrayList<ProduktBatchDTO>(testingDAO.getProduktBatchList());
			return pbList;
		} else {
			ArrayList<ProduktBatchDTO> pbList = new ArrayList<ProduktBatchDTO>(pbDAO.getProduktBatchList());
			return pbList;
		}
	}
	
	public boolean createRaavareBatch(int rbId, int raaId, double maengde) throws DALException {
		if(testing) {
			testingDAO.createRaavareBatch(new RaavareBatchDTO(rbId, raaId, maengde));
			return true;
		} else {
			rbDAO.createRaavareBatch(new RaavareBatchDTO(rbId, raaId, maengde));
			return true;
		}
	}
	
	public boolean createProduktBatch(int pbId, int status, int receptId) throws DALException {
		if(testing) {
			testingDAO.createProduktBatch(new ProduktBatchDTO(pbId, receptId, status, getDatoInt(), 0));
			return true;
		} else {
			pbDAO.createProduktBatch(new ProduktBatchDTO(pbId, receptId, status, getDatoInt(), 0));
			return true;
		}
	}
	
	private int getDatoInt() {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		return year;
	}

	public ArrayList<RaavareDTO> getRaavareList() throws DALException {
		if(testing) {
			ArrayList<RaavareDTO> raaList = new ArrayList<RaavareDTO>(testingDAO.getRaavareList());
			return raaList;
		} else {
			ArrayList<RaavareDTO> raaList = new ArrayList<RaavareDTO>(rDAO.getRaavareList());
			return raaList;
		}
	}
	
	public boolean createRaavare(int raavareId, String raavareNavn, String leverandoer) {
		if(testing) {
			
		} else {
			
		}
//		RaavareDTO rDTO = new RaavareDTO(raavareId, raavareNavn, leverandoer);
//		rDTO.createRaavare(rDTO);
		return true;
	}
	
	public RaavareDTO getRaavare(int raavareID) throws DALException {
		if(testing) {
			RaavareDTO raaDTO = new RaavareDTO(testingDAO.getRaavare(raavareID));
			return raaDTO;
		} else {
			RaavareDTO raaDTO = new RaavareDTO(rDAO.getRaavare(raavareID));
			return raaDTO;
		}
	}
	
	public boolean updateRaavare(/*raavareDTO raavare*/) {
		if(testing) {
			
		} else {
			
		}
//		rDAO.updateRaavare(raavare);
		return true;
	}
	
	public ArrayList<ReceptDTO> getReceptList() throws DALException {
		if(testing) {
			ArrayList<ReceptDTO> recList = new ArrayList<ReceptDTO>(testingDAO.getReceptList());
			return recList;
		} else {
			ArrayList<ReceptDTO> recList = new ArrayList<ReceptDTO>(recDAO.getReceptList());
			return recList;
		}
	}
	
	public boolean createRecept(/*int receptId, String receptNavn, ArrayList<ReceptKompDTO> kompList*/) {
		if(testing) {
			
		} else {
			
		}
//		ReceptDTO recDTO = new ReceptDTO(receptId, receptNavn, kompList);
//		recDAO.createRecept(recDTO);
		return true;
	}
	
	public ArrayList<OperatoerDTO> getOperatorList() throws DALException {
		if(testing) {
			ArrayList<OperatoerDTO> oprList = new ArrayList<OperatoerDTO>(testingDAO.getOperatoerList());
			return oprList;
		} else {
			ArrayList<OperatoerDTO> oprList = new ArrayList<OperatoerDTO>(oprDAO.getOperatoerList());
			return oprList;
		}
	}
	
	/*
	 */
	public OperatoerDTO createOperator(int id, String firstName, String lastName, String cpr, int stilling) /*throws DALException*/ {
		if(testing) {
			
		} else {
			
		}
		// make oprName from the first and last name
		String oprName = firstName + " " + lastName;
		// make 4 char initials, from the first two char in first name and last name
		String ini = firstName.substring(0, 2) + lastName.substring(0, 2);
		
		String password = new LogicController().generatePassword();
		
		OperatoerDTO oprDTO = new OperatoerDTO(id, oprName, ini, cpr, password, stilling);
//		oprDAO.createOperatoer(oprDTO);
		return oprDTO;
	}
	
	public OperatoerDTO getOperator(int oprID) throws DALException {
		if(testing) {
				return testingDAO.getOperatoer(oprID);
		} else {
				return oprDAO.getOperatoer(oprID);
		}
	}
	
	public boolean updateOperator(OperatoerDTO opr) throws DALException {
		if(testing) {
			testingDAO.updateOperatoer(opr);
			return true;
		} else {
			oprDAO.updateOperatoer(opr);
			return true;
		}
	}
	
	/*
	 *  deleting an Operator containing the ID the admin provides, confirming the deletion.
	 */
	public boolean deleteOperator(/*OperatoerDTO opr*/) /*throws DALException*/ {
		if(testing) {
			
		} else {
			
		}
//		opr.setStilling(0);
//		oprDAO.updateOperator(opr);
		return true;
	}
}
