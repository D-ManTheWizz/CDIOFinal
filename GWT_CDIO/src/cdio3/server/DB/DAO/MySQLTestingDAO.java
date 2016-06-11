package cdio3.server.DB.DAO;

import cdio3.shared.OperatoerDTO;

public class MySQLTestingDAO {
	OperatoerDTO oprDTO_0;
	OperatoerDTO oprDTO_1;
	OperatoerDTO oprDTO_2;
	OperatoerDTO oprDTO_3;
	OperatoerDTO oprDTO_4;
	
	public MySQLTestingDAO() {
		setup();
	}

	private void setup() {
		this.oprDTO_0 = new OperatoerDTO(0, "Tidligere Operatoer", "TiOp", "012345-0123", "0123Pass", 0);
		this.oprDTO_1 = new OperatoerDTO(1, "Nuvaerende Operatoer", "NuOp", "123456-1234", "1234Pass", 1);
		this.oprDTO_2 = new OperatoerDTO(2, "Vaerk Foerer", "VaFo", "234567-2345", "2345Pass", 2);
		this.oprDTO_3 = new OperatoerDTO(3, "Farma Ceut", "FaCe", "345678-3456", "3456Pass", 3);
		this.oprDTO_4 = new OperatoerDTO(4, "Admin Jensen", "AdJe", "456789-4567", "4567Pass", 4);
	}

	public OperatoerDTO getOperatoer(int id) {
		
		return null;
	}

}
