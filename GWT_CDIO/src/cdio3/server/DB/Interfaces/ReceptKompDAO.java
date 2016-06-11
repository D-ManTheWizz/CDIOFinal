package cdio3.server.DB.Interfaces;

import java.util.List;

import cdio3.shared.DALException;
import cdio3.shared.rkDTO;

public interface ReceptKompDAO {
	rkDTO getReceptKomp(int receptId, int raavareId) throws DALException;
	List<rkDTO> getReceptKompList(int receptId) throws DALException;
	List<rkDTO> getReceptKompList() throws DALException;
		void createReceptKomp(rkDTO receptkomponent) throws DALException;
	void updateReceptKomp(rkDTO receptkomponent) throws DALException;
}
