package DataBaseItem;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Product extends DatabaseItem {
    private String employeeId;
    private String name;
    private String emai;
    private String address;
    private String phoneNumber;
    public EmployeeUser(String employeeId, String name, String email, String address, String phoneNumber)
    {
        this.employeeId = employeeId;
        this.name = name;
        this.emai = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    public String lineRepresentation()
    {
        String line = employeeId + "," + name + "," + emai + "," + address + "," + phoneNumber;
        return line;
    }
    public String getSearchKey()
    {
        return employeeId;
    }
}