package module.operation.business;

import module.operation.abstraction.IOperator;

public class Summator implements IOperator {
    @Override
    public Double operate(int firstNumber, int secondNumber) {
        return (double) (firstNumber + secondNumber);
    }
}
