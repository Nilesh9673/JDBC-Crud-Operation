package com.jsp.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.dao.ProductDao;
import com.jsp.dto.Product;

public class BatchExecutaion {
	public static void main(String[] args) {

		Product product = new Product();
		product.setId(3);
		product.setName("T-Shirt");
		product.setPrice(399);
		product.setColour("red");

		Product product1 = new Product();
		product1.setId(4);
		product1.setName("Denium-Shirt");
		product1.setPrice(899);
		product1.setColour("bule");

		Product product2 = new Product();
		product2.setId(5);
		product2.setName("Shoes");
		product2.setPrice(1499);
		product2.setColour("green");

		List<Product> productList = new ArrayList<Product>();
		productList.add(product);
		productList.add(product1);
		productList.add(product2);

		ProductDao productDao = new ProductDao();
		try {
			productDao.addMultipleProduct(productList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
