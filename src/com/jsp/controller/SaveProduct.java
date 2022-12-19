package com.jsp.controller;

import com.jsp.dao.ProductDao;
import com.jsp.dto.Product;

public class SaveProduct {
	public static void main(String[] args) {
		
		Product product = new Product();
		product.setId(3);
		product.setName("Shirt");
		product.setPrice(499);
		product.setColour("black");
		
		ProductDao productDao = new ProductDao();
		Product product1 =productDao.saveProduct(product);
		if(product1!=null) {
			System.out.println("Product is saved");
		}else {
			System.out.println("Product is not saved");
		}
	}
}
