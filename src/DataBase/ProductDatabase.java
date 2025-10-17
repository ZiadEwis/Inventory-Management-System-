package DataBase;

import java.util.ArrayList;

public class ProductDatabase extends BaseDatabase<Product> {
    public ProductDatabase(String filename){
        super(filename);
    }
    
    @Override
     protected Product createRecordFrom(String line) {
        String[] parts = line.split(",");
        if (parts.length == 6) {
            try {
                String productID = parts[0].trim();
                String productName = parts[1].trim();
                String manufacturerName = parts[2].trim();
                String supplierName = parts[3].trim();
                int quantity = Integer.parseInt(parts[4].trim());
                float price = Float.parseFloat(parts[5].trim());
                return new Product(productID,productName,manufacturerName,supplierName,quantity,price);
            } catch (NumberFormatException e) {
                System.err.println("Error parsing quantity or price in line (Product): " + line);
            }
        }
        return null;
    }
     
    @Override
    public String getSearchKeyFromRecord(Product record){
        return record.gerSearchKey();
    }
    
    @Override
    public String getLineRepresentationFromRecord(Product record){
        return record.lineRepresentation();
    }
}
