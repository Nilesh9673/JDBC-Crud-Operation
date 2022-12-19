package com.jsp.controller;

import com.jsp.dao.ProductDao;
import com.jsp.dto.Product;

public class UpdateProductPrice {
	public static void main(String[] args) {
		ProductDao productDao = new ProductDao();
		Product product = productDao.updatePriceById(2,500);
		if (product != null) {
			System.out.println("price is Updated");
		} else {
			System.out.println("no such Product Id");
		}
	}
}
