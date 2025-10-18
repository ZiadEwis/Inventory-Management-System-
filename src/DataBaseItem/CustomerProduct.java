package DataBaseItem;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomerProduct extends DatabaseItem{
    private String customerSSN;
    private String productID;
    private LocalDate purchaseDate;
    private boolean paid;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    
    public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate)
    {
        this.customerSSN = customerSSN;
        this.productID = productID;
        this.purchaseDate = purchaseDate;
        this.paid = false;
    }
    public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate, boolean paid) {
        this.customerSSN = customerSSN;
        this.productID = productID;
        this.purchaseDate = purchaseDate;
        this.paid = paid;
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
        return customerSSN + "," + productID + "," + purchaseDate.format(DATE_FORMATTER) + "," + paid;
    }
    public boolean isPaid()
    {
        return paid;
    }
    public void setPaid(boolean paid)
    {
        this.paid = paid;
    }
    public String getSearchKey()
    {
        return customerSSN + "," + productID + "," + purchaseDate.format(DATE_FORMATTER);
    }
}