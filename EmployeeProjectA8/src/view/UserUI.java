package view;

import beans.Employee;
import entity.StorageFactory;
import service.Storage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UserUI {
    private Storage storage;

    public UserUI() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the type of storage implementation you want: 1:File 2:List 3:Sorted 4:Map");
        int storageType=scanner.nextInt();
        this.storage = StorageFactory.getStorage(storageType); // Choose implementation
    }

    public void acceptEmpDetailsAndStore() {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        System.out.print("Enter Employee Number: ");
        int empno = scanner.nextInt();
        System.out.print("Enter First Name: ");
        String firstName = scanner.next();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.next();
        System.out.print("Enter City: ");
        String city = scanner.next();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        System.out.print("Enter Date of Joining (yyyy-MM-dd): ");
        String doj = scanner.next();

        try {
            Date dateOfJoining = sdf.parse(doj);
            Employee employee = new Employee(empno, firstName, lastName, city, salary, dateOfJoining);
            storage.addEmployee(employee);
            System.out.println("Employee added successfully.");
        } catch (ParseException e) {
            System.err.println("Invalid date format. Please use yyyy-MM-dd.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void displayEmpByEmpno() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee Number: ");
        int empno = scanner.nextInt();
        try {
            Employee employee = storage.getEmployee(empno);
            System.out.println(employee);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
