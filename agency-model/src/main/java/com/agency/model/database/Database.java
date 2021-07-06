package com.agency.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.directory.InvalidAttributeValueException;

import com.agency.model.Tho;

public class Database {
	private String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private String DATABASE_URL = "jdbc:mysql://localhost:3306/khaivan?useSSL=false";
	private String DB_USERNAME = "root";
	private String DB_PASSWORD = "123456789";
	private Connection connection = null;
	private Statement statement = null;
	private Properties properties = null;
	private ResultSet resultSet = null;
	private static Database database = new Database();

	private Database() {

	}

	public static Database getInstance() {
		return database;
	}

	public void connectToDatabase() {
		try {
			Class.forName(this.JDBC_DRIVER);
			this.properties = new Properties();
			properties.put("user", this.DB_USERNAME);
			properties.put("password", this.DB_PASSWORD);

			this.connection = DriverManager.getConnection(DATABASE_URL, this.properties);
			if (this.connection != null) {
				System.out.println("Connected..");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	 public ResultSet executeSQLReturningResultSet(String vSQL) {
		if (this.connection == null) {
			this.connectToDatabase();
		}
		if (this.connection != null) {
			try {
				this.statement = this.connection.createStatement();
				this.resultSet = this.statement.executeQuery(vSQL);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return resultSet;
	}

	public void executeSQLNotReturningResultSet(String vSQL) {

		if (this.connection == null) {
			this.connectToDatabase();
		}
		try {
			this.statement = this.connection.createStatement();
			this.statement.executeUpdate(vSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

	