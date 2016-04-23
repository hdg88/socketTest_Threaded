package socketTest_Threaded;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class socketTest_Threaded_client {
	public static void main (String args[]) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the IP address of the server:");
		String hostname=sc.nextLine();
		System.out.println("Enter the common port number:");
		int port_number=sc.nextInt();
		//int port_number=5006; //Port number to initiate connection on
		//String hostname="192.168.1.2"; //target system IP address
		try {
			Socket client_socket= new Socket(hostname,port_number);
			socketTest_Threaded_client_reader listener = new socketTest_Threaded_client_reader(client_socket);
			socketTest_Threaded_client_writer writer = new socketTest_Threaded_client_writer(client_socket);
			listener.start();
			writer.start();
			
			/*PrintWriter output = new PrintWriter(client_socket.getOutputStream(),true);
			BufferedReader input = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
			BufferedReader stdIn=new BufferedReader(new InputStreamReader(System.in));
		
			String fromUser,fromServer;
			while ((fromServer=input.readLine())!=null) {
				System.out.println("Server: "+fromServer);
				if (fromServer.equals("Bye.")) {
					break;
				} 
				fromUser=stdIn.readLine();
				if (fromUser!=null) {
					System.out.println("Client: "+fromUser);
					output.println(fromUser);
				}
				
			}
			*/
		} catch (Exception e) {
			System.out.println("Could not establish a connection with the Server");
		}
	}
}
