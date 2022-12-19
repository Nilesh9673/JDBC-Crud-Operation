package com.jsp.controller;

import com.jsp.dao.ProductDao;
import com.jsp.dto.Product;

public class GetAllProduct {
	public static void main(String[] args) {
		ProductDao productDao = new ProductDao();
		Product product = productDao.getAllProduct();

	}
}
