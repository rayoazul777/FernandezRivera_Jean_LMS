package chapter33;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class PrimeClient {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a number to check for prime: ");
            int numberToCheck = scanner.nextInt();

            Socket socket = new Socket("localhost", 8000);
            DataInputStream inputFromServer = new DataInputStream(socket.getInputStream());
            DataOutputStream outputToServer = new DataOutputStream(socket.getOutputStream());

            // Send the number to the server
            outputToServer.writeInt(numberToCheck);

            // Receive the result from the server
            boolean isPrime = inputFromServer.readBoolean();

            System.out.println("Is " + numberToCheck + " prime? " + isPrime);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
