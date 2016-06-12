package cdio3.server.DB.test;

import cdio3.server.DB.DAO.MySQLOperatoerDAO;
import cdio3.server.DB.DAO.MySQLProduktBatchDAO;
import cdio3.shared.DALException;
import cdio3.shared.OperatoerDTO;

public class Main {
	public static void main(String[] args) {
		
		MySQLProduktBatchDAO pb = new MySQLProduktBatchDAO();
		try { System.out.println(pb.getProduktBatch(1).getPro_start()); }
		catch (DALException e) { System.out.println(e.getMessage()); }
		
		
		MySQLOperatoerDAO opr = new MySQLOperatoerDAO();
		try { System.out.println(opr.getOperatoerList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("Operatoer nummer 3:");
		try { System.out.println(opr.getOperatoer(3)); }
		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("Delete Operatoer nummer 4.");
		try { opr.deleteOperatoer(4); System.out.println("Operatoer nummer 4 slettet."); }
		catch (DALException e) { System.out.println(e.getMessage()); }	
		
		System.out.println("Indsaettelse af ny operatoer med opr_id =  4");
		OperatoerDTO oprDTO = new OperatoerDTO(4,"Don Juan","DJ","000000-0000","iloveyou", 1);
		try { opr.createOperatoer(oprDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }	


		System.out.println("Operatoer nummer 4:");
		try { System.out.println(opr.getOperatoer(4)); }
		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("Opdatering af initialer for operatoer nummer 4");
		oprDTO.setIni("DoJu");
		try { opr.updateOperatoer(oprDTO); }
		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("Operatoer nummer 4:");
		try { System.out.println(opr.getOperatoer(4)); }
		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("Alle operatoerer:");
		try { System.out.println(opr.getOperatoerList()); }
		catch (DALException e) { System.out.println(e.getMessage()); }

		System.out.println("Operatoer nummer 5:");
		try { System.out.println(opr.getOperatoer(5)); }
		catch (DALException e) { System.out.println(e.getMessage()); }		

	}
}
