import java.lang.*;
import java.io.*;
import java.util.Scanner;
import java.net.*;


class ClientSocket
{
	Socket s;
	DataOutputStream out;
	DataInputStream in;

	private Client_Socket(String server_addr, int receiver_port){
		// internally called private constructor.
		try {
			this.s = new Socket(server_addr, receiver_port);
			this.out = this.s.getOutputStream();
			this.in = this.s.getInputStream();
		}
		catch (UnknownHostException){
			System.out.println("Could not resolve host. Please try after some time.");
			// write some code when exception occurs since this method should always 
			// return a socket instance
		}
	}
	
	public static Socket connect(String server_addr, int receiver_port){
		// public constructor for socket.
		Client_Socket(server_addr, receiver_port);
	}

	protected void send_message (String message, String receiver_addr){
		// should send message to the server.
		// the server the sends the receiver.
		out.writeUTF(message);
	}

}

