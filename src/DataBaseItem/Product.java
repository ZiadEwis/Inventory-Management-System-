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
    public Product(String productID, String productName, String manufacturerName, String
            supplierName, int quantity, float price)
    {
        this.productID = productID;
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.supplierName = supplierName;
        this.quantity = quantity;
        this.price = price;
    }
    public float getPrice() {
        return price;
    }
    public int getQuantity()
    {
        return quantity;
    }
    public void setQuantity(int quantity)
    {
        if(quantity >= 0)
            this.quantity = quantity;
    }
    @Override
    public String lineRepresentation()
    {
        String line = productID+","+productName+","+manufacturerName+","+supplierName+","+quantity+","+price;
        return line;
    }
    @Override
    public String getSearchKey()
    {
        return productID;
    }
}