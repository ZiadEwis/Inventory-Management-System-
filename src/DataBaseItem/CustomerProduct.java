package DataBaseItem;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.time.LocalDate;

public class CustomerProduct extends DatabaseItem{
    private String customerSSN;
    private String productID;
    private LocalDate purchaseDate;
    private boolean paid;
    public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate, boolean paid)
    {
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
        StringBuilder tmp = new StringBuilder(purchaseDate.toString());
        tmp.reverse();
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
    public String getSearchKey()
    {
        return productID;
    }
}