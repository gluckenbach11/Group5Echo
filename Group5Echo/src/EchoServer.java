
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author gluck
 */
public class EchoServer {

    
    public static void main(String[] args) {
        String inputLine;
        
        System.out.println("Group 5 Echo Server");
        
        try(ServerSocket serverSocket = new ServerSocket(6000)) {
            System.out.println("Awaiting connection to client...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected to client");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(
                clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);  
            
            while((inputLine = br.readLine()) != null){
                System.out.println("Server: " + inputLine);
                out.println(inputLine);
            }
            serverSocket.close();
            clientSocket.close();
            br.close();
            out.close();
        }
        catch(IOException ex){
        ex.printStackTrace();
        }
        
    }
}   

