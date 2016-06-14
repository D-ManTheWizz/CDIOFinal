package cdio3.ASE.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import cdio3.ASE.interfaces.IWeightController;

public class WeightController implements IWeightController{

	private String ip;
	private int port;
	private Socket socket;
	private BufferedReader inputStream;
	private DataOutputStream outputStream;

	
	public WeightController(String ip, int port){
		this.ip = ip;
		this.port = port;
	}
	
	public void connectToWeight() {
		
		try {
			socket = new Socket(ip, port);

			inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			outputStream = new DataOutputStream(socket.getOutputStream());
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	public String writeToSocket(String output) {

		try {
			outputStream.writeBytes(output +"\r\n");
			outputStream.flush();
			return inputStream.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}

	public String readSocket() {
		String input = "";
		
		try {
			input = inputStream.readLine();
		} catch (IOException e) {
			System.out.println("READ FAILED");
			e.printStackTrace();
		}
		return input;
	}

	public int askForUserID(String output) {

		writeToSocket("RM20 8 " +output);
		String input = readSocket();
		System.out.println(input);
		int intInput = Integer.parseInt(input.substring(7, input.length()-5));
		
		return intInput;
	}

	public void sendMessage(String output) {
		writeToSocket("D " + output + "\r\n");
	}

	public int askForPBID(String output) {
		
		writeToSocket("RM20 8 " + output);
		String input = readSocket();
		int intInput = Integer.parseInt(input.substring(7, input.length()-5));
		
		return intInput;
	}

	public String checkIfEmpty(String output) {
		
		writeToSocket("RM20 8 " +output);
		String input = readSocket();
		input= input.substring(7,input.length()-5);
		if(input.equals("OK")){
			return input;
		}
		else{
			checkIfEmpty(output);
		}
		return input;
	}

	
	public String askUserToTaraWeight(String output) {
		
		writeToSocket("RM20 8 " +output);
		String input = readSocket();
		input= input.substring(7,input.length()-5);
		if(input.equals("OK")){
			return input;
		}
		else{
			askUserToTaraWeight(output);
		}
		return input;
	}

	
	public int getRBID(String output) {
		
		writeToSocket("RM20 8 " +output);
		String input = readSocket();
		int intInput = -1;
		input= input.substring(7,input.length()-5);
		intInput = Integer.parseInt(input.substring(7,input.length()-5));
		return intInput;
	}

	
	public String completeWeighing(String output) {
		writeToSocket("RM20 8 " +output);
		String input = readSocket();
		input= input.substring(7,input.length()-5);
		if(input.equals("OK")){
			return input;
		}
		else{
			completeWeighing(output);
		}
		return input;
	}

	
	public String taraWeight() {
		writeToSocket("T\r\n");
		String input = readSocket();
		input= input.substring(7,input.indexOf("kg"));
		return input;
	}

	
	public String getWeight() {
		writeToSocket("S\r\n");
		String input = readSocket();
		input = input.substring(7, input.indexOf("kg"));
		return input;
	}


}
