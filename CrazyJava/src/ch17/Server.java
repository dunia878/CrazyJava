package ch17;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public Server() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException{
		ServerSocket ss = new ServerSocket(30000);
		while(true){
			Socket socket = ss.accept();
			PrintStream ps = new PrintStream(socket.getOutputStream());
			for (int i = 0; i < 10; i++) {
				
				ps.println("hello");
			}
			ps.close();
			socket.close();
			ss.close();
		}
	}

}
