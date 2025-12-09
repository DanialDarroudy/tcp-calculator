package core.installer;

import core.container.DIContainer;
import module.operation.abstraction.IOperatorFactory;
import module.operation.factory.OperatorFactory;
import module.interaction.abstraction.IClientInteractor;
import module.service.abstraction.IServerService;
import module.interaction.business.ClientInteractor;
import module.service.business.ServerService;

public class DependencyInstaller {
    private static boolean installed = false;

    public static synchronized void install() {
        if (installed) {
            return;
        }

        DIContainer.register(IServerService.class, ServerService.class);
        DIContainer.register(IClientInteractor.class, ClientInteractor.class);
        DIContainer.register(IOperatorFactory.class, OperatorFactory.class);


        installed = true;
    }

}
