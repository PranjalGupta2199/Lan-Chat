import java.io.*;			// For handling I/O Streams
import java.net.*;			// For Networking
import java.lang.*;			// For ava Language
import java.util.Scanner;   // For Scanning 


//---------------------------------------------------------------------------------------------------------------------------


class MyClient1
{
	public static void main(String[] args)
	{
		try    //Tries connecting to client
		{	
			Socket s = new Socket("192.168.0.103",6666);	//Creates Socket; IP address variable 
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());	//Creates Data Output Stream 		
			Scanner sc = new Scanner(System.in);    //Creates a Scanner 
			System.out.println("Enter your messages");
			String str = sc.nextLine();   //Scans next line
			
			while (!str.equals("STOP"))
			{
				dout.writeUTF(str);    //Wrtes the scanned line into the Data Output Stream
				str = sc.nextLine();   //Scans a new line
			}

			dout.flush();    //Flushes the Data Output Stream when the next line is "Stop"
			dout.close();    //Closes the Data Output Stream
			s.close();       //Closes the Socket
			System.out.println("Closed.");
		}
		catch(Exception e)
		{
			System.out.println("Cannot connect");
		}
	}
}
