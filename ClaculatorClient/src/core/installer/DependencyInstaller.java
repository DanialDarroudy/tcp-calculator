package core.installer;

import core.container.DIContainer;
import module.interaction.abstraction.IServerInteractor;
import module.interaction.business.ServerInteractor;
import module.service.abstraction.IClientService;
import module.service.business.ClientService;

public class DependencyInstaller {
    private static boolean installed = false;

    public static synchronized void install() {
        if (installed) {
            return;
        }

        DIContainer.register(IClientService.class, ClientService.class);
        DIContainer.register(IServerInteractor.class, ServerInteractor.class);


        installed = true;
    }

}
