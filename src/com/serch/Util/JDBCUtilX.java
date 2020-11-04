package com.serch.Util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

//连接池2
public class JDBCUtilX {
	private static Properties prop = new Properties();

	static {
		try {
			prop.load(JDBCUtilX.class.getClassLoader().getResourceAsStream("db.pro"));
			Class.forName(prop.getProperty("driver"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(prop.getProperty("OterUrl"), prop.getProperty("OterUn"),
				prop.getProperty("OterPw"));
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

	// 主表问题应回答数
	public Map<Integer, Integer> sql_a1(String time) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Integer shortcode = null;
		Integer count = null;
		try {
			this.conn = getConnection();
			this.ps = this.conn.prepareStatement(prop.getProperty("a1"));
			this.ps.setString(1,time);
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

	// 主表问题实际回答数
	public Map<Integer, Integer> sql_a2(String time) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Integer shortcode = null;
		Integer count = null;
		try {
			this.conn = getConnection();
			this.ps = this.conn.prepareStatement(prop.getProperty("a2"));
			this.ps.setString(1,time);
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

	//主表问题实际关闭数
	public Map<Integer, Integer> sql_a3(String time) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Integer shortcode = null;
		Integer count = null;
		try {
			this.conn = getConnection();
			this.ps = this.conn.prepareStatement(prop.getProperty("a3"));
			this.ps.setString(1,time);
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
	
	//子表问题应回答数
	public Map<Integer, Integer> sql_a4(String time) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Integer shortcode = null;
		Integer count = null;
		try {
			this.conn = getConnection();
			this.ps = this.conn.prepareStatement(prop.getProperty("a4"));
			this.ps.setString(1,time);
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
	
	//子表问题已回答数
	public Map<Integer, Integer> sql_a5(String time) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Integer shortcode = null;
		Integer count = null;
		try {
			this.conn = getConnection();
			this.ps = this.conn.prepareStatement(prop.getProperty("a5"));
			this.ps.setString(1,time);
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
	
	//子表问题满意度回复基数（分母）
	public Map<Integer, Integer> sql_a6(String time) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Integer shortcode = null;
		Integer count = null;
		try {
			this.conn = getConnection();
			this.ps = this.conn.prepareStatement(prop.getProperty("a6"));
			this.ps.setString(1,time);
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
	
	//子表问题满意度回复满意数（分子）
	public Map<Integer, Integer> sql_a7(String time) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Integer shortcode = null;
		Integer count = null;
		try {
			this.conn = getConnection();
			this.ps = this.conn.prepareStatement(prop.getProperty("a7"));
			this.ps.setString(1,time);
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
	
	//本月填报家数
		public Map<Integer, Integer> sql_b1(String firstime,String nextime) {
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			Integer shortcode = null;
			Integer count = null;
			try {
				this.conn = getConnection();
				this.ps = this.conn.prepareStatement(prop.getProperty("b1"));
				this.ps.setString(1,firstime);
				this.ps.setString(2,nextime);
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

		//应填报企业数
				public Map<Integer, Integer> sql_b2() {
					Map<Integer, Integer> map = new HashMap<Integer, Integer>();
					Integer shortcode = null;
					Integer count = null;
					try {
						this.conn = getConnection();
						this.ps = this.conn.prepareStatement(prop.getProperty("b2"));
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
				
				
				//上期发货金额
				public Map<Integer, Double> sql_b3(String lastime,String firstime,String time) {
					Map<Integer, Double> map = new HashMap<Integer, Double>();
					Integer shortcode = null;
					Double count = null;
					try {
						this.conn = getConnection();
						this.ps = this.conn.prepareStatement(prop.getProperty("b3"));
						this.ps.setString(1,lastime);
						this.ps.setString(2,firstime);
						this.ps.setString(3,time);
						this.rs = this.ps.executeQuery();
						while (this.rs.next()) {
							shortcode = this.rs.getInt(1);
							count = this.rs.getDouble(2);
							map.put(shortcode, count);
						}

						free(this.rs, this.ps, this.conn);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					return map;
				}
				
				//本年累计金额
				public Map<Integer, Double> sql_b4(String nextyear,String firstyear,String time) {
					Map<Integer, Double> map = new HashMap<Integer, Double>();
					Integer shortcode = null;
					Double count = null;
					try {
						this.conn = getConnection();
						this.ps = this.conn.prepareStatement(prop.getProperty("b4"));
						this.ps.setString(1,nextyear);
						this.ps.setString(2,firstyear);
						this.ps.setString(3,time);
						this.rs = this.ps.executeQuery();
						while (this.rs.next()) {
							shortcode = this.rs.getInt(1);
							count = this.rs.getDouble(2);
							map.put(shortcode, count);
						}

						free(this.rs, this.ps, this.conn);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					return map;
				}
				
				//本月累计金额
				public Map<Integer, Double> sql_b5(String nextime,String firstyear,String time) {
					Map<Integer, Double> map = new HashMap<Integer, Double>();
					Integer shortcode = null;
					Double count = null;
					try {
						this.conn = getConnection();
						this.ps = this.conn.prepareStatement(prop.getProperty("b5"));
						this.ps.setString(1,nextime);
						this.ps.setString(2,firstyear);
						this.ps.setString(3,time);
						this.rs = this.ps.executeQuery();
						while (this.rs.next()) {
							shortcode = this.rs.getInt(1);
							count = this.rs.getDouble(2);
							map.put(shortcode, count);
						}

						free(this.rs, this.ps, this.conn);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					return map;
				}
				
				//本期发货金额
				public Map<Integer, Double> sql_b6(String firstime,String nextime,String time) {
					Map<Integer, Double> map = new HashMap<Integer, Double>();
					Integer shortcode = null;
					Double count = null;
					try {
						this.conn = getConnection();
						this.ps = this.conn.prepareStatement(prop.getProperty("b6"));
						this.ps.setString(1,firstime);
						this.ps.setString(2,nextime);
						this.ps.setString(3,time);
						this.rs = this.ps.executeQuery();
						while (this.rs.next()) {
							shortcode = this.rs.getInt(1);
							count = this.rs.getDouble(2);
							map.put(shortcode, count);
						}

						free(this.rs, this.ps, this.conn);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					return map;
				}
		
}
