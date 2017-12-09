package mainServer;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class MainServer {
	public static void main(String[] args) throws Exception	{
		
		  String clientSentence;
		  String capitalizedSentence;
		  ServerSocket welcomeSocket = new ServerSocket(6789);

		  while (true) {
		  //System.out.println(("waiting for data.."));
		  Socket connectionSocket = welcomeSocket.accept();
		   
		   
		   BufferedReader inFromClient =
		    new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));   
		   clientSentence = inFromClient.readLine();
		   
		   System.out.println("Received: " + clientSentence.toString());
		   
		  }
		  //source: https://systembash.com/a-simple-java-tcp-server-and-tcp-client/
		  
		}
	}

