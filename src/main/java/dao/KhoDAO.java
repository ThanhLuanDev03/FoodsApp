package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.NguyenLieu;
import utils.XJdbc;

public class KhoDAO {

	public static ArrayList selectAll() {
		ArrayList<NguyenLieu> list = new ArrayList<NguyenLieu>();
		try {
			Connection con = XJdbc.getConnection();

			String sqlSelect = "select maNL, tenNL, donvi, dongia, soluong, giatrinhap, hansudung  from NguyenLieu";

			PreparedStatement pstmt = con.prepareStatement(sqlSelect);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String maNL = rs.getString("maNL");
				String tenNL = rs.getString("tenNL");
				String donvi = rs.getString("donvi");
				int dongia = rs.getInt("dongia");
				float soluong = rs.getFloat("soluong");
				int giatrinhap = rs.getInt("giatrinhap");
				String hansudung = rs.getString("hansudung");
				list.add(new NguyenLieu(maNL, tenNL, donvi, dongia, soluong, giatrinhap, hansudung));
			}

			XJdbc.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static int insert(NguyenLieu nl) {
		
		try {
			Connection con = XJdbc.getConnection();

			String sql = "INSERT INTO NguyenLieu (maNL, TenNL, donvi, dongia, soluong, giatrinhap, hansudung) VALUES (?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setString(1, nl.getMaNL());
			pstmt.setString(2, nl.getTenNL());
			pstmt.setString(3, nl.getDonvi());
			pstmt.setInt(4, nl.getDongia());
			pstmt.setFloat(5, nl.getSoluong());
			pstmt.setInt(6, nl.getGiatrinhap());
			pstmt.setString(7, nl.getHansudung());
			pstmt.executeUpdate();
			// Đóng kết nối (Close Connection).
			XJdbc.closeConnection(con);
		} catch (SQLException e) {
			return 0;
		}
		return 1;
	}

	public static int delete(String nl) {
		try {
			Connection con = XJdbc.getConnection();

			String sql = "DELETE FROM NguyenLieu WHERE maNL=?";

			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setString(1, nl);
			pstmt.executeUpdate();
			// Đóng kết nối (Close Connection).
			XJdbc.closeConnection(con);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int update(NguyenLieu nl) {
		try {
			Connection con = XJdbc.getConnection();

			String sql = "UPDATE NguyenLieu SET  tenNL=?, donvi=?, dongia=?, soluong=?, giatrinhap=?, hansudung=? WHERE maNL=?";

			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setString(1, nl.getTenNL());
			pstmt.setString(2, nl.getDonvi());
			pstmt.setInt(3, nl.getDongia());
			pstmt.setFloat(4, nl.getSoluong());
			pstmt.setInt(5, nl.getGiatrinhap());
			pstmt.setString(6, nl.getHansudung());
			pstmt.setString(7, nl.getMaNL());
			pstmt.executeUpdate();
			// Đóng kết nối (Close Connection).
			XJdbc.closeConnection(con);
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

	}

	public NguyenLieu selectById(String maNL) {
		NguyenLieu entity = new NguyenLieu();
	            try {
	            	Connection connection = XJdbc.getConnection();
	            	  String sql = "SELECT * FROM NguyenLieu WHERE maNL =?";
	            	 PreparedStatement statement = connection.prepareStatement(sql);
	      			statement.setString(1, maNL);
	      			ResultSet rs = statement.executeQuery();
	                while(rs.next()) {
	                    entity.setMaNL(rs.getString("maNL"));
	                    entity.setTenNL(rs.getString("tenNL"));
	                    entity.setDonvi(rs.getString("donvi"));
	                    entity.setDongia(rs.getInt("dongia"));
	                    entity.setSoluong(rs.getFloat("soluong"));
	                    entity.setSoluong(rs.getFloat("giatrinhap"));
	                    entity.setSoluong(rs.getFloat("hansudung"));
	                    
	                }
	          
	         
	        } catch (SQLException var10) {
	            throw new RuntimeException(var10);
	        }
	            return entity ;
	        
	    }
	public static ArrayList<NguyenLieu> selectAllTen(String str) {
		ArrayList<NguyenLieu> list = new ArrayList<NguyenLieu>();
		try {
			Connection con = XJdbc.getConnection();

			String sqlSelect = "select * from NguyenLieu where tenNL like ?";

			PreparedStatement pstmt = con.prepareStatement(sqlSelect);

			pstmt.setString(1, str.replaceAll("", "%"));
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String maNL = rs.getString("maNL");
				String tenNL = rs.getString("tenNL");
				String donvi = rs.getString("donvi");
				int dongia = rs.getInt("dongia");
				float soluong = rs.getFloat("soluong");
				int giatrinhap = rs.getInt("giatrinhap");
				String hansudung = rs.getString("hansudung");

				list.add(new NguyenLieu(maNL, tenNL, donvi, dongia, soluong, giatrinhap, hansudung));
			}
			// Đóng kết nối (Close Connection).
			XJdbc.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
