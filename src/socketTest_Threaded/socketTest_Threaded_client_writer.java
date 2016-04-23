package socketTest_Threaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class socketTest_Threaded_client_writer extends Thread{
	
	Socket client_socket;
	
	public socketTest_Threaded_client_writer (Socket s) {
		client_socket=s;
	}
	public void run(){
		//System.out.println("writer thread has started");
		try {
			PrintWriter output = new PrintWriter(client_socket.getOutputStream(),true);
			BufferedReader stdIn=new BufferedReader(new InputStreamReader(System.in));
			String fromUser;
			while (!(fromUser=stdIn.readLine()).equals("EXIT")) {
				System.out.println("Client: "+fromUser);
				output.println(fromUser);	
			}
					
		} catch (IOException e) {
			
		}
	}

}
