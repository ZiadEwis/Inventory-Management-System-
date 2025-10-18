package DataBaseItem;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class EmployeeUser extends DatabaseItem {
    private String employeeId;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    public EmployeeUser(String employeeId, String name, String email, String address, String phoneNumber)
    {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    public String lineRepresentation()
    {
        String line = employeeId + "," + name + "," + email + "," + address + "," + phoneNumber;
        return line;
    }
    public String getSearchKey()
    {
        return employeeId;
    }
}