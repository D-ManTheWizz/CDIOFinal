package cdio3.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

import cdio3.client.gui.MainView;

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
	
	@Override
	public void createOperator(String firstName, String lastName, String CPR) {
		this.service.createOperator(firstName, lastName, CPR, new DefaultCallback());
	}
	
	@Override
	public void changeOperator(String ID, String firstName, String lastName) {
		this.service.changeOperator(ID, firstName, lastName, new DefaultCallback());
	}
	
	@Override
	public void deleteOperator(String ID) {
		this.service.deleteOperator(ID, new DefaultCallback());
	}

	private class DefaultCallback implements AsyncCallback {

		@Override
		public void onFailure(Throwable caught) {
			System.out.println("Der skete en fejl...");
		}

		@Override
		public void onSuccess(Object result) {
			if(result instanceof String) {
				if(result.toString() == "logged in") {
					updateLogin();
				} else if(result.toString() == "created") {
					created();
				} else if(result.toString() == "changed") {
					changed();
				} else if(result.toString() == "deleted") {
					deleted();
				}
			} 
		}	
	}
	
	private void updateLogin() {
		this.main.updateLogin();
	}
	
	private void created() {
		this.main.created();
	}
	
	private void changed() {
		this.main.changed();
	}
	
	private void deleted() {
		this.main.deleted();
	}
}
