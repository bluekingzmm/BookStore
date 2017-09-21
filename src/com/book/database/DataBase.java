package com.book.database;

import java.sql.*;
import java.util.PropertyResourceBundle;
import java.util.Enumeration;

public class DataBase {

	private static String url; // 数据库连接字�?
	private static String userName; // 数据库用户名�?
	private static String driver; // 数据库驱动名�?
	private static String pwd; // 数据库用户登陆密�?
	private final static String fileName = "database"; // 属�?�文件名�?
	// ThreadLocal 当前线程�?部变�?
	@SuppressWarnings("rawtypes")
	private static ThreadLocal connection = new ThreadLocal();

	static {
		readConfig();
	}

	// getConn方法用于获取数据库连�?
	/**
	 * synchronized 控制对类成员变量的访问：每个类实例对应一把锁�? 每个 synchronized
	 * 方法都必须获得调用该方法的类实例的锁方能执行�? 否则�?属线程阻塞，方法�?旦执行，就独占该锁，直到从该方法返回时才
	 * 将锁释放，此后被阻塞的线程方能获得该锁，重新进入可执行状态�?�这种机�? 确保了同�?时刻对于每一个类实例，其�?有声明为 synchronized
	 * 的成员函�? 中至多只有一个处于可执行状�?�（因为至多只有�?个能够获得该类实例对应的锁）�? 从�?�有效避免了类成员变量的访问冲突
	 */
	@SuppressWarnings("unchecked")
	public synchronized static Connection getConn() throws SQLException {
		Connection con = (Connection) connection.get();
		if (con != null && !con.isClosed()) {
			return con;
		}
		try {
			@SuppressWarnings("unused")
			Class providerClass = Class.forName(driver);
			con = DriverManager.getConnection(url, userName, pwd);
			// setAutoCommit
			// 将此连接的自动提交模式设置为给定状�?��?�如果连接处于自动提交模式下，则将执行其�?�? SQL 语句，并将这些语句作为单独的事务提交�?
			// 否则，其 SQL 语句将成组地进入通过调用 commit 方法�? rollback
			// 方法终止的事务中。默认情况下，新的连接处于自动提交模式下�?
			con.setAutoCommit(false);
			connection.set(con);
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 读取配置文件信息
	@SuppressWarnings("unchecked")
	private static void readConfig() {
		// PropertyResourceBundle使用属�?�文件中的静态字符串集合来管理语�?环境资源�?
		PropertyResourceBundle prb = (PropertyResourceBundle) PropertyResourceBundle.getBundle(fileName);
		// 枚举Enumeration
		Enumeration enu = prb.getKeys();
		while (enu.hasMoreElements()) {
			String propertyName = enu.nextElement().toString();
			// 读取配置文件中的静�?�字符串并且赋�?�给类成员变�?
			if (propertyName.equals("database.driver"))
				driver = prb.getString("database.driver");
			if (propertyName.equals("database.url"))
				url = prb.getString("database.url");
			if (propertyName.equals("database.username"))
				userName = prb.getString("database.username");
			if (propertyName.equals("database.password"))
				pwd = prb.getString("database.password");
		}
	}

	// commit 使自从上�?次提�?/回滚以来进行的所有更改成为持久更改，并释放此 Connection 对象当前保存的所有数据库锁定�?
	// 此方法应该只在已禁用自动提交模式时使用�??
	public static void commit() {
		Connection con = (Connection) connection.get();
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 回滚事务
	public static void rollback() {
		Connection con = (Connection) connection.get();
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 释放数据库连�?
	public synchronized static void releaseConnection(Connection connection) {
		try {
			if (connection != null && !connection.isClosed())
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection = null;
	}

	// 关闭连接
	public static void free(PreparedStatement ps) {

		try {
			if (ps != null)
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void free(ResultSet rs, PreparedStatement ps) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		try {
			DataBase.getConn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
