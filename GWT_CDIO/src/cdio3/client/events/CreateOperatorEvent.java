package cdio3.client.events;

public class CreateOperatorEvent extends DataEvent {
	private static final long serialVersionUID = 1L;
	private boolean answer;
	
	public boolean getAnswer() {
		return answer;
	}
	
	public void setAnswer(boolean answer) {
		this.answer = answer;
	}
}
