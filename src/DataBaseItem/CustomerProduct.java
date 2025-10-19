package DataBaseItem;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.time.LocalDate;

public class CustomerProduct extends DatabaseItem{
    private String customerSSN;
    private String productID;
    private LocalDate purchaseDate;
    private boolean paid;
    public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate)
    {
        this.customerSSN = customerSSN;
        this.productID = productID;
        this.purchaseDate = purchaseDate;
        this.paid = false;
    }
    public String getCustomerSSN()
    {
        return customerSSN;
    }
    public String getProductID()
    {
        return productID;
    }
    public LocalDate getPurchaseDate()
    {
        return purchaseDate;
    }
    public String lineRepresentation(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String tmp = purchaseDate.format(formatter);
        String line = customerSSN + "," + productID + "," + tmp;
        return line;
    }
    public boolean isPaid()
    {
        return paid;
    }
    public void setPaid(boolean paid)
    {
        this.paid = paid;
    }
    @Override
    public String getSearchKey()
    {
        return productID;//
    }
}