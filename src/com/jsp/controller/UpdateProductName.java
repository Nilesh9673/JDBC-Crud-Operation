package com.jsp.controller;

import com.jsp.dao.ProductDao;
import com.jsp.dto.Product;

public class UpdateProductName {
	public static void main(String[] args) {
		ProductDao productDao = new ProductDao();
		Product product = productDao.updateNameById(2, "Paint");
		if (product != null) {
			System.out.println("Name is Updated");
		} else {
			System.out.println("no such Product Id");
		}
	}
}
