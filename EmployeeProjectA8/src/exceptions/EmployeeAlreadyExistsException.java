package exceptions;

public class EmployeeAlreadyExistsException extends Exception {
    public EmployeeAlreadyExistsException(String message) {
        super(message);
    }
}
