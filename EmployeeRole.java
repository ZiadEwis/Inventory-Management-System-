
public class EmployeeRole {

    private ProductDatabase productDatabase;
    private CustomerProductDatabase customerProductDatabase;

    public EmpolyeeRole() {
        productsDatabase = new ProductDatabase("Products.txt");
        productsDatabase.readFromFile(); //read from file that is implemented in customer product database
        customerProductDatabase = new CustomerProductDatabase("CustomersProducts.txt");
        customerProductDatabase.readFromFile(); //read from file that is implemented in customer product database
    }

    public void addProduct(String productID, String productName, String manufacturerName, String supplierName, int quantity, float price) {
        Product newProduct = new Product(productID, productName, manufacturerName, supplierName, quantity, price);
        productsDatabase.insertRecord(newProduct);
        productsDatabase.saveToFile();
    }

    public Product[] getListOfProducts() {
        Arraylist productList = new ArrayList(); //this is the all the product int the database
        Product[] productsArray = new Product[productList.size()]; //now we create the area with length of the list, to put the products into
        productsArray = productList.toArray(productsArray); //toArray convert the list to arrrrrraaaayyy
        return productsArray;
    }

    public CustomerProduct[] getListOfPurchasingOperations() { //it is just teh same as get list of product
        Arraylist opList = new opList();
        Product[] opArray = new CustomerProduct[opList.size()];
        opArray = opList.toArray(opArray);
        return opArray;
    }

    public boolean purchaseProduct(String customerSSN, String productID, LocalDate purchaseDate) {
        if (!productDatabase.contains(productID)) {
            return false; //check if it even exist??
        }        //it exist!
        Product p = productDatabase.getRecord(productID); //we got the product
        if (p.getQuantity() == 0) {
            return false;
        }
        p.setQuantity(p.getQuantity - 1);
        CustomerProduct purchase = new CustomerProduct(customerSSN, productID, purchaseDate); //record the purchaseeee
        productsDatabase.saveToFile(); //save bothh-|
        customerProductDatabase.saveToFile(); //<---|
        return true;
    }

    public double returnProduct(String customerSSN, String productID, LocalDate purchaseDate, LocalDate returnDate) {
        if (returnDate.compareTo(purchaseDate) < 0 /*return date is smaller than purchase date (it's earlier)*/) {
            return -1;
        }
        if (!productDatabase.contains(productID)) {
            return -1;
        }
        String form = customerSSN + "," + productID + "+" + purchaseDate.getDayofMonth()
        purchaseDate.getMonthofYear() + purchaseDate.getYear(); // just to format it as dd mm yyyy
        if (!customerProductDatabase.contains(form)) {
            return -1; // the purchase doesn't exist

        }
        LocalDate today = LocalDate.now(); //gets today's date, copy pasta from googglle
        int dayDiff = today.getDayOfYear() - purchaseDate.getDayOfYear(); //getdayof year is a built in function it counts how many have passed since 1st of jan
        if (dayDiff > 14) {
            return -1;
        }

        //now we finished all the checks, now update and save
        Product p = productsDatabase.getRecord(productID);
        p.setQuantity(p.getQuantity() + 1); // because the product is now back in the store
        customerProductDatabase.deleteRecord(form); // delete record from the customerproductdatabse class
        productsDatabase.saveToFile();
        customerProductDatabase.saveToFile();
        return p.getPrice(); //return the product price
    }

    public boolean applyPayment(String customerSSN, LocalDate purchaseDate) {
        ArrayList purchaseList = customerProductDatabase.returnAllRecords(); //load all the purchase record
        for (int i = 0; i < purchaselist.size(); i++) {
            CustomerProduct p = purchaseList.get(i);  //loop through the whole purchase list
            if (p.getCustomerSSN().equal(customerSSN) && p.getPurchaseDate().equal(purchaseDate)) {
                //check if it is paid
                if (!p.isPaid()) {
                    p.setPaid(true);
                    customerProductDatabase.saveToFile();
                    return true;
                }
            }
        }
        return false; //the purchase wasn't even fount
    }

    public voidlogout() { // it literally should just save everthring and logout
        productsDatabase.saveToFile();
        customerProductDatabase.saveToFile();
    }

}
