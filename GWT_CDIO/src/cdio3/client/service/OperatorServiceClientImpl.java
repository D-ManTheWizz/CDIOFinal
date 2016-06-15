package cdio3.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

import cdio3.client.events.DataEvent;
import cdio3.client.gui.LoginView;
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
	
	@Override
	public void login(int id, String pass) throws IllegalArgumentException {
		this.service.login(id, pass, new DefaultCallback());
	}
	
//	@Override
//	public void createOperator(int oprId, String firstName, String lastName, String CPR, int stilling) {
//		this.service.createOperator(oprId, firstName, lastName, CPR, stilling, new DefaultCallback());
//	}
	
//	@Override
//	public void changeOperator(String ID, String firstName, String lastName) {
//		this.service.changeOperator(ID, firstName, lastName, new DefaultCallback());
//	}
	
//	@Override
//	public void deleteOperator(String ID) {
//		this.service.deleteOperator(ID, new DefaultCallback());
//	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void updatePassword(OperatoerDTO oprDTO) {
		this.service.updatePassword(oprDTO, new DefaultCallback());
	}

	@SuppressWarnings("rawtypes")
	private class DefaultCallback implements AsyncCallback<DataEvent> {

		@Override
		public void onFailure(Throwable caught) {
			System.out.println("Der skete en fejl...");
		}

		@Override
		public void onSuccess(DataEvent result) {
			main.handleEvent(result);
//			if(result instanceof DataEvent) {
//				
//			} else if(result instanceof String) {
//				if(result.toString() == "changed") {
//					changed();
//				} else if(result.toString() == "deleted") {
//					deleted();
//				}
//			} else if (result instanceof OperatoerDTO) {
//				comfirmLogin((OperatoerDTO) result);			
//			} else if (result instanceof boolean[]) {
//				boolean res = (boolean) result;
//				
//				if(res==true) {
//					//METODE DER SENDER TRUE TIL CHANGE PASSWORD//
//				}
//			}
		}	
	}
	
	private void changed() {
		this.main.changed();
	}
	
	private void deleted() {
		this.main.deleted();
	}

	private void comfirmLogin(OperatoerDTO oprDTO) {
		this.main.confirmLogin(oprDTO);
	}
}
