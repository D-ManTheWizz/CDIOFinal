package cdio3.server.DB.DAO;

import java.util.ArrayList;

import cdio3.shared.OperatoerDTO;

public class MySQLTestingDAO {
	OperatoerDTO oprDTO_0;
	OperatoerDTO oprDTO_1;
	OperatoerDTO oprDTO_2;
	OperatoerDTO oprDTO_3;
	OperatoerDTO oprDTO_4;
	ArrayList<OperatoerDTO> oprList = new ArrayList<OperatoerDTO>();
	
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
		
	}

	public OperatoerDTO getOperatoer(int id) {return oprList.get(id);}

	public void updateOperatoer(OperatoerDTO oprDTO) {
		oprList.get(oprDTO.getOprId()).setOprNavn(oprDTO.getOprNavn());
		oprList.get(oprDTO.getOprId()).setIni(oprDTO.getIni());
		oprList.get(oprDTO.getOprId()).setCpr(oprDTO.getCpr());
		oprList.get(oprDTO.getOprId()).setPassword(oprDTO.getPassword());
		oprList.get(oprDTO.getOprId()).setStilling(oprDTO.getStilling());
		oprList.get(oprDTO.getOprId()).setOprId(oprDTO.getOprId());
	}
}
