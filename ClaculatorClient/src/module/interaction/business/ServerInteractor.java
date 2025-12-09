package module.interaction.business;

import module.interaction.abstraction.IServerInteractor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerInteractor implements IServerInteractor {
    @Override
    public void interact(Socket socket) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        var writer = new PrintWriter(socket.getOutputStream(), true);
        var scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter command (start/exit): ");
            var command = scanner.nextLine();
            writer.println(command);

            var response = reader.readLine();
            if (response == null) {
                System.out.println("Server closed connection.");
                break;
            }
            System.out.println("Server: " + response);

            if (!response.equalsIgnoreCase("ok")) {
                continue;
            }

            System.out.print("Enter first number: ");
            writer.println(scanner.nextLine());

            System.out.print("Enter second number: ");
            writer.println(scanner.nextLine());

            System.out.print("Enter operator (+ - * /): ");
            writer.println(scanner.nextLine());

            System.out.println("Server: " + reader.readLine());
        }
    }
}
