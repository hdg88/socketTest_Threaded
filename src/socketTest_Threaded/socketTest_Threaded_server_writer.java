package socketTest_Threaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class socketTest_Threaded_server_writer extends Thread{
	Socket client_socket;
	
	public socketTest_Threaded_server_writer(Socket s) {
		client_socket=s;
	}	
	
	public void run () {
		try {
			PrintWriter output = new PrintWriter(client_socket.getOutputStream(),true);
			BufferedReader stdIn=new BufferedReader(new InputStreamReader(System.in));
			String fromServer;
			while (!(fromServer=stdIn.readLine()).equals("EXIT")) {
				System.out.println("Server: "+fromServer);
				output.println(fromServer);
			}
		} catch (IOException e) {

		}
		
	}
}
