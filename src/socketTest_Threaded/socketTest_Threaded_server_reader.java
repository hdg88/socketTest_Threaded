package socketTest_Threaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class socketTest_Threaded_server_reader extends Thread{
	Socket client_socket;
	
	public socketTest_Threaded_server_reader(Socket s) {
		client_socket=s;
	}
	
	public void run () {
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
			String fromUser;
			
			while ((fromUser=input.readLine())!=null) {
				System.out.println("Client: "+fromUser);
				if (fromUser.equals("Bye.")) {
					break;
				} 
			}
			
		} catch (IOException e) {

		}
	}
}
