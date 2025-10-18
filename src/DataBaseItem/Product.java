package DataBaseItem;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Product extends DatabaseItem{
    private String productID;
    private String productName;
    private String manufacturerName;
    private String supplierName;
    private float price;
    private int quantity;
    public int getQuantity()
    {
        return quantity;
    }
    public void setQuantity(int quantity)
    {
        if(quantity >= 0)
            this.quantity = quantity;
    }
    public String lineRepresentation()
    {
        String line = productID+","+productName+","+manufacturerName+","+supplierName+","+quantity+","+price;
    }
    public String getSearchKey()
    {
        return productID;
    }
}