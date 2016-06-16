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
				oprDTO = new OperatoerDTO(666666, null, null, null, null, 666666);
				return oprDTO;
			}
		} else {
			OperatoerDTO oprDTO = new OperatoerDTO(oprDAO.getOperatoer(id));
			if(pass.equals(oprDTO.getPassword())) {
				return oprDTO;
			} else {
				oprDTO = new OperatoerDTO(666666, null, null, null, null, 666666);
				return oprDTO;
			}
		}
	}
	
	private boolean validatePassword(OperatoerDTO oprDTO) throws DALException {
		if(oprDTO.getPassword().length() >= 8) {
			return true;
		} else {
			return false;
		}	
	}
	
	public OperatoerDTO updatePassword(OperatoerDTO oprDTO) throws DALException {
		if(testing) {
			if(validatePassword(oprDTO)) {
				testingDAO.updateOperatoer(oprDTO);
				return oprDTO;
			} else {
				oprDTO.setPassword(testingDAO.getOperatoer(oprDTO.getOprId()).getPassword());
				return oprDTO;
			}
		} else {
			if (validatePassword(oprDTO)) {	
				oprDAO.updateOperatoer(oprDTO);		
				return oprDTO;
			} else {
				oprDTO.setPassword(oprDAO.getOperatoer(oprDTO.getOprId()).getPassword());
				return oprDTO;
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
	
	public boolean createOperator(OperatoerDTO newOprDTO) throws DALException {
		if(testing) {
			return true;
		} else {
			return true;
		}
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
	
	public boolean deleteOperator(/*OperatoerDTO opr*/) /*throws DALException*/ {
		if(testing) {
			
		} else {
			
		}
//		opr.setStilling(0);
//		oprDAO.updateOperator(opr);
		return true;
	}
}
