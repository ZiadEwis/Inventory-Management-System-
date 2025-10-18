/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin;
import java.util.ArrayList;
import java.io.*;


public class AdminRole {
    private EmployeeUserDatabase database;
    
    public AdminRole() {
        this.database = new EmployeeUserDatabase("Employees.txt");
    }
    
    public void addEmployee(String employeeId, String name, String email, String address, String phoneNumber) {
        EmployeeUser newEmployee = new EmployeeUser(employeeId, name, email, address, phoneNumber);
        database.insertRecord(newEmployee);
        database.saveToFile();
    }
    
    public EmployeeUser[] getListOfEmployees() {
        ArrayList<EmployeeUser> employeesList = database.returnAllRecords();
        EmployeeUser[] employeesArray = new EmployeeUser[employeesList.size()];
        return employeesList.toArray(employeesArray);
    }
    
    public void removeEmployee(String key) {
        database.deleteRecord(key);
        database.saveToFile();
    }
    
    public void logout() {
        database.saveToFile();
    }
}
