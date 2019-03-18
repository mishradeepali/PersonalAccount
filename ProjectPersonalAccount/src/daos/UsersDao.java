package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojos.UsersPojo;
import utilities.ConnectionPool;

public class UsersDao {
	public void create(UsersPojo category) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into users (username,password,name,address,mobile,email) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category.getUsername());
			ps.setString(2, category.getPassword());
			ps.setString(3, category.getName());
			ps.setString(4, category.getAddress());
			ps.setString(5, category.getMobile());
			ps.setString(6, category.getEmail());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(UsersPojo category) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update users set username = ?, password = ?,name = ? , address = ?,mobile = ?,email = ? where uid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category.getUsername());
			ps.setString(2, category.getPassword());
			ps.setString(3, category.getName());
			ps.setString(4, category.getAddress());
			ps.setString(6, category.getEmail());
			ps.setString(5, category.getMobile());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int categoryId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from users where uid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	
	public UsersPojo find(int categoryId) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		UsersPojo category = new UsersPojo();
		try {
			String sql = "select * from users where uid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				category.setUid(categoryId);
				category.setUsername(rs.getString("username"));
				category.setPassword(rs.getString("password"));
				category.setName(rs.getString("name"));
				category.setAddress(rs.getString("address"));
				category.setMobile(rs.getString("mobile"));
				category.setEmail(rs.getString("email"));
				
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return category;
	}
	public static int checkAvailability(String uname) {
		int id = -1;
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "select uid from users where name = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt("uid");
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return id;
	}
	public static int checkAvailability(String uname,String pwd) {
		int id = -1;
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "select uid from users where username = ? and password = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt("uid");
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return id;
	}
	
	public static UsersPojo  authenticate(String uname,String pwd) {
		int id = -1;
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		UsersPojo category = new UsersPojo();
		try {
			String sql = "select * from users where username = ? and password = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				id = rs.getInt("uid");
				category.setUid(rs.getInt("uid"));
				category.setUsername(rs.getString("username"));
				category.setPassword(rs.getString("password"));
				category.setName(rs.getString("name"));
				category.setAddress(rs.getString("address"));
				category.setMobile(rs.getString("mobile"));
				category.setEmail(rs.getString("email"));
					
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return category;
	}
	
	public ArrayList<UsersPojo> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<UsersPojo> listCategory = new ArrayList<UsersPojo>();
		try {
			String sql = "select * from users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				UsersPojo category = new UsersPojo();
				category.setUid(rs.getInt("uid"));
				category.setUsername(rs.getString("username"));
				category.setPassword(rs.getString("password"));
				category.setName(rs.getString("name"));
				category.setName(rs.getString("address"));
				category.setMobile(rs.getString("mobile"));
				category.setEmail(rs.getString("email"));
				
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the record." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listCategory;
	}

	
		public static void main(String args[]) {
//			UsersDao d = new UsersDao();
//			UsersPojo p = new UsersPojo("tanya","tanya","tany","shivpuri","6878894444","tanya.610@gmail.com");
//			d.create(p);
//			
//			UsersDao d = new UsersDao();
//		UsersPojo p = new UsersPojo(2,"cloth","kurti",58);
//			d.edit(p);
			
//			UsersDao d = new UsersDao();
//			d.remove(3);
//			
//			UsersDao d = new UsersDao();
//			UsersPojo p = new UsersPojo();
//			d.find(2);
//			System.out.println(p);
//			
//			UsersDao d = new UsersDao();
//			ArrayList<UsersPojo> al = d.findAll();
//			for (UsersPojo category : al) {
//				System.out.println(category);
			
//			}
			
//			System.out.println(checkAvailability("tany"));
			System.out.println(checkAvailability("tanya","tanya"));
//			UsersDao d = new UsersDao();
//			UsersPojo p = d.authenticate("tanya","tanya");
//			System.out.println(p);
		}
}

