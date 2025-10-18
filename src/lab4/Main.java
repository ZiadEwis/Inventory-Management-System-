package lab4;

import Admin.AdminRole;
import java.util.Scanner;
import Employee.EmployeeRole;
import DataBaseItem.EmployeeUser;
import DataBaseItem.Product;
import DataBaseItem.CustomerProduct;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== INVENTORY MANAGEMENT SYSTEM ===");
        
        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Admin Login");
            System.out.println("2. Employee Login");
            System.out.println("3. Exit System");
            System.out.print("Enter your choice: ");
            
            int mainChoice = scanner.nextInt();
            scanner.nextLine();
            
            if (mainChoice == 1) {
                handleAdminMenu(scanner);
            } else if (mainChoice == 2) {
                handleEmployeeMenu(scanner);
            } else if (mainChoice == 3) {
                System.out.println("Thank you for using our system. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            }
        }
        
        scanner.close();
    }
    
    public static void handleAdminMenu(Scanner scanner) {
        AdminRole admin = new AdminRole();
        
        while (true) {
            System.out.println("\n=== ADMIN PANEL ===");
            System.out.println("1. Add New Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Remove Employee");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            if (choice == 1) {
                System.out.println("\n--- Add New Employee ---");
                System.out.print("Employee ID: ");
                String id = scanner.nextLine();
                System.out.print("Full Name: ");
                String name = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Address: ");
                String address = scanner.nextLine();
                System.out.print("Phone Number: ");
                String phone = scanner.nextLine();
                
                admin.addEmployee(id, name, email, address, phone);
                System.out.println("Employee added successfully!");
                
            } else if (choice == 2) {
                System.out.println("\n--- All Employees ---");
                EmployeeUser[] employees = admin.getListOfEmployees();
                
                if (employees.length == 0) {
                    System.out.println("No employees found in the system.");
                } else {
                    for (EmployeeUser emp : employees) {
                        System.out.println(emp.lineRepresentation());
                    }
                    System.out.println("Total employees: " + employees.length);
                }
                
            } else if (choice == 3) {
                System.out.print("\nEnter Employee ID to remove: ");
                String id = scanner.nextLine();
                admin.removeEmployee(id);
                System.out.println("Employee removed successfully!");
                
            } else if (choice == 4) {
                admin.logout();
                System.out.println("Returning to main menu...");
                break;
                
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        }
    }
    
    public static void handleEmployeeMenu(Scanner scanner) {
        EmployeeRole employee = new EmployeeRole();
        
        while (true) {
            System.out.println("\n=== EMPLOYEE PANEL ===");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Sell Product");
            System.out.println("4. Return Product");
            System.out.println("5. View Purchases");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            if (choice == 1) {
                System.out.println("\n--- Add New Product ---");
                System.out.print("Product ID: ");
                String id = scanner.nextLine();
                System.out.print("Product Name: ");
                String name = scanner.nextLine();
                System.out.print("Manufacturer: ");
                String manufacturer = scanner.nextLine();
                System.out.print("Supplier: ");
                String supplier = scanner.nextLine();
                System.out.print("Quantity: ");
                int quantity = scanner.nextInt();
                System.out.print("Price: ");
                float price = scanner.nextFloat();
                scanner.nextLine();
                
                employee.addProduct(id, name, manufacturer, supplier, quantity, price);
                System.out.println("Product added successfully!");
                
            } else if (choice == 2) {
                System.out.println("\n--- All Products ---");
                Product[] products = employee.getListOfProducts();
                
                if (products.length == 0) {
                    System.out.println("No products found in the system.");
                } else {
                    for (Product product : products) {
                        System.out.println(product.lineRepresentation());
                    }
                }
                
            } else if (choice == 3) {
                System.out.println("\n--- Sell Product ---");
                System.out.print("Customer SSN: ");
                String ssn = scanner.nextLine();
                System.out.print("Product ID: ");
                String productId = scanner.nextLine();
                System.out.print("Purchase Date (YYYY-MM-DD): ");
                String dateStr = scanner.nextLine();
                
                // This will be implemented by teammates
                System.out.println("Sell feature - Under development");
                
            } else if (choice == 4) {
                System.out.println("\n--- Return Product ---");
                System.out.print("Customer SSN: ");
                String ssn = scanner.nextLine();
                System.out.print("Product ID: ");
                String productId = scanner.nextLine();
                System.out.print("Purchase Date (YYYY-MM-DD): ");
                String purchaseDate = scanner.nextLine();
                System.out.print("Return Date (YYYY-MM-DD): ");
                String returnDate = scanner.nextLine();
                
                // This will be implemented by teammates
                System.out.println("Return feature - Under development");
                
            } else if (choice == 5) {
                System.out.println("\n--- Purchase History ---");
                CustomerProduct[] purchases = employee.getListOfPurchasingOperations();
                
                if (purchases.length == 0) {
                    System.out.println("No purchase records found.");
                } else {
                    for (CustomerProduct purchase : purchases) {
                        System.out.println(purchase.lineRepresentation());
                    }
                }
                
            } else if (choice == 6) {
                employee.logout();
                System.out.println("Returning to main menu...");
                break;
                
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}