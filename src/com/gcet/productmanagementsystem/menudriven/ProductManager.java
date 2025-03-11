package com.gcet.productmanagementsystem.menudriven;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
	
	  private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(int id, String name, String price) throws ProductNotFoundException {
        Product product = findProductById(id);
        product.setName(name);
        product.setPrice(price);
    }

    public void deleteProduct(int id) throws ProductNotFoundException {
        Product product = findProductById(id);
        products.remove(product);
    }

    public Product getProduct(int id) throws ProductNotFoundException {
        return findProductById(id);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    private Product findProductById(int id) throws ProductNotFoundException {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product not found."));
    }



}


