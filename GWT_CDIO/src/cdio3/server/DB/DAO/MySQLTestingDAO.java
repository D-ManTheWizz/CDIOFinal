package cdio3.server.DB.DAO;

import java.util.ArrayList;
import java.util.Collection;

import cdio3.shared.OperatoerDTO;
import cdio3.shared.ProduktBatchDTO;
import cdio3.shared.RaavareBatchDTO;

public class MySQLTestingDAO {
	OperatoerDTO oprDTO_0;
	OperatoerDTO oprDTO_1;
	OperatoerDTO oprDTO_2;
	OperatoerDTO oprDTO_3;
	OperatoerDTO oprDTO_4;
	ArrayList<OperatoerDTO> oprList = new ArrayList<OperatoerDTO>();
	
	RaavareBatchDTO rbDTO_0;
	RaavareBatchDTO rbDTO_1;
	RaavareBatchDTO rbDTO_2;
	RaavareBatchDTO rbDTO_3;
	RaavareBatchDTO rbDTO_4;
	ArrayList<RaavareBatchDTO> raaBatchList = new ArrayList<RaavareBatchDTO>();
	
	ProduktBatchDTO pbDTO_0;
	ProduktBatchDTO pbDTO_1;
	ProduktBatchDTO pbDTO_2;
	ProduktBatchDTO pbDTO_3;
	ProduktBatchDTO pbDTO_4;
	ArrayList<ProduktBatchDTO> prodBatchList = new ArrayList<ProduktBatchDTO>();
	
	public MySQLTestingDAO() {
		setup();
	}

	private void setup() {
		// A List of 5 Operators, named after position in the company and clearance lvl.
		this.oprList.add(this.oprDTO_0 = new OperatoerDTO(0, "Tidligere Operatoer", "TiOp", "012345-0123", "0123Pass", 0));
		this.oprList.add(this.oprDTO_1 = new OperatoerDTO(1, "Nuvaerende Operatoer", "NuOp", "123456-1234", "1234Pass", 1));
		this.oprList.add(this.oprDTO_2 = new OperatoerDTO(2, "Vaerk Foerer", "VaFo", "234567-2345", "2345Pass", 2));
		this.oprList.add(this.oprDTO_3 = new OperatoerDTO(3, "Farma Ceut", "FaCe", "345678-3456", "3456Pass", 3));
		this.oprList.add(this.oprDTO_4 = new OperatoerDTO(4, "Admin Jensen", "AdJe", "456789-4567", "4567Pass", 4));
		
		// A List of 5 RaavareBatches, named after IDnumber.
		this.raaBatchList.add(this.rbDTO_0 = new RaavareBatchDTO(0, 0, 0.00));
		this.raaBatchList.add(this.rbDTO_1 = new RaavareBatchDTO(1, 1, 1.11));
		this.raaBatchList.add(this.rbDTO_2 = new RaavareBatchDTO(2, 2, 2.22));
		this.raaBatchList.add(this.rbDTO_3 = new RaavareBatchDTO(3, 3, 3.33));
		this.raaBatchList.add(this.rbDTO_4 = new RaavareBatchDTO(4, 4, 4.44));
		
		// A List of 5 ProduktBatches, named after ID.
		this.prodBatchList.add(this.pbDTO_0 = new ProduktBatchDTO(0, 0, 0, 0, 0));
		this.prodBatchList.add(this.pbDTO_1 = new ProduktBatchDTO(1, 1, 0, 1, 1));
		this.prodBatchList.add(this.pbDTO_2 = new ProduktBatchDTO(2, 2, 0, 2, 2));
		this.prodBatchList.add(this.pbDTO_3 = new ProduktBatchDTO(3, 3, 0, 3, 3));
		this.prodBatchList.add(this.pbDTO_4 = new ProduktBatchDTO(4, 4, 0, 4, 4));
	}

	public OperatoerDTO getOperatoer(int id) {return oprList.get(id);}
	public ArrayList<RaavareBatchDTO> getRaavareBatchList() {return raaBatchList;}
	public ArrayList<ProduktBatchDTO> getProduktBatchList() {return prodBatchList;}

	public void updateOperatoer(OperatoerDTO oprDTO) {
		oprList.get(oprDTO.getOprId()).setOprNavn(oprDTO.getOprNavn());
		oprList.get(oprDTO.getOprId()).setIni(oprDTO.getIni());
		oprList.get(oprDTO.getOprId()).setCpr(oprDTO.getCpr());
		oprList.get(oprDTO.getOprId()).setPassword(oprDTO.getPassword());
		oprList.get(oprDTO.getOprId()).setStilling(oprDTO.getStilling());
		oprList.get(oprDTO.getOprId()).setOprId(oprDTO.getOprId());
	}
}
