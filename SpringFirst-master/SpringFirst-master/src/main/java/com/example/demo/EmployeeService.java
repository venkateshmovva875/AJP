package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeService {
    private Employee employee;
    private Map<Integer, Employee> employeeDatabase = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Map<Integer, Employee> getEmployeeDatabase() {
        return employeeDatabase;
    }

    public void setEmployeeDatabase(Map<Integer, Employee> employeeDatabase) {
        this.employeeDatabase = employeeDatabase;
    }

    public void addEmployee(Employee employee) {
        employeeDatabase.put(employee.getId(), employee);
    }

    public void updateEmployee(Employee updatedEmployee) {
        employeeDatabase.put(updatedEmployee.getId(), updatedEmployee);
    }

    public void deleteEmployee(int employeeId) {
        employeeDatabase.remove(employeeId);
    }

    public Employee getEmployee(int employeeId) {
        return employeeDatabase.get(employeeId);
    }

    public void displayAllEmployees() {
        System.out.println("Employee List:");
        for (Employee emp : employeeDatabase.values()) {
            System.out.println(emp);
        }
    }

    public void runMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Get Employee by ID");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEmployeeFromInput();
                    break;
                case 2:
                    updateEmployeeFromInput();
                    break;
                case 3:
                    deleteEmployeeFromInput();
                    break;
                case 4:
                    getEmployeeById();
                    break;
                case 5:
                    displayAllEmployees();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void addEmployeeFromInput() {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter employee name: ");
        String name = scanner.next();
        Employee newEmployee = new Employee();
        newEmployee.setId(id);
        newEmployee.setName(name);
        addEmployee(newEmployee);
        System.out.println("Employee added successfully.");
    }

    private void updateEmployeeFromInput() {
        System.out.print("Enter employee ID to update: ");
        int id = scanner.nextInt();
        Employee existingEmployee = getEmployee(id);
        if (existingEmployee != null) {
            System.out.print("Enter updated employee name: ");
            String name = scanner.next();
            existingEmployee.setName(name);
            updateEmployee(existingEmployee);
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee not found with ID " + id);
        }
    }

    private void deleteEmployeeFromInput() {
        System.out.print("Enter employee ID to delete: ");
        int id = scanner.nextInt();
        Employee existingEmployee = getEmployee(id);
        if (existingEmployee != null) {
            deleteEmployee(id);
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found with ID " + id);
        }
    }

    private void getEmployeeById() {
        System.out.print("Enter employee ID to retrieve: ");
        int id = scanner.nextInt();
        Employee existingEmployee = getEmployee(id);
        if (existingEmployee != null) {
            System.out.println("Employee details:");
            System.out.println(existingEmployee);
        } else {
            System.out.println("Employee not found with ID " + id);
        }
    }
}
