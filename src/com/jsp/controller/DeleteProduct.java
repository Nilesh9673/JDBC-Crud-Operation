package com.jsp.controller;

import com.jsp.dao.ProductDao;
import com.jsp.dto.Product;

public class DeleteProduct {
	public static void main(String[] args) {
		ProductDao productDao = new ProductDao();
		Product product = productDao.deleteProduct(5);
		if (product != null) {
			System.out.println("Product is deleted");
		} else {
			System.out.println("no such Product Id");
		}
	}
}
