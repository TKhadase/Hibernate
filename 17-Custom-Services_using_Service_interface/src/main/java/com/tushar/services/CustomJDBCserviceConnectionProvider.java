package com.tushar.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

public class CustomJDBCserviceConnectionProvider implements ConnectionProvider{

	@Override
	public boolean isUnwrappableAs(Class unwrapType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> unwrapType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("CustomJDBCserviceConnectionProvider.getConnection()");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HIBERNATEDB", "root", "tushar");
		return con;
	}

	@Override
	public void closeConnection(Connection conn) throws SQLException {
		System.out.println("CustomJDBCserviceConnectionProvider.closeConnection()");
		conn.close();
	}

	@Override
	public boolean supportsAggressiveRelease() {
		// TODO Auto-generated method stub
		return false;
	}

}
