package beans;

import java.util.Date;
import java.util.Objects;

public class Employee implements Comparable<Employee> {
    private int empno;
    private String firstName;
    private String lastName;
    private String city;
    private double salary;
    private Date dateOfJoining;

    // Constructor, getters, setters, etc.

    public Employee(int empno, String firstName, String lastName, String city, double salary, Date dateOfJoining) {
        this.empno = empno;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.salary = salary;
        this.dateOfJoining = dateOfJoining;
    }

    // Getters and setters for dateOfJoining

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    @Override
    public int hashCode() {
        return Objects.hash(empno);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return empno == employee.empno;
    }

    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.empno, other.empno);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empno=" + empno +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", salary=" + salary +
                ", dateOfJoining=" + dateOfJoining +
                '}';
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
