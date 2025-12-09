package module.interaction.business;

import module.interaction.abstraction.IClientInteractor;
import module.operation.abstraction.IOperatorFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientInteractor implements IClientInteractor {
    private final IOperatorFactory operatorFactory;

    public ClientInteractor(IOperatorFactory operatorFactory) {
        this.operatorFactory = operatorFactory;
    }

    @Override
    public void interact(Socket socket) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        var writer = new PrintWriter(socket.getOutputStream(), true);

        while (true) {
            var command = reader.readLine();
            if (command.equalsIgnoreCase("exit")) {
                break;
            }

            if (!command.equalsIgnoreCase("start")) {
                writer.println("Please write the 'start' or 'exit' commands.");
                continue;
            }
            writer.println("ok");

            var firstNumber = Integer.parseInt(reader.readLine());
            var secondNumber = Integer.parseInt(reader.readLine());
            var operation = reader.readLine();

            var operator = operatorFactory.CreateOperator(operation);
            if (operator == null) {
                writer.println("Please write '*' or '/' or '-' or '+'.");
                continue;
            }
            var result = operator.operate(firstNumber, secondNumber);
            if (result == null) {
                writer.println("Second number cant be zero.");
                continue;
            }
            writer.println("Result: " + result);
        }
        socket.close();
    }
}
