import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    static ObjectOutputStream toServer;
    static ObjectInputStream fromServer;
    static ArrayList<Integer> numberList=new ArrayList<Integer>();
    static final int PORT = 1040;
    
    public static void main(String[]args) throws IOException, ClassNotFoundException{
    		String host = null;
    		Scanner scanner = new Scanner(System.in); 
        Socket socket = new Socket(host, PORT);   
        
        System.out.println("Enter an integer (“!” to send):");
        String input = scanner.next();
        while(input.equals("!")==false) {
        		int num = Integer.parseInt(input);
        		if(num>0) {
				numberList.add(num);
				System.out.println("Enter an integer (“!” to send):");
				input=scanner.next();}
        }
		scanner.close();
		System.out.println("Send: "+ numberList);
		toServer = new ObjectOutputStream(socket.getOutputStream());
        fromServer = new ObjectInputStream(socket.getInputStream());
        try {
	        toServer.writeObject(numberList);
	        toServer.flush();
	        
	        Object result = fromServer.readObject();
	        System.out.println("Recieve: "+result);
        } catch (IOException ex) {
        		System.err.println(ex);
        }finally {
			try {
				
				if (socket != null) {
					socket.close();
				}
				if (toServer != null) {
					toServer.close();
				}
				if (fromServer != null) {
					fromServer.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
         
    }
  }
}