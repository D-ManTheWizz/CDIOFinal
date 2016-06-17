package cdio3.server.DB.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cdio3.server.DB.DAO.MySQLProduktBatchKompDAO;
import cdio3.server.DB.Interfaces.ProduktBatchKompDAO;
import cdio3.server.DB.connector.Connector;
import cdio3.shared.DALException;
import cdio3.shared.ProduktBatchKompDTO;

public class TestProduktBatchKomponentDAO {
	ProduktBatchKompDAO pbkDAO = new MySQLProduktBatchKompDAO();

	@Before
	public void connect()
	{
		try {
			new Connector();
		} catch (Exception e) {

		}
	}

	@Test
	public void testGetProduktBachKomp() throws DALException {

		List<ProduktBatchKompDTO> pbkDTO = pbkDAO.getProduktBatchKompList();
		int validId = pbkDAO.getProduktBatchKompList().get(0).getPbId();

		pbkDAO.getProduktBatchKompList(validId);
		pbkDTO.get(0);

		boolean sameEelement = true;

		assertTrue(sameEelement);


	}


	@Test
	public void testgetProdukBatchKompListPbId() throws DALException {


		List<ProduktBatchKompDTO> list = pbkDAO.getProduktBatchKompList(1);

		assertTrue(list.size()>1);

	}


	@Test
	public void testProduktBatchKompList() throws DALException {


		List<ProduktBatchKompDTO> list = pbkDAO.getProduktBatchKompList();

		assertTrue(list.size()>1);	

	}


	@Test
	public void testUpdateProduktBatchKomp() throws DALException {

		ProduktBatchKompDTO pbkDTO = null;
		double expected = 1.8;
		try {
			pbkDTO = pbkDAO.getProduktBatchKompList().get(0);
			pbkDTO.setNetto(expected);
			pbkDAO.updateProduktBatchKomp(pbkDTO);
		} catch (DALException e) {
			e.printStackTrace();

		}
		double actual = pbkDTO.getNetto();

		assertEquals(expected, actual, 0);
	}
}	
