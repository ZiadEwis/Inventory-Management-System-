package Employee;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import DataBase.ProductDatabase;
import DataBase.CustomerProductDatabase;
import DataBaseItem.Product;
import DataBaseItem.CustomerProduct;

public class EmployeeRole {

    private ProductDatabase productDatabase;
    private CustomerProductDatabase customerProductDatabase;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public EmployeeRole() {
        this.productDatabase = new ProductDatabase("Products.txt");
        customerProductDatabase = new CustomerProductDatabase("CustomersProducts.txt");
    }
    
    public void addProduct(String productID, String productName, String manufacturerName, String supplierName, int quantity) {
        Product newProduct = new Product(productID, productName, manufacturerName, supplierName, quantity, 0.0f);
        productDatabase.insertRecord(newProduct);
    }

    public void addProduct(String productID, String productName, String manufacturerName, String supplierName, int quantity, float price) {
        Product newProduct = new Product(productID, productName, manufacturerName, supplierName, quantity, price);
        productDatabase.insertRecord(newProduct);
    }

    public Product[] getListOfProducts() {
        return productDatabase.returnAllRecords().toArray(new Product[0]);
    }

    public CustomerProduct[] getListOfPurchasingOperations() { 
        return customerProductDatabase.returnAllRecords().toArray(new CustomerProduct[0]);
    }

    public boolean purchaseProduct(String customerSSN, String productID, LocalDate purchaseDate) {
        if (!productDatabase.contains(productID)) {
            return false; //check if it even exist??
        }        //it exist!
        Product p = productDatabase.getRecord(productID); //we got the product
        if (p.getQuantity() == 0) {
            return false;
        }
        p.setQuantity(p.getQuantity() - 1);
        CustomerProduct purchase = new CustomerProduct(customerSSN, productID, purchaseDate); //record the purchaseeee
        return true;
    }

    public double returnProduct(String customerSSN, String productID, LocalDate purchaseDate, LocalDate returnDate) {
        if (returnDate.compareTo(purchaseDate) < 0 /*return date is smaller than purchase date (it's earlier)*/) {
            return -1;
        }
        if (!productDatabase.contains(productID)) {
            return -1;
        }
        String form = customerSSN + "," + productID + "," + purchaseDate.format(DATE_FORMATTER); // just to format it as dd mm yyyy
        if (!customerProductDatabase.contains(form)) {
            return -1; // the purchase doesn't exist

        }
        LocalDate today = LocalDate.now(); //gets today's date, copy pasta from googglle
        long dayDiff = ChronoUnit.DAYS.between(purchaseDate, returnDate);
        if (dayDiff > 14) {
            return -1;
        }

        //now we finished all the checks, now update and save
        Product p = productDatabase.getRecord(productID);
        p.setQuantity(p.getQuantity() + 1); // because the product is now back in the store
        customerProductDatabase.deleteRecord(form); // delete record from the customerproductdatabse class
        return p.getPrice(); //return the product price
    }

    public boolean applyPayment(String customerSSN, LocalDate purchaseDate) {
        for (CustomerProduct p : customerProductDatabase.returnAllRecords()) {
            if (p.getCustomerSSN().equals(customerSSN) && p.getPurchaseDate().equals(purchaseDate)) {
                //check if it is paid
                if (!p.isPaid()) {
                    p.setPaid(true);
                    return true;
                }
            }
        }
        return false; //the purchase wasn't even fount
    }

    public void logout() { // it literally should just save everthring and logout
        productDatabase.saveToFile();
        customerProductDatabase.saveToFile();
    }
}
