import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	private static ArrayList<Integer> primeList=new ArrayList<Integer>();
	public static ObjectOutputStream outputToClient;
    public static ObjectInputStream outputFromClient;
    static final int PORT = 1040;
    
    //borrowed from https://stackoverflow.com/questions/20798391/java-isprime-function
    public static boolean isPrime(int n) {
	    	if(n<2)
	    		return false;
	    	if(n== 2)
	    		return true;
	    	if (n % 2 == 0) return false;
	    	for (int i = 3; i * i <= n; i += 2)
	    		if (n % i == 0) 
	    			return false;
	    	return true;
    }
    
    @SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, ClassNotFoundException{
    		ServerSocket serverSocket = null;
		Socket socket = null;
		
        try{
        		serverSocket = new ServerSocket(PORT);
	        	socket = serverSocket.accept();
	        	
	        	outputToClient = new ObjectOutputStream(socket.getOutputStream());
	        outputFromClient = new ObjectInputStream(socket.getInputStream());
	        
	        while(true)  {
		        	ArrayList<Integer> clientList = (ArrayList<Integer>) outputFromClient.readObject();
		        	
		        	for(int i=0; i<clientList.size(); i++) {
		        		if (isPrime(clientList.get(i))) {
		        			primeList.add(clientList.get(i));
		        		}
		        		}
		        			outputToClient.writeObject(primeList);
		        			socket.close();
	        			
        	}} catch (IOException e) {
        		System.out.println("error: " + e);
        }catch(ClassNotFoundException e) {
        		e.printStackTrace();
       }finally {
	    	   	try{
	    	   		if (serverSocket != null) {
					serverSocket.close();
	    	   		}
				if (outputToClient != null) {
					outputToClient.close();
				}
				if (outputFromClient != null) {
					outputFromClient.close();}
			}catch (IOException ex) {
    				ex.printStackTrace();
    			}
	   }
  }
}
