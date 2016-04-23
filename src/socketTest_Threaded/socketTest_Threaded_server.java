package socketTest_Threaded;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class socketTest_Threaded_server {
	public static void main (String args[]) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the IP address of the server:");
		String hostname=sc.nextLine();
		System.out.println("Enter the common port number:");
		int port_number=sc.nextInt();
		//int port_number=5006;
		//String hostname="192.168.1.219";
		try {
			ServerSocket server_socket=new ServerSocket(port_number);
			Socket client_socket= server_socket.accept();
			
			socketTest_Threaded_server_reader listener=new socketTest_Threaded_server_reader(client_socket);
			socketTest_Threaded_server_writer writer=new socketTest_Threaded_server_writer(client_socket);
			listener.start();
			writer.start();
			/*PrintWriter output = new PrintWriter(client_socket.getOutputStream(),true);
			BufferedReader input = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
			BufferedReader stdIn=new BufferedReader(new InputStreamReader(System.in));
			output.println("Established");
			String fromUser, fromServer;
			while ((fromUser=input.readLine())!=null) {
				System.out.println("Client: "+fromUser);
				if (fromUser.equals("Bye.")) {
					break;
				} 
				fromServer=stdIn.readLine();
				if (fromServer!=null) {
					System.out.println("Server: "+fromServer);
					output.println(fromServer);
				}
			}
			*/
		} catch (Exception e) {
			System.out.println("Could not establish a connection with the Client");
		}
	}
}
