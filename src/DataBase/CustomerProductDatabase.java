package DataBase;

import DataBaseItem.CustomerProduct;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomerProductDatabase extends BaseDatabase<CustomerProduct> {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    
    public CustomerProductDatabase(String filename) {
        super(filename);
    }
    
    @Override
    protected CustomerProduct createRecordFrom(String line) {
        String[] parts = line.split(",");
        if (parts.length == 4) {
            try {
                String customerSSN = parts[0].trim();
                String productID = parts[1].trim();
                LocalDate purchaseDate = LocalDate.parse(parts[2].trim(),DATE_FORMATTER);
                boolean paid = Boolean.parseBoolean(parts[3].trim());
                return new CustomerProduct(customerSSN, productID, purchaseDate, paid);
            } catch (Exception e) {
                System.err.println("Error parsing CustomerProduct line: " + line);
            }
        }
        return null;
    }
    
    @Override
    protected String getSearchKeyFromRecord(CustomerProduct record) {
        return record.getSearchKey();
    }
    
    @Override
    protected String getLineRepresentationFromRecord(CustomerProduct record) {
        return record.lineRepresentation();
    }
}
