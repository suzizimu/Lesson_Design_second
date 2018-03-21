package com.su_back.util;

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

/**
 * 说明：数据库工具类
 *
 * @author 苏先生
 *
 */
public class DBUtil {
	private static final String DRIVER = "com.mysql.jdbc.Driver"; // mysql驱动
	private static final String URL = "jdbc:mysql://localhost:3306/design_second"; // mysql
	// url
	private static final String USER = "root"; // 数据库用户名
	private static final String PASSWORD = "mysql"; // 数据库密码
	private static Connection conn = null;

	// 静态代码块?为什么使用静态代码块？
	static {
		// 1.加载去驱动
		try {
			Class.forName(DBUtil.DRIVER);
			System.out.println("=======加载驱动成功=========");
		} catch (ClassNotFoundException e) {
			System.out.println("DBUtil工具类-->加载驱动失败:" + e.getMessage());
		}
	}

	// 2.获取连接
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(DBUtil.URL, DBUtil.USER, DBUtil.PASSWORD);
		} catch (SQLException e) {
			System.out.println("DBUtil工具类-->获取连接失败,原因为:" + e.getMessage());
		}
		return null;
	}

	/**
	 * 多个问号，使用预处理方式进行添加/修改/和删除操作
	 *
	 * @param sql
	 *            预处理方式
	 * @param args
	 *            传递的参数
	 * @return
	 */
	//? ? ?
	public static int executeUpdate(String sql, Object[] args) {
		PreparedStatement ps = null;
		try {
			ps = DBUtil.getConnection().prepareStatement(sql);
			// 判断args
			if (args != null && args.length > 0) {
				for (int i = 0; i < args.length; i++) {
					ps.setObject(i + 1, args[i]);
				}
			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(DBUtil.conn, ps, null);
		}
		return -1;
	}

	/**
	 * 一个问号，使用预处理方式进行添加/修改/和删除操作
	 *
	 * @param sql
	 *            预处理方式有一个问号
	 * @param arg
	 *            参数
	 * @return
	 */
	public static int executeUpdate(String sql, Object arg) {
		return DBUtil.executeUpdate(sql, new Object[] { arg });
	}

	/**
	 * 没有问号，使用预处理方式进行添加/修改/和删除操作
	 *
	 * @param sql
	 * @return
	 */
	public static int executeUpdate(String sql) {
		return DBUtil.executeUpdate(sql, null);
	}

	// 结果集封装list
	public static List<Map<String, Object>> list(String sql, Object[] args) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = DBUtil.getConnection().prepareStatement(sql); // 预编译语句对象
			// 判断
			if (args != null && args.length > 0) {
				for (int i = 0; i < args.length; i++) {
					ps.setObject(i + 1, args[i]);
				}
			}

			rs = ps.executeQuery();

			ResultSetMetaData rsmd = ps.getMetaData();// 获取数据结构
			// 获得结果集列数
			int columnCount = rsmd.getColumnCount();// 获取列数
			// 构造泛型结果集
			List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();

			// 循环结果集
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 1; i <= columnCount; i++) {
					String k = rsmd.getColumnLabel(i);// 规则查询出来的字段都是小写
					Object v = rs.getObject(k);
					map.put(k, v);
				}
				dataList.add(map);
			}
			return dataList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(DBUtil.conn, ps, rs);
		}

	}

	public static List<Map<String, Object>> list(String sql, Object arg) {
		return DBUtil.list(sql, new Object[] { arg });
	}

	public static List<Map<String, Object>> list(String sql) {
		return DBUtil.list(sql, null);
	}

	public static Map<String, Object> query(String sql, Object[] args) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = DBUtil.getConnection().prepareStatement(sql); // 预编译语句对象
			// 判断
			if (args != null && args.length > 0) {
				for (int i = 0; i < args.length; i++) {
					ps.setObject(i + 1, args[i]);
				}
			}

			rs = ps.executeQuery();

			ResultSetMetaData rsmd = ps.getMetaData();// 获取数据结构
			// 获得结果集列数
			int columnCount = rsmd.getColumnCount();// 获取列数
			// 构造泛型结果集
			Map<String, Object> map = new HashMap<String, Object>();

			// 循环结果集
			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					String k = rsmd.getColumnLabel(i);// 规则查询出来的字段都是小写
					Object v = rs.getObject(k);
					map.put(k, v);
				}

			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(DBUtil.conn, ps, rs);
		}

	}

	public static Map<String, Object> query(String sql, Object arg) {
		return DBUtil.query(sql, new Object[] { arg });
	}

	public static Map<String, Object> query(String sql) {
		return DBUtil.query(sql, null);
	}

	// 释放内存
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
