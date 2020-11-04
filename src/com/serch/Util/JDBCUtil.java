package com.serch.Util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

//连接池1
public class JDBCUtil {
	private static Properties prop = new Properties();

	static {
		try {
			prop.load(JDBCUtil.class.getClassLoader().getResourceAsStream("db.pro"));
			Class.forName(prop.getProperty("driver"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
				prop.getProperty("password"));
	}

	public static void free(ResultSet rs, PreparedStatement ps, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	Connection conn = null;

	PreparedStatement ps = null;

	ResultSet rs = null;

	// 五色清单应响应企业
	public Map<Integer, Integer> sql1(String i) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Integer shortcode = null;
		Integer count = null;
		try {
			this.conn = getConnection();	
			this.ps = this.conn.prepareStatement(prop.getProperty("sql1"));
			this.ps.setString(1,i);
			this.rs = this.ps.executeQuery();
			while (this.rs.next()) {
				shortcode = this.rs.getInt(1);
				count = this.rs.getInt(2);
				map.put(shortcode, count);
			}

			free(this.rs, this.ps, this.conn);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return map;
	}

	// 五色清单已响应企业
	public Map<Integer, Integer> sql2(String i) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Integer shortcode = null;
		Integer count = null;
		try {
			this.conn = getConnection();
			this.ps = this.conn.prepareStatement(prop.getProperty("sql2"));
			this.ps.setString(1,i);
			this.rs = this.ps.executeQuery();
			while (this.rs.next()) {
				shortcode = this.rs.getInt(1);
				count = this.rs.getInt(2);
				map.put(shortcode, count);
			}

			free(this.rs, this.ps, this.conn);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return map;
	}

	public List<String> sql3(String num1) {
		List<String> list = new ArrayList<>();
		try {
			this.conn = getConnection();
			this.ps = this.conn.prepareStatement(prop.getProperty("sql3"));
			this.ps.setString(1, num1);
			this.rs = this.ps.executeQuery();
			while (this.rs.next())
				list.add(this.rs.getString(prop.getProperty("ID")));
			free(this.rs, this.ps, this.conn);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return list;
	}

}
