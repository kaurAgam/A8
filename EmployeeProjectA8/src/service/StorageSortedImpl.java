package service;

import beans.Employee;
import exceptions.EmployeeAlreadyExistsException;
import exceptions.EmployeeNotFoundException;

import java.util.Set;
import java.util.TreeSet;

public class StorageSortedImpl implements Storage {
    private Set<Employee> employees;

    public StorageSortedImpl() {
        this.employees = new TreeSet<>();
    }

    @Override
    public void addEmployee(Employee e) throws EmployeeAlreadyExistsException {
        if (!employees.add(e)) {
            throw new EmployeeAlreadyExistsException("Employee with empno " + e.getEmpno() + " already exists.");
        }
    }

    @Override
    public Employee getEmployee(int empno) throws EmployeeNotFoundException {
        return employees.stream()
                .filter(e -> e.getEmpno() == empno)
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with empno " + empno + " not found."));
    }

    public Set<Employee> getAllEmployees() {
        return new TreeSet<>(employees);
    }
}
