package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.jsp.dto.Product;
import com.jsp.util.HelperClass;

public class ProductDao {

	HelperClass helperClass = new HelperClass();

	// save Product
	public Product saveProduct(Product product) {
		String sql = "Insert into product values (?,?,?,?)";

		Connection connection = helperClass.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setString(4, product.getColour());
			preparedStatement.setDouble(3, product.getPrice());

			preparedStatement.execute();
//			System.out.println("data inserted");

			if (connection != null) {
				connection.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

	// Delete Product
	public Product deleteProduct(int id) {

		String sql = "delete from Product where id=?";
		Connection connection = helperClass.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);

			preparedStatement.execute();
//			System.out.println("Product is delete");

			if (connection != null) {
				connection.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Product();
	}

	// update Product name
	public Product updateNameById(int id, String name) {
		String sql = "update Product set name=? where id=?";
		Connection connection = helperClass.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);

			preparedStatement.execute();
//			System.out.println(product.getName() + " is Updated");

			if (connection != null) {
				connection.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Product();
	}

	// Update Product Price

	public Product updatePriceById(int id, double price) {
		String sql = "update Product set price=? where id=?";
		Connection connection = helperClass.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, price);
			preparedStatement.setInt(2, id);

			preparedStatement.execute();
//			System.out.println(product.getName() + " price is Updated");

			if (connection != null) {
				connection.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Product();

	}

//	update Product Colour
	public Product updateColourById(int id, String colour) {
		String sql = "update Product set colour=? where id=?";
		Connection connection = helperClass.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, colour);
			preparedStatement.setInt(2, id);

			preparedStatement.execute();
//			System.out.println(product.getName() + " colour is Updated");

			if (connection != null) {
				connection.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Product();

	}

	public Product getProductById(int id) {
		String sql = "select * from Product where id=?";
		Connection connection = helperClass.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				System.out.print(resultSet.getInt(1) + " \t");
				System.out.print(resultSet.getString(2) + "\t ");
				System.out.print(resultSet.getString(4) + "\t");
				System.out.print(resultSet.getString(3) + " \t");
				System.out.println();
			}
			if (connection != null) {
				connection.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Product();
	}

	public Product getAllProduct() {
		String sql = "select * from Product ";
		Connection connection = helperClass.getConnection();
		try {
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				System.out.print(resultSet.getInt(1) + " \t");
				System.out.print(resultSet.getString(2) + "\t ");
				System.out.print(resultSet.getString(4) + "\t");
				System.out.print(resultSet.getString(3) + " \t");
				System.out.println();
			}
			if (connection != null) {
				connection.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Product();
	}

	public void addMultipleProduct(List<Product> p) throws SQLException {
		String sql = "insert into Product values(?,?,?,?)";

		Connection connection = helperClass.getConnection();
		for (Product product : p) {
			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, product.getId());
				preparedStatement.setString(2, product.getName());
				preparedStatement.setString(4, product.getColour());
				preparedStatement.setDouble(3, product.getPrice());

				preparedStatement.addBatch();
				preparedStatement.executeBatch();
				System.out.println("Multiple Product Add");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (connection != null) {
			connection.close();
		}
	}
}
