package module.operation.business;

import module.operation.abstraction.IOperator;

public class Subtractor implements IOperator {
    @Override
    public Double operate(int firstNumber, int secondNumber) {
        return (double) (firstNumber - secondNumber);
    }
}
