package edu.jspiders.HibernateORM.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.query.spi.ParameterParser;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.mysql.cj.protocol.Resultset;
//import com.mysql.cj.xdevapi.Statement;

public class MyOwnGenerator implements IdentifierGenerator{

	private final static String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	private final static String DB_URL = "jdbc:mysql://localhost:3306/heha22?user=root&password=Root";
	
	private static Connection dbConnection() {
		Connection con = null;
		try {
			Class.forName(DRIVER_CLASS);
			con = DriverManager.getConnection(DB_URL);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
		String pk= "VW";
		int Value = 0001;
		Connection con = dbConnection();
		Statement stm = null;
		ResultSet rs = null;
		try {
			String query = "Select max(VIN) from vehicle";
			stm = con.createStatement();
			rs = stm.executeQuery(query);

			while (rs.next()) {
				String vin = rs.getString(1);
				pk = vin+ pk+ Integer.toString(Value);;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return pk;
	}

}
