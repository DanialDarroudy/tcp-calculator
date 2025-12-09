package module.service.business;

import module.interaction.abstraction.IServerInteractor;
import module.service.abstraction.IClientService;
import java.io.IOException;
import java.net.Socket;

public class ClientService implements IClientService {
    private static final int PORT = 8080;
    private static final String DOMAIN = "localhost";
    private final IServerInteractor serverInteractor;

    public ClientService(IServerInteractor serverInteractor){
        this.serverInteractor = serverInteractor;
    }

    @Override
    public void startProgram() throws IOException {
        var socket = new Socket(DOMAIN, PORT);
        serverInteractor.interact(socket);
        socket.close();
    }
}
