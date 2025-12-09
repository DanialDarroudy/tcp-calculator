package module.operation.abstraction;

public interface IOperatorFactory {
    IOperator CreateOperator(String operation);
}
