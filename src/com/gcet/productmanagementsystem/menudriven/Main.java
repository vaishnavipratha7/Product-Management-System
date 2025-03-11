package com.gcet.productmanagementsystem.menudriven;

import java.util.Scanner;

public class Main {   
	
	public static void main(String[] args) {
		
  ProductManager productManager = new ProductManager();
  Scanner scanner = new Scanner(System.in);
  boolean exit = false;

  while (!exit) {
      System.out.println("Product Management System");
      System.out.println("1. Add Product");
      System.out.println("2. Update Product");
      System.out.println("3. Delete Product");
      System.out.println("4. View Product");
      System.out.println("5. View All Products");
      System.out.println("6. Exit");
      System.out.print("Choose an option: ");
      int choice = scanner.nextInt();
      scanner.nextLine();  // Consume newline

      try {
          switch (choice) { 
              case 1:
                  System.out.print("Enter product ID: ");
                  int id = scanner.nextInt();
                  scanner.nextLine();  // Consume newline
                  System.out.print("Enter product name: ");
                  String name = scanner.nextLine();
                  System.out.print("Enter product price: ");
                  String price = scanner.nextLine();
                  productManager.addProduct(new Product(id, name, price));
                  System.out.println("Product added successfully.");
                  break;
              case 2:
                  System.out.print("Enter product ID: ");
                  id = scanner.nextInt();
                  scanner.nextLine();  // Consume newline
                  System.out.print("Enter new product name: ");
                  name = scanner.nextLine();
                  System.out.print("Enter new product price: ");
                  price = scanner.nextLine();
                  productManager.updateProduct(id, name, price);
                  System.out.println("Product updated successfully.");
                  break;
              case 3:
                  System.out.print("Enter product ID: ");
                  id = scanner.nextInt();
                  productManager.deleteProduct(id);
                  System.out.println("Product deleted successfully.");
                  break;
              case 4:
                  System.out.print("Enter product ID: ");
                  id = scanner.nextInt();
                  Product product = productManager.getProduct(id);
                  System.out.println("Product details: " + product);
                  break;
              case 5:
                  System.out.println("All products: " + productManager.getAllProducts());
                  break;
              case 6:
                  exit = true;
                  break;
              default:
                  System.out.println("Invalid option. Please try again.");
          }
      } catch (Exception e) {
          System.out.println(e.getMessage());
      }
  }

  scanner.close();
}
}