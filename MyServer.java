import java.net.*;		//For Networking
import java.io.*;		//For Input Output


//----------------------------------------------------------------------------------------------------------------------


public class MyServer 
{
	public static void main(String[] args)
	{				

		try 	//Tries connecting to the Client
		{	
			ServerSocket ss = new ServerSocket(6666);		//Creates ServerSocket
			Socket s = ss.accept();							//ServerSocket creates a Socket for accepting data(Strings)
			DataInputStream dis = new DataInputStream(s.getInputStream());	
			String str = (String)dis.readUTF();				//Reads a String from the Data Input Stream
			while (!str.equals("STOP"))						
			{
				System.out.println(str);					//Prints the string unless it is "STOP"
				str = (String) dis.readUTF();				//Reads a new string from Data Input String
			}
			ss.close();										//Closes Socket when new string is "STOP"
		}
		
		
		catch(Exception e)
		{
			System.out.println("Cannot connect");
			System.exit(0);
		}
		
	}
}