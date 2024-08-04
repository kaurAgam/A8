package service;

import beans.Employee;
import exceptions.EmployeeAlreadyExistsException;
import exceptions.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class StorageListImpl implements Storage {
    private List<Employee> employees;

    public StorageListImpl() {
        this.employees = new ArrayList<>();
    }

    @Override
    public void addEmployee(Employee e) throws EmployeeAlreadyExistsException {
        if (employees.contains(e)) {
            throw new EmployeeAlreadyExistsException("Employee with empno " + e.getEmpno() + " already exists.");
        }
        employees.add(e);
    }

    @Override
    public Employee getEmployee(int empno) throws EmployeeNotFoundException {
        return employees.stream()
                .filter(e -> e.getEmpno() == empno)
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with empno " + empno + " not found."));
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }
}
