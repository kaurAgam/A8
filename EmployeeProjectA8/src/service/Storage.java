package service;

import beans.Employee;
import exceptions.EmployeeAlreadyExistsException;
import exceptions.EmployeeNotFoundException;

public interface Storage {
    void addEmployee(Employee e) throws EmployeeAlreadyExistsException;
    Employee getEmployee(int empno) throws EmployeeNotFoundException;
}
