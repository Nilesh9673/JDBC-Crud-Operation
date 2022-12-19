package com.jsp.controller;

import com.jsp.dao.ProductDao;
import com.jsp.dto.Product;

public class UpdateProductColour {
	public static void main(String[] args) {
		ProductDao productDao = new ProductDao();
		Product product = productDao.updateColourById(3, "white");
		if (product != null) {
			System.out.println("colour is Updated");
		} else {
			System.out.println("no such Product Id");
		}
	}
}
