package module.operation.business;

import module.operation.abstraction.IOperator;

public class Divider implements IOperator {
    @Override
    public Double operate(int firstNumber, int secondNumber) {
        if (secondNumber == 0){
            return null;
        }
        return (double)firstNumber / (double)secondNumber;
    }
}
