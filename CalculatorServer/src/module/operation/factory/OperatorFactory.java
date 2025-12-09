package module.operation.factory;

import module.operation.abstraction.IOperator;
import module.operation.abstraction.IOperatorFactory;
import module.operation.business.Divider;
import module.operation.business.Multiplier;
import module.operation.business.Subtractor;
import module.operation.business.Summator;

import java.util.HashMap;
import java.util.Map;

public class OperatorFactory implements IOperatorFactory {
    private final Map<String, IOperator> operators = new HashMap<>();

    public OperatorFactory() {
        operators.put("+", new Summator());
        operators.put("*", new Multiplier());
        operators.put("/", new Divider());
        operators.put("-", new Subtractor());
    }

    @Override
    public IOperator CreateOperator(String operation) {
        return operators.get(operation);
    }
}
