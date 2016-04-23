package socketTest_Threaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class socketTest_Threaded_client_reader extends Thread{
	Socket client_socket;
	
	public socketTest_Threaded_client_reader (Socket s) {
		client_socket=s;
	}
	
	public void run() {
		//System.out.println("reader thread has started");
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
			String fromServer;
			while ((fromServer=input.readLine())!=null) {
				System.out.println("Server: "+fromServer);
				if (fromServer.equals("EXIT")) {
					break;
				}
			}
		} catch (IOException e) {
		}
		
	}

}
