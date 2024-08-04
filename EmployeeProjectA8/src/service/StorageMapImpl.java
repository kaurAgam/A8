package service;

import beans.Employee;
import exceptions.EmployeeAlreadyExistsException;
import exceptions.EmployeeNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class StorageMapImpl implements Storage {
    private Map<Integer, Employee> employeeMap;

    public StorageMapImpl() {
        this.employeeMap = new HashMap<>();
    }

    @Override
    public void addEmployee(Employee e) throws EmployeeAlreadyExistsException {
        if (employeeMap.containsKey(e.getEmpno())) {
            throw new EmployeeAlreadyExistsException("Employee with empno " + e.getEmpno() + " already exists.");
        }
        employeeMap.put(e.getEmpno(), e);
    }

    @Override
    public Employee getEmployee(int empno) throws EmployeeNotFoundException {
        Employee employee = employeeMap.get(empno);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with empno " + empno + " not found.");
        }
        return employee;
    }

    public Map<Integer, Employee> getAllEmployees() {
        return new HashMap<>(employeeMap);
    }
}
