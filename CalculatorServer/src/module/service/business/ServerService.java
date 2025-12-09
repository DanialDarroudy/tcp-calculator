package module.service.business;

import module.interaction.abstraction.IClientInteractor;
import module.service.abstraction.IServerService;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerService implements IServerService {
    private static final int PORT = 8080;
    private final IClientInteractor clientInteractor;

    public ServerService(IClientInteractor clientInteractor) {
        this.clientInteractor = clientInteractor;
    }

    public void startProgram() throws IOException {
        var serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running...");

        while (true) {
            var clientSocket = serverSocket.accept();
            new Thread(() -> {
                try {
                    clientInteractor.interact(clientSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
