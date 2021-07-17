package com.tushar.connectionPool;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

public class Apache_DBCP2_ConnectionPool implements ConnectionProvider {

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
		System.out.println("Apache_DBCP2_ConnectionPool.getConnection()");
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/HIBERNATEDB");
		ds.setUsername("root");
		ds.setPassword("tushar");
		ds.setMaxTotal(20);
		ds.setMaxIdle(10);
		//get Connection
		Connection con = ds.getConnection();
		return con;
	}

	@Override
	public void closeConnection(Connection con) throws SQLException {
		System.out.println("Apache_DBCP2_ConnectionPool.closeConnection()");
		con.close();
	}

	@Override
	public boolean supportsAggressiveRelease() {
		// TODO Auto-generated method stub
		return false;
	}

}
