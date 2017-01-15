
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;


public class EchoClient {

    public static void main(String[] args) {
        System.out.println("Group 5 Echo Client");
        
        try{
            System.out.println("Awaiting connection to server...");
            InetAddress localAddress = InetAddress.getLocalHost();
            
            try(Socket clientSocket = new Socket(localAddress, 6000);
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader br = new BufferedReader(new InputStreamReader(
                    clientSocket.getInputStream()))){
                
                System.out.println("Connected to server");
                Scanner scanner = new Scanner(System.in);
                
                while(true){
                    System.out.println("Enter text to be echoed: ");
                    String inputLine = scanner.nextLine();
                    if("quit".equalsIgnoreCase(inputLine)){
                        break;
                    }
                    out.println(inputLine);
                    String response = br.readLine();
                    System.out.println("Server response: " + response);
                }
                clientSocket.close();
                br.close();
                out.close();
                }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
}
