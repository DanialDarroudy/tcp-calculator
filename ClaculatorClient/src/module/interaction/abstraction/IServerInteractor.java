package module.interaction.abstraction;

import java.io.IOException;
import java.net.Socket;

public interface IServerInteractor {
    void interact(Socket socket) throws IOException;
}
