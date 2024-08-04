package controller;

import view.UserUI;

import java.util.Scanner;

public class TestViewController {
    public static void main(String[] args) {
        UserUI userUI = new UserUI();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {Thread.sleep(300);} catch (InterruptedException e) {e.printStackTrace();}

            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employee by Empno");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    userUI.acceptEmpDetailsAndStore();
                    break;
                case 2:
                    userUI.displayEmpByEmpno();
                    break;
                case 3:
                    System.out.println("Exiting the application...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
