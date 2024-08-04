package service;

import beans.Employee;
import exceptions.EmployeeAlreadyExistsException;
import exceptions.EmployeeNotFoundException;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StorageFileImpl implements Storage {
    private static final String FILE_PATH = "employee.txt";
    private List<Employee> employees;

    public StorageFileImpl() {
        this.employees = new ArrayList<>();
        loadEmployeesFromFile();
    }

    private void loadEmployeesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("data/employee.txt"))) {
            String line;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] details = line.split(",");
                if (details.length != 6) continue; // Adjusted for new field
                try {
                    int empno = Integer.parseInt(details[0]);
                    String firstName = details[1];
                    String lastName = details[2];
                    String city = details[3];
                    double salary = Double.parseDouble(details[4]);
                    Date dateOfJoining = sdf.parse(details[5]);
                    employees.add(new Employee(empno, firstName, lastName, city, salary, dateOfJoining));
                } catch (NumberFormatException | ParseException e) {
                    System.err.println("Skipping line due to parsing error: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addEmployee(Employee e) throws EmployeeAlreadyExistsException {
        if (employees.contains(e)) {
            throw new EmployeeAlreadyExistsException("Employee with empno " + e.getEmpno() + " already exists.");
        }
        employees.add(e);
        writeEmployeeToFile(e);
    }

    private void writeEmployeeToFile(Employee e) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String line = String.format("%d,%s,%s,%s,%.2f,%s",
                    e.getEmpno(), e.getFirstName(), e.getLastName(),
                    e.getCity(), e.getSalary(), sdf.format(e.getDateOfJoining()));
            writer.write(line);
            writer.newLine();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
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
