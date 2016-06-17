package cdio3.server.DB.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cdio3.server.DB.DAO.MySQLRaavareBatchDAO;
import cdio3.server.DB.Interfaces.RaavareBatchDAO;
import cdio3.server.DB.connector.Connector;
import cdio3.shared.DALException;
import cdio3.shared.RaavareBatchDTO;

public class TestRaavareBatchDAO {

	
	private RaavareBatchDAO rbDAO = new MySQLRaavareBatchDAO();
	
	@Before
	public void connect()
	{
		try {
			new Connector();
		} catch (Exception e) {
		
		}
	}
	
	
	
	@Test
	public void testGetRaavareBatchList() throws DALException {
		
		List<RaavareBatchDTO> list = rbDAO.getRaavareBatchList();
		
		assertTrue(list.size()>1);
		
	}
	
	@Test
	public void testGetRaavareBatchListWithraavareId() throws DALException {
		
		List<RaavareBatchDTO> list1 = rbDAO.getRaavareBatchList();
		
		assertTrue(list1.size()>1);
		
	}
	
	@Test
	public void TestCreateRaavareBatch() throws DALException {
		
		List<RaavareBatchDTO> list = rbDAO.getRaavareBatchList();
		int currentList = list.get(list.size()-1).getRbId();
		
		int expected = rbDAO.getRaavareBatchList().size()+1;
		rbDAO.createRaavareBatch(new RaavareBatchDTO(currentList+1, 3, 5));
		int actual = rbDAO.getRaavareBatchList().size();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void TestUpdateRaavareBatch() {
		RaavareBatchDTO rbDTO = null;
		int expected = 12345;
		try {
			rbDTO = rbDAO.getRaavareBatchList().get(0);
			rbDTO.setRaavareId(expected);
			rbDAO.updateRaavareBatch(rbDTO);
		} catch (DALException e) {
			e.printStackTrace();
		}
		int actual = rbDTO.getRaavareId();
		assertEquals(expected, actual);
	}

}
