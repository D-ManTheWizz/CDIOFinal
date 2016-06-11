package cdio3.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

import cdio3.client.gui.MainView;
import cdio3.shared.OperatoerDTO;

public class OperatorServiceClientImpl implements OperatorServiceClientInt{
	private OperatorServiceAsync service;
	private MainView main;
	
	public OperatorServiceClientImpl(String url) {
		this.service = GWT.create(OperatorService.class);
		ServiceDefTarget endpoint = (ServiceDefTarget) this.service;
		endpoint.setServiceEntryPoint(url);
		
		this.main = new MainView(this);
	}
	
	public MainView getMainView() {
		return this.main;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void login(int id, String pass) throws IllegalArgumentException {
		this.service.login(id, pass, new DefaultCallback());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void createOperator(int oprId, String firstName, String lastName, String CPR, int stilling) {
		this.service.createOperator(oprId, firstName, lastName, CPR, stilling, new DefaultCallback());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void changeOperator(String ID, String firstName, String lastName) {
		this.service.changeOperator(ID, firstName, lastName, new DefaultCallback());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void deleteOperator(String ID) {
		this.service.deleteOperator(ID, new DefaultCallback());
	}

	@SuppressWarnings("rawtypes")
	private class DefaultCallback implements AsyncCallback {

		@Override
		public void onFailure(Throwable caught) {
			System.out.println("Der skete en fejl...");
		}

		@Override
		public void onSuccess(Object result) {
			if(result instanceof String) {
				if(result.toString() == "changed") {
					changed();
				} else if(result.toString() == "deleted") {
					deleted();
				}
			} else if (result instanceof OperatoerDTO) {
				if(((OperatoerDTO) result).getOprId()==10) {
					OperatoerDTO oprDTO = new OperatoerDTO(result);
					comfirmLogin(oprDTO);
				}
//				OperatoerDTO doneOpr = new OperatoerDTO((OperatoerDTO) result);
				OperatoerDTO doneOpr = new OperatoerDTO(((OperatoerDTO) result).getOprId(), ((OperatoerDTO) result).getOprNavn()
						, ((OperatoerDTO) result).getIni(), ((OperatoerDTO) result).getCpr(), ((OperatoerDTO) result).getPassword()
						, ((OperatoerDTO) result).getStilling());
				
				promptForPrint(doneOpr);
			}
		}	
	}
	
	private void changed() {
		this.main.changed();
	}
	
	private void deleted() {
		this.main.deleted();
	}
	private void promptForPrint(OperatoerDTO oprDTO) {
		this.main.promptForPrint(oprDTO);
	}
	private void comfirmLogin(OperatoerDTO oprDTO) {
		this.main.confirmLogin(oprDTO);
	}
}
